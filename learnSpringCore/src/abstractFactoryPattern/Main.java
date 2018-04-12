package abstractFactoryPattern;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    private static ApplicationContext context;
    
    public static void main(String[] args) {
        
        Computer pc = ComputerFactory.getComputer(new PCFactory("8 GB", "1 TB", "Core i7"));
        Computer server = ComputerFactory.getComputer(new ServerFactory("4 GB", "750 GB", "Core i3"));
        
        context = new ClassPathXmlApplicationContext("factory.xml");
        PCFactory pcTemp = (PCFactory) context.getBean("pc");   
        Computer pcAuto = ComputerFactory.getComputer(pcTemp);
        
        System.out.println("=====Abstract factory pattern=====");
        pc.showInfo();
        System.out.println("\n1. AbstractFactory PC Config: " + pc +"\n");
        server.showInfo();
        System.out.println("\n2. AbstractFactory Server Config: " + server +"\n");
        pcAuto.showInfo();
        System.out.println("\n3. Auto create PC from BeanFactory: " + pcAuto);
    }
    
}
