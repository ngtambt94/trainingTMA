package lazyLoad;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    
    private static ApplicationContext context;
    public static void main(String[] args) {
        context = new ClassPathXmlApplicationContext("lazyLoad.xml");
        System.out.println("Application context loaded!");
        Cat cat = (Cat) context.getBean("cat");
    }
    
}
