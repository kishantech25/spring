package com.methods;

import com.methods.model.PlanFinder;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

import java.util.Arrays;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        BeanFactory factory=new XmlBeanFactory(new ClassPathResource("springBeanConfig.xml"));
        PlanFinder finder =factory.getBean("planFinder",PlanFinder.class);
        String[] plans=finder.findPlan(1,10,"single");

        System.out.println(Arrays.toString(plans));

    }
}
