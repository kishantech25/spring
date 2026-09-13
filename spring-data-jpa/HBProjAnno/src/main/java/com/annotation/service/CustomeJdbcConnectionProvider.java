package com.annotation.service;

import com.annotation.util.HibernateUtil;
import org.hibernate.engine.jdbc.connections.spi.ConnectionProvider;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class CustomeJdbcConnectionProvider implements ConnectionProvider {
    @Override
    public Connection getConnection() throws SQLException {
        System.out.println("getConnection");
        Connection conn=null;
        try
        {
            //load the driver class
            Class.forName("com.mysql.cj.jdbc.Driver");
            //create the connection
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/datajpadb","root","Mysql$123");


        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        catch (ClassNotFoundException e)
        {
            e.printStackTrace();
        }
        return conn;
    }

    @Override
    public void closeConnection(Connection conn) throws SQLException {
      System.out.println("closeConnection(-)");
      conn.close();

    }

    @Override
    public boolean supportsAggressiveRelease() {
        return false;
    }

    @Override
    public boolean isUnwrappableAs(Class unwrapType) {
        System.out.println("isUnwrappledAs(-)");
        return false;
    }

    @Override
    public <T> T unwrap(Class<T> unwrapType) {
        System.out.println("unwrap(-)");

        return null;
    }
}
