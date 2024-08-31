package com.NetworkApp.services;

import com.NetworkApp.DAOs.UserDAO;
import com.NetworkApp.entities.Role;
import com.NetworkApp.entities.Status;
import com.NetworkApp.entities.User;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;

public class UserService {
    private static final class UserServiceInstanceHolder {
        private static final UserService INSTANCE = new UserService();
    }

    public static UserService getInstance() {
        return UserServiceInstanceHolder.INSTANCE;
    }


    private String hashPassword(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hashedPassword = md.digest(password.getBytes());
            StringBuilder sb = new StringBuilder();
            for (byte b : hashedPassword) {
                sb.append(String.format("%02x", b));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
    public User signIn(String login, String password) {
        try {
            // Получение экземпляра UserDAO
            UserDAO userDAO = UserDAO.getInstance();

            // Проверка наличия пользователя
            User user = userDAO.findUserByLogin(login);
            String storedPassword = userDAO.findUserPasswordByLogin(login);

            if (user != null && hashPassword(password).equals(storedPassword)) {
                int roleID = user.getRole().getRoleId();
                if (roleID == 1) {
                    System.out.println("You are authorized as User!");
                } else {
                    System.out.println("You are authorized as Administrator!");
                }
                return user;
            } else {
                throw new IllegalArgumentException("User does not exist or incorrect login/password.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public User signUp(String login, String password, String name, String surname, String patronymic, String email, String phoneNumber) {
        // Создание объекта User
        User user = new User(0, new Status(1, "Active"), new Role(1, "User"),
                name, surname, patronymic, email, phoneNumber, login, password);

        try {
            // Получение экземпляра UserDAO
            UserDAO userDAO = UserDAO.getInstance();

            // Проверка наличия пользователя
            if (userDAO.findUserByLogin(login) == null) {
                // Регистрация нового пользователя
                userDAO.add(user, hashPassword(password));
                return user;
            } else {
                throw new IllegalArgumentException("This user already registered");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public User findUserByLogin(String login) {
        try {
            // Получение экземпляра UserDAO
            UserDAO userDAO = UserDAO.getInstance();

            // Поиск пользователя по логину
            User user = userDAO.findUserByLogin(login);

            return user;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    private boolean isStringValid(String... params) {
        for (String param : params) {
            if (param == null || param.trim().isEmpty()) {
                return false;
            }
        }
        return true;
    }
}