package com.springjdbc.dao;

import com.springjdbc.model.Accounts;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class AccountDAO {

    private JdbcTemplate jdbcTemplate;

    private final String SQl_NO_OF_ACCOUNTS="select Count(*) from account";
    private final String SQL_NO_OF_ACCOUNT_BY_STATUS="SELECT ACCOUNT_ID, ACCOUNT_NUMBER, NAME, PINCODE, BALANCE, STATUS FROM ACCOUNT WHERE ACCOUNT_NUMBER = ?";;
    private final String SQL_NO_OF_ACTIVE_ACC="SELECT ACCOUNT_ID, ACCOUNT_NUMBER, NAME, PINCODE, BALANCE, STATUS FROM ACCOUNT WHERE STATUS = ?";
    private final String QUERY_FOR_LIST_OF_ACCOUNT="SELECT NAME, BALANCE, FROM ACCOUNT";
    private final String SQL_FOR_ACCOUNT_BY_NAME="SELECT ACCOUNT_ID, ACCOUNT_NUMBER, NAME, PINCODE, BALANCE, STATUS FROM ACCOUNT order by NAME";

    public AccountDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void getAccouns() {
        PreparedStatementCreator creater = new PreparedStatementCreator() {
            private final String SQL_QUERY = "select * from account";

            @Override
            public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
                return con.prepareStatement(SQL_QUERY);

            }
        };

        PreparedStatementCallback<List<Accounts>> callBack = new PreparedStatementCallback<List<Accounts>>() {
            @Override
            public List<Accounts> doInPreparedStatement(PreparedStatement psmt) throws SQLException, DataAccessException {
                Accounts account = null;
                List<Accounts> accounts =new ArrayList<>();
                ResultSet rs = psmt.executeQuery();
                while(rs.next()) {
                    account = new Accounts();
                    account.setAccountId(rs.getInt("ACCOUNT_ID"));
                    account.setAccountNumber(rs.getString("ACCOUNT_NUMBER"));
                    account.setName(rs.getString("NAME"));
                    account.setPincode(rs.getString("PINCODE"));
                    account.setBalance(rs.getDouble("BALANCE"));
                    account.setStatus(rs.getString("STATUS"));
                    accounts.add(account);
                }
                return accounts;
            }
        };
            List<Accounts> accounts1 = (List<Accounts>)jdbcTemplate.execute(creater,callBack);
            accounts1.stream().forEach(System.out::println);
    }

    public void getNoOfAccount(){
        int count =jdbcTemplate.queryForObject(SQl_NO_OF_ACCOUNTS,Integer.class,new Object[]{});
        System.out.println("Total Number of Accounts is "+count);
    }
    public void findAccount(String accountNumber){
        RowMapper<Accounts> accountRowMapper =(rs,rowNum)->{
                Accounts accountBo = new Accounts();
                accountBo.setAccountId(rs.getInt("ACCOUNT_ID"));
                accountBo.setAccountNumber(rs.getString("ACCOUNT_NUMBER"));
                accountBo.setName(rs.getString("NAME"));
                accountBo.setPincode(rs.getString("PINCODE"));
                accountBo.setBalance(rs.getDouble("BALANCE"));
                accountBo.setStatus(rs.getString("STATUS"));
                return accountBo;
        };
        Accounts accountBos =jdbcTemplate.queryForObject(SQL_NO_OF_ACCOUNT_BY_STATUS, accountRowMapper,accountNumber);
        System.out.println(accountBos);
    }

    public void getAllActiveAccount(String status){
        RowMapper<List<Accounts>> activeAccountRowMapper =(rs,rowNum)->{
                List<Accounts> boList =new ArrayList<>();
                while(rs.next()){
                    Accounts accountBo = new Accounts();
                    accountBo.setAccountId(rs.getInt("ACCOUNT_ID"));
                    accountBo.setAccountNumber(rs.getString("ACCOUNT_NUMBER"));
                    accountBo.setName(rs.getString("NAME"));
                    accountBo.setPincode(rs.getString("PINCODE"));
                    accountBo.setBalance(rs.getDouble("BALANCE"));
                    accountBo.setStatus(rs.getString("STATUS"));
                    boList.add(accountBo);
                }
                return boList;
        };
        List<Accounts> accountList =jdbcTemplate.queryForObject(SQL_NO_OF_ACTIVE_ACC,activeAccountRowMapper,status);

        System.out.println("=========== ACTIVE Account list ===============");

        accountList.stream().forEach(System.out::println);
    }

public void getAccountBalance(){
        List<Map<String,Object>> accountListByName=jdbcTemplate.queryForList(QUERY_FOR_LIST_OF_ACCOUNT);

        for(Map<String,Object> accountBalance:accountListByName){
            for(String key:accountBalance.keySet()){
                System.out.println(key+"="+accountBalance.get(key)+"\t");
            }
            System.out.println();
        }
}



     public void getAccounts(){
        ResultSetExtractor<List<Accounts>> extractor =rs-> {
            int startIndex=0;
            int endIndex=3;
            int rowIndex=1;
            Accounts account=null;
            List<Accounts> accounts =null;

            accounts=new ArrayList<>();
            while(rs.next() && rowIndex<=endIndex) {
                if (rowIndex >= startIndex) {
                    account = new Accounts();
                    //SELECT ACCOUNT_ID, ACCOUNT_NUMBER, NAME, PINCODE, BALANCE, STATUS FROM order by NAME
                    account.setAccountId(rs.getInt("ACCOUNT_ID"));
                    account.setAccountNumber(rs.getString("ACCOUNT_NUMBER"));
                    account.setName(rs.getString("NAME"));
                    account.setPincode(rs.getString("PINCODE"));
                    account.setBalance(rs.getDouble("BALANCE"));
                    account.setStatus(rs.getString("STATUS"));
                    accounts.add(account);
                }
                rowIndex++;
            }

            return accounts;
        };
        System.out.println("=================== List of Accounts by name ========================");
        List<Accounts> accountList=jdbcTemplate.query(SQL_FOR_ACCOUNT_BY_NAME,extractor);
          for(Accounts bo:accountList){
              System.out.println(bo);
          }
    }



//    private static final class ActiveAccountRowMapper implements RowMapper<List<Accounts>>{
//        @Override
//        public List<Accounts> mapRow(ResultSet rs,int row) throws SQLException{
//            List<Accounts> boList =new ArrayList<>();
//            while(rs.next()){
//                Accounts accountBo = new Accounts();
//                accountBo.setAccountId(rs.getInt("ACCOUNT_ID"));
//                accountBo.setAccountNumber(rs.getString("ACCOUNT_NUMBER"));
//                accountBo.setName(rs.getString("NAME"));
//                accountBo.setPincode(rs.getString("PINCODE"));
//                accountBo.setBalance(rs.getDouble("BALANCE"));
//                accountBo.setStatus(rs.getString("STATUS"));
//                boList.add(accountBo);
//            }
//             return boList;
//        }
//
//     }


//    private static final class AccountRowMapper implements RowMapper<Accounts>{
//
//        @Override
//        public Accounts mapRow(ResultSet rs,int row) throws SQLException{
//            Accounts accountBo = new Accounts();
//            accountBo.setAccountId(rs.getInt("ACCOUNT_ID"));
//            accountBo.setAccountNumber(rs.getString("ACCOUNT_NUMBER"));
//            accountBo.setName(rs.getString("NAME"));
//            accountBo.setPincode(rs.getString("PINCODE"));
//            accountBo.setBalance(rs.getDouble("BALANCE"));
//            accountBo.setStatus(rs.getString("STATUS"));
//            return accountBo;
//        }
//    }



}
