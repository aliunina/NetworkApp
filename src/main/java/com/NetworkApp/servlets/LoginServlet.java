package com.NetworkApp.servlets;

import com.NetworkApp.entities.User;
import com.NetworkApp.DAOs.UserDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("views/login.jsp");
        requestDispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String login = request.getParameter("login");
        String password = request.getParameter("password");

        try {
            UserDAO userDAO = UserDAO.getInstance();

            User user = userDAO.findUserByLogin(login);
            String storedPassword = userDAO.findUserPasswordByLogin(login);

            PrintWriter writer = response.getWriter();
            if (user != null && password.equals(storedPassword)) {
                int roleID = user.getRole().getRoleId();
                if (roleID == 1) {
                    writer.println("You are authorized as User!");
                } else {
                    writer.println("You are authorized as Administrator!");
                }
            } else {
                writer.println("User does not exist or incorrect login/password.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
