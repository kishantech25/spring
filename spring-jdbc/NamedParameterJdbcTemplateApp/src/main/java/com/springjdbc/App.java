package com.springjdbc;

import com.springjdbc.config.ClassicApproachConfig;
import com.springjdbc.dao.StatatementDAO;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

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
        List<Map<String,Object>> boList=stDAO.findStatement(13198);

        boList.stream().flatMap(map->map.values().stream())
                .forEach(value->System.out.println(value));

//        AccountDAO accountDAO=context.getBean("accountDAO",AccountDAO.class);
//        accountDAO.getAccouns();
//        accountDAO.getNoOfAccount();
//        accountDAO.findAccount("100000000001");
//        accountDAO.getAllActiveAccount("ACTIVE");
//       accountDAO.getAccounts();

    }
}
