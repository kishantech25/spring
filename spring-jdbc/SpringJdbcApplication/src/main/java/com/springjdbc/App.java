package com.springjdbc;

import com.springjdbc.config.ClassicApproachConfig;
import com.springjdbc.dao.AccountDAO;
import com.springjdbc.dao.StatatementDAO;
import com.springjdbc.model.Statement;
import com.springjdbc.util.StreamApiOperations;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;
import java.util.Map;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
       // ApplicationContext context=new ClassPathXmlApplicationContext("spring-bean-configuration.xml");
        ApplicationContext context = new AnnotationConfigApplicationContext(ClassicApproachConfig.class);
        StatatementDAO stDAO=context.getBean("statementDAO",StatatementDAO.class);

       List<Statement>  statements= stDAO.getStatements(100000,1);

        StreamApiOperations operations =new StreamApiOperations();
       operations.practice(statements);





        //        List<Map<String,Object>> boList=stDAO.findStatement(13198);
//
//        for(Map<String,Object> map:boList){
//            for(String key:map.keySet()){
//                System.out.println(map.get(key)+"\t");
//            }
//            System.out.println();
//        }

//        AccountDAO accountDAO=context.getBean("accountDAO",AccountDAO.class);
//        accountDAO.getAccouns();
//        accountDAO.getNoOfAccount();
//        accountDAO.findAccount("100000000001");
//        accountDAO.getAllActiveAccount("ACTIVE");
//       accountDAO.getAccounts();

    }
}
