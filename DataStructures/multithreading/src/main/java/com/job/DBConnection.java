package com.job;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class DBConnection {

    private static volatile DBConnection instance;

    private String url;
    private String username;
    private String password;

    private DBConnection() {
        loadProperties();
    }
    public static DBConnection getInstance() {
        if(instance == null) {
            synchronized (DBConnection.class) {
                if(instance  ==null) {
                    instance =new DBConnection();
                }
            }
        }
        return instance;
    }
    private void loadProperties() {
        Properties properties =new Properties();
        try {
            properties.load(DBConnection.class.getClassLoader().getResourceAsStream("db.properties"));

            url=properties.getProperty("db.url");
            username =properties.getProperty("db.username");
            password =properties.getProperty("db.password");

            String driver = properties.getProperty("db.driver");

            Class.forName(driver);
        }
        catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException("Failed to load database exception");
        }

    }
    public Connection getConnection() {
        try {
            return DriverManager.getConnection(url,username,password);
        }catch (Exception e) {
            throw new RuntimeException("unable to eastablish database connection.",e);
        }
    }
    public void closeConnection() {
        Connection conn=null;
        PreparedStatement pst=null;
        ResultSet rs =null;

        if(conn!=null) {
            try {
                conn.close();
            }
            catch (SQLException e) {
                // TODO: handle exception
                e.printStackTrace();
            }
        }
        if(pst!=null) {
            try {
                pst.close();
            }
            catch (Exception e) {
                // TODO: handle exception
            }
        }
        if(rs!=null) {
            try {
                rs.close();
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
