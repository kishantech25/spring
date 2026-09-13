package com.factory.prossesor;

import com.factory.prossesor.conn.ConnectionManager;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )throws Exception
    {
        BeanFactory factory =new XmlBeanFactory(new ClassPathResource("spring-bean-config.xml"));

        //Applying logic before creating the bean object
        BeanFactoryPostProcessor procsser =factory.getBean("bfpp",BeanFactoryPostProcessor.class);
        procsser.postProcessBeanFactory((ConfigurableListableBeanFactory)factory);

        //creating an bean object
        ConnectionManager manager=factory.getBean("connectionManager",ConnectionManager.class);
        Connection conn=manager.getConnection();

        Statement st =conn.createStatement();
        ResultSet rs =st.executeQuery("select * from account");
         while(rs.next()){
             System.out.println("["+rs.getString(1)+","+rs.getString(2)+"rs");
         }
    }
}
