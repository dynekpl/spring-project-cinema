package pl.kodolamacz.spring;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * Created by acacko on 29.10.17
 */
public class ApplicationConfig {

    public static void main(String[] args) {

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("application.xml");

        Application application = context.getBean(Application.class);
        application.simulate();

        context.close();

    }
}
