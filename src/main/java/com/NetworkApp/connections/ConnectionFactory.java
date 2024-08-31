package com.NetworkApp.connections;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.io.FileInputStream;
import java.io.IOException;

public class ConnectionFactory {

    private final String path_to_file = "properties.txt";
    private String url;
    private String username;
    private String password;

    public ConnectionFactory() {
        Properties prop = new Properties();
        try {
            prop.load(new FileInputStream(path_to_file));
            this.url = prop.getProperty("url");
            this.username = prop.getProperty("username");
            this.password = prop.getProperty("password");
        } catch (IOException e) {
            System.out.println("Failed to load properties from file.");
            e.printStackTrace();
        }
    }

    public ProxyConnection createConnection() {
        try {
            ProxyConnection connection = new ProxyConnection(DriverManager.getConnection(url, username, password));
            return connection;
        } catch (SQLException e) {
            System.out.println("Failed to create a new connection.");
            e.printStackTrace();
            return null;
        }
    }
}
