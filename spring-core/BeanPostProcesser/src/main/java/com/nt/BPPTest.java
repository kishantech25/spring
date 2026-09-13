package com.nt;

import com.nt.config.BeanPostProcesserConfig;
import com.nt.model.A;
import com.nt.model.B;
import com.nt.model.C;
import com.nt.statatistic.InstaaceTrackerBeanPostProcesser;
import com.nt.statatistic.InstanceStaticstics;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

public class BPPTest {

    public static void main(String[] args) {

       // ApplicationContext factory =new AnnotationConfigApplicationContext(BeanPostProcesserConfig.class);
        BeanFactory factory =new XmlBeanFactory(new ClassPathResource("spring-bean-configuration.xml"));
         //instatiate the  BeanPostProcesser Object
        BeanPostProcessor bpp =factory.getBean("instaaceTrackerBeanPostProcesser", InstaaceTrackerBeanPostProcesser.class);
         ((ConfigurableListableBeanFactory)factory).addBeanPostProcessor(bpp);
        A a =factory.getBean("a",A.class);
        B b =factory.getBean("b",B.class);
        C c =factory.getBean("c",C.class);
        System.out.println("Total Object "+ InstanceStaticstics.getInstance());
    }

}
