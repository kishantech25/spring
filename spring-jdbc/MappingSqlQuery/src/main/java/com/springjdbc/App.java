package com.springjdbc;

import com.springjdbc.config.ClassicApproachConfig;
import com.springjdbc.dao.StatatementDAO;
import com.springjdbc.model.Statement;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;
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
        Statement st =new Statement();
        st.setStatementId(1082911);
        st.setAccountId(401);
        st.setTxnDateTime( Timestamp.valueOf(LocalDateTime.now()));
        st.setSummary("ATM Withdrawal");
        st.setDebit(BigDecimal.valueOf(747748.0));
        st.setCredit(BigDecimal.valueOf(747748.0));
        st.setBalance(BigDecimal.valueOf(747748.0));
        System.out.println(stDAO.insertStatement(st));


//        AccountDAO accountDAO=context.getBean("accountDAO",AccountDAO.class);
//        accountDAO.getAccouns();
//        accountDAO.getNoOfAccount();
//        accountDAO.findAccount("100000000001");
//        accountDAO.getAllActiveAccount("ACTIVE");
//       accountDAO.getAccounts();

    }
}
