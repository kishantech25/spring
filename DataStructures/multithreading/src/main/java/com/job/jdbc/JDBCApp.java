package com.job.jdbc;

import com.job.DBConnection;

import java.sql.Connection;

public class JDBCApp {
    public static void main(String[] args) {
        Connection connection = DBConnection.getInstance().getConnection();

    }
}
