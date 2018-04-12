package factoryBeanMethod;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    private static ApplicationContext context;
    
    public static void main(String[] args) {
        context = new ClassPathXmlApplicationContext("factory.xml");
        
        Message staticBean = (Message) context.getBean("staticBean");
        Message nonStaticBean = (Message) context.getBean("nonStaticBean");
        
        staticBean.showInfo();
        nonStaticBean.showInfo();
    }
}
