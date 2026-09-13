package PropertyEditors;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Man {

    public static void main(String[] args) {

        ApplicationContext context =new ClassPathXmlApplicationContext("springbean.xml");

        Student student = context.getBean("student",Student.class);
        System.out.println(student);

    }
}
