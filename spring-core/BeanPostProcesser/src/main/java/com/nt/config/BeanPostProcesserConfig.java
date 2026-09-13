package com.nt.config;

import com.nt.model.A;
import com.nt.model.B;
import com.nt.model.C;
import com.nt.statatistic.InstaaceTrackerBeanPostProcesser;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanPostProcesserConfig {

    @Bean("a")
    public A getA(){
       return new A(getB());
    }

    @Bean("b")
    public B getB(){
     return new B(getC());
    }

    @Bean("c")
    public C getC(){
      return new C();
    }
    @Bean("instaaceTrackerBeanPostProcesser")
    public InstaaceTrackerBeanPostProcesser getInstanceTrackerBeanPostProcceser(){
        InstaaceTrackerBeanPostProcesser trackerBeanPostProcesser=new InstaaceTrackerBeanPostProcesser();
         return trackerBeanPostProcesser;
    }

}
