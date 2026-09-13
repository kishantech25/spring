package com.primitive;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

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
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-config.xml");
        Chip chip1 = (Chip) applicationContext.getBean("chip1",Chip.class);
        Chip chip2 = (Chip) applicationContext.getBean("chip2",Chip.class);
        Chip chip3 = (Chip) applicationContext.getBean("chip3",Chip.class);
        Chip chip5 = (Chip) applicationContext.getBean("chip5",Chip.class);
        Chip chip6 = (Chip) applicationContext.getBean("chip6",Chip.class);
        Chip chip7 = (Chip) applicationContext.getBean("chip7",Chip.class);
        Chip chip8 = (Chip) applicationContext.getBean("chip8",Chip.class);

        List<Chip> chips = Arrays.asList(chip1,chip2,chip3,chip5,chip6,chip7,chip8);
        StreamApiDemo dem=new StreamApiDemo();
        dem.m(chips);

    }
}
