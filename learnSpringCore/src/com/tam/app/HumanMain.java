package com.tam.app;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HumanMain {
    
    private static AbstractApplicationContext context;
    public static void main(String[] args) {
        context = new ClassPathXmlApplicationContext("Human.xml");
        context.registerShutdownHook();
    }
    
}
