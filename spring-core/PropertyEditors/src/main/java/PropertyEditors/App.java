package PropertyEditors;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        BeanFactory factory =new XmlBeanFactory(new ClassPathResource("springbean.xml"));

        ((ConfigurableListableBeanFactory)factory).addPropertyEditorRegistrar(new CustomePropertyEditor());
         ScientificCalculator calculater=factory.getBean("scientificCalculater",ScientificCalculator.class);
         System.out.print(calculater);

    }
}
