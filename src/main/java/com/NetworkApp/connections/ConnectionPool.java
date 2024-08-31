package com.NetworkApp.connections;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicBoolean;

public class ConnectionPool {
    private static ConnectionPool instance;
    private static final AtomicBoolean isInitialized = new AtomicBoolean(false);

    private final int POOL_SIZE = 8;

    private BlockingQueue<ProxyConnection> connectionQueue;
    private List<ProxyConnection> usedConnections;


    private ConnectionPool() {
        connectionQueue = new ArrayBlockingQueue<>(POOL_SIZE);
        usedConnections = new ArrayList<>();
        ConnectionFactory connectionFactory = new ConnectionFactory();

        for (int i = 0; i < POOL_SIZE; i++) {
            try {
                ProxyConnection connection = connectionFactory.createConnection();
                connectionQueue.offer(connection);
            } catch (NullPointerException e) {
                e.printStackTrace();
            }
        }
    }

    public static synchronized ConnectionPool getInstance() {
        while (instance == null) {
            if(isInitialized.compareAndSet(false, true))
                instance = new ConnectionPool();
        }
        return instance;
    }


    public ProxyConnection getConnection() {
        try {
            ProxyConnection connection = connectionQueue.take();
            usedConnections.add(connection);
            return connection;
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            return null;
        }
    }

    public void releaseConnection(ProxyConnection connection) {
        if (usedConnections.remove(connection)) {
            connectionQueue.offer(connection);
        } else {
            throw new IllegalArgumentException("Connection not found in the pool.");
        }
    }

    public void closeAllConnections() {
        for (ProxyConnection connection : usedConnections) {
            try {
                connection.close();
            } catch (SQLException e) {
                // Handle connection closing failure
                e.printStackTrace();
            }
        }

        usedConnections.clear();

        for (ProxyConnection connection : connectionQueue) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        connectionQueue.clear();
    }
}