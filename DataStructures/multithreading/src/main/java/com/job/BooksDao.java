package com.job;

import com.job.model.Books;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BooksDao {

    public List<Books> getBookData(Connection conn) {

        List<Books> books = new ArrayList<>();

        String sql = "SELECT id,title,author FROM books";

        try (PreparedStatement pst = conn.prepareStatement(sql);
             ResultSet rs = pst.executeQuery()) {

            while (rs.next()) {

                Books book = new Books();

                book.setId(rs.getInt("id"));
                book.setTitle(rs.getString("title"));
                book.setAuthor(rs.getString("author"));

                books.add(book);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return books;
    }
    public void saveBooks(final Books book, Connection conn) {
        String sql = "insert into books values(?, ?, ?)";

        try (PreparedStatement pst = conn.prepareStatement(sql)) {
            pst.setInt(1, book.getId());
            pst.setString(2, book.getTitle());
            pst.setString(3, book.getAuthor());

            int value = pst.executeUpdate();

            if (value == 1) {
                System.out.println("Saved Successfully");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void deleteBooks(int id,Connection conn) {
        String sql = "delete from books where id=?";

        try (PreparedStatement pst = conn.prepareStatement(sql)) {
            pst.setInt(1, id);
            int value = pst.executeUpdate();
            if (value == 1) {
                System.out.println("Deleted Successfully");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
    public Books updateBooks(Books book, Connection conn){
        Books book1=null;
        String sql ="Update books set title=? ,author=? where id=?";
        try(PreparedStatement pst =conn.prepareStatement(sql)){
            pst.setString(1, book.getTitle());
            pst.setString(2, book.getAuthor());
            pst.setInt(3, book.getId());
            int value = pst.executeUpdate();
            if (value == 1) {
                System.out.println("Updated Successfully");
            }
            book1 =getBooks(book.getId(),conn);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return book1;
    }

    public Books getBooks(int id,Connection conn){
        String sql= "select *  from books where id =?";
        try(PreparedStatement pst = conn.prepareStatement(sql)) {
            pst.setInt(1, id);
            try(ResultSet rs = pst.executeQuery()) {
                if (rs.next()) {
                    Books book = new Books();
                    book.setId(rs.getInt("id"));
                    book.setTitle(rs.getString("title"));
                    book.setAuthor(rs.getString("author"));
                    return book;
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        throw new RuntimeException("Book not found");
    }

}
