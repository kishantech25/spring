package com.ds.conn;
import java.sql.Connection;
import java.sql.DriverManager;

public class MySqlConnection1 {

    public static Connection mySqlConnection() {

        try {
            Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/test_db",
                    "root",
                    "Wife@123"
            );

            if (conn != null) {
                System.out.println("Connection is established");
            }

            return conn;

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return null;
    }
}
