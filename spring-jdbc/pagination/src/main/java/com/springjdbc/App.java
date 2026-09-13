package com.springjdbc;


import com.springjdbc.config.DBConnection;
import com.springjdbc.dao.AccountsDao;
import com.springjdbc.model.Accounts;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


/**
 * Hello world!
 *
 */
public class App 
{
//    public static void main( String[] args ) throws SQLException {
//
////        Accounts account=new Accounts();
////        account.setId(99830800);
////        account.setAccountHolderName("KishanKumar_123");
////        account.setBalance(100000.0);
//
//        AccountsDao dao=new AccountsDao();
//     //  List<Accounts> accounts=dao.getAccountsList();
//        Accounts account =dao.findAccountsByAccountHOlderName("AccountHolder_999999");
//
//    }

public static void main(String[] args) {

    //find duplicate Elements in List
    List<Integer>  list = Arrays.asList(1,2,3,4,5,6,7,8,9);

    Set<Integer> unique =new HashSet<>();
    list.stream()
            .filter(n->!unique.add(n))
            .forEach(System.out::println);

    //find the FIrst non Repated characters

}
}
