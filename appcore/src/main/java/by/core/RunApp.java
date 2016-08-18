package by.core;

import by.core.multitrading.BicycleFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;

/**
 * Created by Denis on 16.08.2016.
 */
public class RunApp {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("springXMLContext.xml");

        System.out.println("Loaded beans: ");

        String[] beanNames = context.getBeanDefinitionNames();
        Arrays.sort(beanNames);
        Arrays.stream(beanNames).forEach(System.out::println);

        BicycleFactory app = (BicycleFactory) context.getBean("bicycleFactory");
        app.setThreadCount(5);
        app.startFactoryWork();
    }
}
