package com.job;

import java.sql.Connection;

public class ConnectionHolder {

    private Connection connection;
    private boolean available = false;

    public synchronized void setConnection(Connection connection) {

        while (available) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return;
            }
        }

        this.connection = connection;
        available = true;

        System.out.println(Thread.currentThread().getName()
                + " established DB Connection.");

        notifyAll();
    }

    public synchronized Connection getConnection() {

        while (!available) {

            try {
                System.out.println(Thread.currentThread().getName()
                        + " waiting for DB Connection...");

                wait();

            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new RuntimeException(e);
            }

        }

        available = false;

        notifyAll();

        return connection;
    }
}
