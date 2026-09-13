package com.job.jdbc;

import com.job.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TransactionDemo {

    public static void main(String[] args) {
        System.out.println("========== JDBC Transaction Demo ==========\n");
        
        demonstrateSuccessfulTransaction();
        System.out.println("\n" + "=".repeat(50) + "\n");
        demonstrateRollbackTransaction();
        System.out.println("\n" + "=".repeat(50) + "\n");
        demonstrateSavepointTransaction();
        System.out.println("\n" + "=".repeat(50) + "\n");
        displayAllBooks();
    }

    // Successful transaction - COMMIT
    public static void demonstrateSuccessfulTransaction() {
        System.out.println("1. SUCCESSFUL TRANSACTION (Auto Commit Disabled - Manual Commit)");
        Connection conn = null;
        PreparedStatement pst = null;

        try {
            conn = DBConnection.getInstance().getConnection();
            conn.setAutoCommit(false);

            System.out.println("   Auto-commit disabled");
            System.out.println("   Executing INSERT operations...");

            String insertSQL = "INSERT INTO books (title, author) VALUES (?, ?)";
            pst = conn.prepareStatement(insertSQL);

            pst.setString(1, "Transaction Guide");
            pst.setString(2, "Kishan Kumar");
            pst.executeUpdate();
            System.out.println("   ✓ Inserted: Transaction Guide");

            pst.setString(1, "JDBC Programming");
            pst.setString(2, "Expert Developer");
            pst.executeUpdate();
            System.out.println("   ✓ Inserted: JDBC Programming");

            conn.commit();
            System.out.println("   ✓ Transaction COMMITTED successfully!");

        } catch (SQLException e) {
            if (conn != null) {
                try {
                    conn.rollback();
                    System.err.println("   ✗ Transaction ROLLED BACK due to error: " + e.getMessage());
                } catch (SQLException rollbackEx) {
                    rollbackEx.printStackTrace();
                }
            }
        } finally {
            closeResources(conn, pst, null);
        }
    }

    // Transaction with ROLLBACK on error
    public static void demonstrateRollbackTransaction() {
        System.out.println("2. TRANSACTION WITH ROLLBACK (Demonstrating Error & Rollback)");
        Connection conn = null;
        PreparedStatement pst = null;

        try {
            conn = DBConnection.getInstance().getConnection();
            conn.setAutoCommit(false);

            System.out.println("   Auto-commit disabled");
            System.out.println("   Executing first INSERT...");

            String insertSQL = "INSERT INTO books (title, author) VALUES (?, ?)";
            pst = conn.prepareStatement(insertSQL);

            pst.setString(1, "Java Basics");
            pst.setString(2, "Core Developer");
            pst.executeUpdate();
            System.out.println("   ✓ Inserted: Java Basics");

            System.out.println("   Executing second INSERT (will cause error)...");

            // Intentionally cause an issue to demonstrate rollback
            pst.setString(1, null); // Violates NOT NULL constraint
            pst.setString(2, "Expert Developer");
            pst.executeUpdate();

            conn.commit();
            System.out.println("   ✓ Transaction COMMITTED!");

        } catch (SQLException e) {
            if (conn != null) {
                try {
                    conn.rollback();
                    System.err.println("   ✗ Error occurred: " + e.getMessage());
                    System.out.println("   ✓ Transaction ROLLED BACK - All changes reverted!");
                } catch (SQLException rollbackEx) {
                    rollbackEx.printStackTrace();
                }
            }
        } finally {
            closeResources(conn, pst, null);
        }
    }

    // Transaction with Savepoint
    public static void demonstrateSavepointTransaction() {
        System.out.println("3. TRANSACTION WITH SAVEPOINT");
        Connection conn = null;
        PreparedStatement pst = null;

        try {
            conn = DBConnection.getInstance().getConnection();
            conn.setAutoCommit(false);

            System.out.println("   Auto-commit disabled");
            System.out.println("   Executing first INSERT...");

            String insertSQL = "INSERT INTO books (title, author) VALUES (?, ?)";
            pst = conn.prepareStatement(insertSQL);

            pst.setString(1, "Savepoint Demo Book 1");
            pst.setString(2, "Author One");
            pst.executeUpdate();
            System.out.println("   ✓ Inserted: Savepoint Demo Book 1");

            var savepoint = conn.setSavepoint("SP_1");
            System.out.println("   → SAVEPOINT SP_1 created");

            pst.setString(1, "Savepoint Demo Book 2");
            pst.setString(2, "Author Two");
            pst.executeUpdate();
            System.out.println("   ✓ Inserted: Savepoint Demo Book 2");

            try {
                pst.setString(1, null); // Will cause error
                pst.setString(2, "Author Three");
                pst.executeUpdate();
            } catch (SQLException e) {
                System.err.println("   ✗ Error at third insert: " + e.getMessage());
                conn.rollback(savepoint);
                System.out.println("   ✓ Rolled back to SP_1 - Only first two inserts retained");
            }

            conn.commit();
            System.out.println("   ✓ Transaction COMMITTED with partial rollback!");

        } catch (SQLException e) {
            if (conn != null) {
                try {
                    conn.rollback();
                    System.err.println("   ✗ Unexpected error: " + e.getMessage());
                } catch (SQLException rollbackEx) {
                    rollbackEx.printStackTrace();
                }
            }
        } finally {
            closeResources(conn, pst, null);
        }
    }

    // Display all books after transactions
    public static void displayAllBooks() {
        System.out.println("4. DISPLAYING ALL BOOKS");
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;

        try {
            conn = DBConnection.getInstance().getConnection();
            String query = "SELECT id, title, author FROM books";
            pst = conn.prepareStatement(query);
            rs = pst.executeQuery();

            System.out.println("\n   Books in Database:");
            System.out.println("   " + String.format("%-5s | %-30s | %-20s", "ID", "Title", "Author"));
            System.out.println("   " + "-".repeat(60));
            
            while (rs.next()) {
                int id = rs.getInt("id");
                String title = rs.getString("title");
                String author = rs.getString("author");
                System.out.println("   " + String.format("%-5d | %-30s | %-20s", id, title, author));
            }
        } catch (SQLException e) {
            System.err.println("   ✗ Error fetching books: " + e.getMessage());
            e.printStackTrace();
        } finally {
            closeResources(conn, pst, rs);
        }
    }

    private static void closeResources(Connection conn, PreparedStatement pst, ResultSet rs) {
        try {
            if (rs != null) rs.close();
            if (pst != null) pst.close();
            if (conn != null) {
                conn.setAutoCommit(true); // Reset to default
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
