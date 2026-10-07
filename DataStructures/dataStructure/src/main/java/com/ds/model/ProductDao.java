package com.ds.model;

import com.ds.conn.MySqlConnection1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDao {

    public List<Product> getAllProducts(){
        List<Product> products =new ArrayList<>();

        String sql="select * FROM product";

        try{
            Connection connection= MySqlConnection1.mySqlConnection();

              PreparedStatement pstmt = connection.prepareStatement(sql);

              ResultSet resultSet= pstmt.executeQuery();

            while (resultSet.next()) {

                Product product = new Product();

                product.setProductId(
                        resultSet.getInt("product_id"));

                product.setProductName(
                        resultSet.getString("product_name"));

                product.setCategory(
                        resultSet.getString("category"));

                product.setBrand(
                        resultSet.getString("brand"));

                product.setPrice(
                        resultSet.getDouble("price"));

                product.setDiscountPercent(
                        resultSet.getDouble("discount_percent"));

                product.setsQuantity(
                        resultSet.getInt("stock_quantity"));

                product.setRating(
                        resultSet.getDouble("rating"));

                product.setReviewCount(
                        resultSet.getInt("review_count"));

                product.setSku(
                        resultSet.getString("sku"));

                product.setStatus(
                        resultSet.getString("status"));

                products.add(product);
            }

        }catch (SQLException e){
            e.printStackTrace();
        }
        return products;
    }
}
