package com.springjdbc.config;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBConnection {
    private static volatile DBConnection instance;
    private static Properties props;
    private Connection connection;

    private DBConnection() {
        try{
            connection = DriverManager.getConnection(props.getProperty("db.url"), props.getProperty("db.username"), props.getProperty("db.password"));
            if (connection != null) {
                System.out.println("Connection is establised");
            }

        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    static {
        //load The db>properties file
        props = new Properties();
        try {
            props.load(DBConnection.class.getClassLoader().getResourceAsStream("db.properties"));
            Class.forName(props.getProperty("db.driverClassName"));


        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException("faild to load DB Configuration", e);
        }
    }

    //static factory method
    public static DBConnection getInstance() {
        if (instance == null) {
            synchronized (DBConnection.class) {
                if (instance == null) {
                    instance = new DBConnection();
                }
            }
        }
        return instance;
    }

    public Connection getConnection() {
        return connection;
    }

    //close the operation
    public void closeConnection() {

        try {

            if (connection != null && !connection.isClosed()) {
                connection.close();
                System.out.println("Connection Closed");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}
