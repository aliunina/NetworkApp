package com.NetworkApp.DAOs;

import com.NetworkApp.connections.ConnectionPool;
import com.NetworkApp.entities.Role;
import com.NetworkApp.entities.Status;
import com.NetworkApp.entities.User;

import java.sql.*;
import java.util.concurrent.atomic.AtomicBoolean;

public class UserDAO {
    private static final String SQL_INSERT_USER =
            "INSERT INTO Users " +
            "(StatusID, RoleID, Name, Surname, Patronymic, Email, PhoneNumber, Login, Password) " +
            "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
    private static final String SQL_SELECT_USER_BY_LOGIN =
            "SELECT u.*, s.StatusName, r.RoleName " +
            "FROM Users u INNER JOIN Statuses s ON u.StatusID = s.StatusID " +
                    "INNER JOIN Roles r ON u.RoleID = r.RoleID WHERE u.login = ?";
    private static final String SQL_SELECT_USER_PASSWORD_BY_LOGIN = "SELECT Password FROM Users WHERE Login = ?";
    private static final AtomicBoolean isInitialized = new AtomicBoolean(false);

    private static UserDAO instance;
    private ConnectionPool connectionPool = ConnectionPool.getInstance();

    public static synchronized UserDAO getInstance() throws SQLException {
        while (instance == null) {
            if(isInitialized.compareAndSet(false, true))
                instance = new UserDAO();
        }
        return instance;
    }

    public void add(User user, String password) throws SQLException {
        Connection connection = connectionPool.getConnection();
        try (PreparedStatement statement = connection.prepareStatement(SQL_INSERT_USER, Statement.RETURN_GENERATED_KEYS)){
            statement.setInt(1, user.getStatus().getIdStatus());
            statement.setInt(2, user.getRole().getRoleId());
            statement.setString(3, user.getName());
            statement.setString(4, user.getSurname());
            statement.setString(5, user.getPatronymic());
            statement.setString(6, user.getEmail());
            statement.setString(7, user.getPhoneNumber());
            statement.setString(8, user.getLogin());
            statement.setString(9, password);
            statement.executeUpdate();

            ResultSet generatedKeys = statement.getGeneratedKeys();
            if (generatedKeys.next()) {
                user.setUserId(generatedKeys.getInt(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Возвращение соединения обратно в пул
            connection.close();
        }
    }

    public User findUserByLogin(String login) throws SQLException {
        User user = null;
        Connection connection = connectionPool.getConnection();
        try (PreparedStatement statement = connection.prepareStatement(SQL_SELECT_USER_BY_LOGIN)) {
            statement.setString(1, login);

            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                int userId = resultSet.getInt("UserID");
                int statusId = resultSet.getInt("StatusID");
                String statusName = resultSet.getString("StatusName");
                int roleId = resultSet.getInt("RoleID");
                String roleName = resultSet.getString("RoleName");
                String name = resultSet.getString("Name");
                String surname = resultSet.getString("Surname");
                String patronymic = resultSet.getString("Patronymic");
                String email = resultSet.getString("Email");
                String phoneNumber = resultSet.getString("PhoneNumber");
                String password = resultSet.getString("Password");
                user = new User(userId, new Status(statusId, statusName), new Role(roleId, roleName),
                        name, surname, patronymic, email, phoneNumber, login, password);
            }
        }

        return user;
    }


    public String findUserPasswordByLogin(String login) throws SQLException {
        String password = null;
        Connection connection = connectionPool.getConnection();
        try (PreparedStatement statement = connection.prepareStatement(SQL_SELECT_USER_PASSWORD_BY_LOGIN)) {
            statement.setString(1, login);

            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                password = resultSet.getString("password");
            }
        }

        return password;
    }


}
