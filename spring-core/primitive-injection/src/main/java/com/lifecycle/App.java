package com.lifecycle;

import com.primitive.Chip;
import com.primitive.StreamApiDemo;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

import java.util.Arrays;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
      //  ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-bean-config-cycle.xml");

       // Calcuater calculater =applicationContext.getBean("calculater",Calcuater.class);

      //  System.out.println(calculater);
     //  applicationContext.isSingleton();
        BeanFactory factory =new XmlBeanFactory(new ClassPathResource("spring-bean-config-cycle.xml"));

        Calcuater calculater1=factory.getBean("calculater", Calcuater.class);
        Calcuater calculater2 =factory.getBean("calculater",Calcuater.class);


        System.out.println(calculater1.hashCode() == calculater2.hashCode());
        System.out.println(calculater1.getClass().getClassLoader());

    }
}
