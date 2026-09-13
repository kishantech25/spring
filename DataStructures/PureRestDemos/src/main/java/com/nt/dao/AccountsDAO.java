package com.nt.dao;

import com.nt.config.Accounts;
import com.nt.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.Collections;
import java.util.List;

public class AccountsDAO {


    public Accounts getAccountById(Integer accountId){
        try(Session session =HibernateUtil.getSession()){
            Accounts account =session.get(Accounts.class,accountId);
            return account;
        }
    }
    public List<Accounts> getAllAccounts(){
        try(Session session = HibernateUtil.getSession()){

           List<Accounts> accounts= session.createQuery("from Accounts",Accounts.class).getResultList();
            return accounts !=null ? accounts : Collections.emptyList();
        }
        catch (Exception e){
            e.printStackTrace();
            return Collections.emptyList();
        }
    }
//    public Accounts getAccountByAccountNumber(String accountNumber){
//
//         if(accountNumber == null){
//             throw new IllegalArgumentException("Account Number can not be null");
//         }
//         try(Session session =HibernateUtil.getSession()){
//             Accounts accounts=session.get(Accounts.class,accountNumber);
//             return accounts;
//         }
//         catch (HibernateException e){
//             throw new RuntimeException("unable to Fetch account with id : "+accountNumber,e);
//         }
//    }
    public Integer createAccounts(Accounts account){

        Transaction tx = null;
        try(Session session =HibernateUtil.getSession()){
            tx =session.beginTransaction();
            Integer id =(Integer) session.save(account);
            tx.commit();
            return id;
        }catch (Exception e){
            if(tx!=null)
                tx.rollback();
            throw e;
        }
    }
    public Integer createAccount(Accounts account){
        Session session =null;
        Transaction tx=null;
        try{
            session =HibernateUtil.getSession();
            tx= session.beginTransaction();

            Integer id=(Integer) session.save(account);
            tx.commit();
            return id;
        }
        catch (Exception e){
            if(tx!=null)
                tx.rollback();
            throw e;
        }finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }
}
