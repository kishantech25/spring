package com.kk.SpringDemoApplication.repository;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@Repository
public class MoneyTransferRepository {

    @Value("oracle.jdbc.driver.OracleDriver")
    private String driveClass;

    @Value("jdbc:oracle:thin:@//localhost:1521/orcl")
    private String URL;

    @Value("hr")
    private String USER;

    @Value("oracle")
    private String PASSWORD;

    public void transferMoney(int fromAmount,int toAccount,double amount){
        Connection con =null;

        try{
            Class.forName(driveClass);
            con= DriverManager.getConnection(URL,USER,PASSWORD);

            //Transaction Starts
            con.setAutoCommit(false);
            PreparedStatement debit =
                     con.prepareStatement(
                             "UPDATE accounts1 SET balance = balance - ? WHERE account_no=?");
          debit.setDouble(1,amount);
          debit.setInt(2,fromAmount);

          int debitCount =debit.executeUpdate();

          PreparedStatement credit =con.prepareStatement( "UPDATE accounts1 SET balance = balance + ? WHERE account_no=?");
          credit.setDouble(1,amount);
          credit.setInt(2,toAccount);

          int creditCount =credit.executeUpdate();
          System.out.println("Debit count : "+debitCount);
          System.out.println("Credit count : "+creditCount);
          if(debitCount == 1 && creditCount == 1){
              con.commit();
              System.out.println("Money Transfer Successful");
          }else{
              con.rollback();
              System.out.println("Transaction Failed");
          }

        }catch (Exception e){
            try{
                if(con!=null){
                    con.rollback();
                }
            }catch (SQLException ex){
                ex.printStackTrace();
            }
            e.printStackTrace();
        }finally {
            try{
                if(con!=null){
                    con.setAutoCommit(true);
                    con.close();
                }
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
    }
}
