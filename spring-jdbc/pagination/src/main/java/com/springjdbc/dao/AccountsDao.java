package com.springjdbc.dao;

import com.springjdbc.config.DBConnection;
import com.springjdbc.model.Accounts;

import javax.xml.transform.Result;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AccountsDao {
    //Curd operations
    //create

    public int saveAccounts(Accounts account) throws SQLException {
        PreparedStatement pstmt=null;
        //establish the connection
        DBConnection db =DBConnection.getInstance();
        Connection conn=db.getConnection();

        pstmt = conn.prepareStatement("insert into accounts(id,account_holder_name,balance)  values(?,?,?)");
        pstmt.setInt(1,account.getId());
        pstmt.setString(2,account.getAccountHolderName());
        pstmt.setDouble(3,account.getBalance());

        int rows =pstmt.executeUpdate();
        if(rows>0){
            System.out.print("accounts inserted into db");
        }
        else{
            System.out.println("Accounts not Inserted");
            throw new RuntimeException("Account is Not properly writenn ");
        }
       return rows;
    }

     public List<Accounts>  getAccountsList(){
        PreparedStatement pst =null;
         ResultSet rs =null;
         List<Accounts> accounts =null;
        long start =System.currentTimeMillis();
        try {
            DBConnection db = DBConnection.getInstance();
            Connection conn = db.getConnection();

            pst = conn.prepareStatement("select * from accounts");

            rs = pst.executeQuery();
            accounts = new ArrayList<>();
            while (rs.next()) {
                Accounts account = new Accounts();
                account.setId(rs.getInt("id"));
                account.setAccountHolderName(rs.getString("account_holder_name"));
                account.setBalance(rs.getDouble("balance"));
                accounts.add(account);
            }

            //close The pst
            pst.close();;
            conn.close();
            db.closeConnection();
        }
        catch (Exception e){
            e.printStackTrace();
        }
     //   accounts.stream().forEach(System.out::println);
        System.out.println(accounts.stream().count());
        long totalDuration = System.currentTimeMillis() -start;
        System.out.println("Total time duration has been taken : "+totalDuration);

        return accounts;

     }

     public Accounts findAccountsByAccountHOlderName(String accountHolderName){
         PreparedStatement pst=null;
         ResultSet rs =null;
         Accounts account=null;
         DBConnection db=null;
         Connection conn=null;
         long start =System.currentTimeMillis();
          try{
              db =DBConnection.getInstance();
              conn =db.getConnection();
              String qry ="select * from accounts where account_holder_name=?";

              pst =conn.prepareStatement(qry);
              pst.setString(1,accountHolderName);

              rs =pst.executeQuery();
              if(rs.next()){
                  account =new Accounts();
                  account.setId(rs.getInt("id"));
                  account.setAccountHolderName(rs.getString("account_holder_name"));
                  account.setBalance(rs.getDouble("balance"));
              }
          }
          catch (SQLException  e){
              e.printStackTrace();
          }
          finally {
                if(pst!=null){
                    try
                    {
                        pst.close();
                    }
                    catch (SQLException e){
                        e.printStackTrace();
                    }
                }
                if(conn!=null){
                    try{
                        conn.close();
                    }
                    catch (Exception e){
                        e.printStackTrace();
                    }
                }
              db.closeConnection();

          }
          long totalTime =System.currentTimeMillis() -start;
          System.out.println("Total Time Duration : "+totalTime+" ms");
          return account;
     }
}
