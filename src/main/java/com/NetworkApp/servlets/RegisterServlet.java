package com.NetworkApp.servlets;

import com.NetworkApp.DAOs.UserDAO;
import com.NetworkApp.entities.*;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

public class RegisterServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter writer = response.getWriter();
        writer.println("Method GET from RegisterServlet");
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("views/register.jsp");
        requestDispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        String name = request.getParameter("name");
        String surname = request.getParameter("surname");
        String patronymic = request.getParameter("patronymic");
        String email = request.getParameter("email");
        String phoneNumber = request.getParameter("phoneNumber");

        // Создание объекта User
        User user = new User(0, new Status(1, "Active"),
                new Role(1, "User"), name, surname, patronymic,
                email, phoneNumber, login, password);

        try {
            // Получение экземпляра UserDAO
            UserDAO userDAO = UserDAO.getInstance();

            // Проверка наличия пользователя
            if (userDAO.findUserByLogin(login) == null) {
                // Регистрация нового пользователя
                userDAO.add(user, password);

                RequestDispatcher requestDispatcher = request.getRequestDispatcher("index.html");
                requestDispatcher.forward(request, response);
            } else {
                PrintWriter writer = response.getWriter();
                writer.println("This user already registered");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}