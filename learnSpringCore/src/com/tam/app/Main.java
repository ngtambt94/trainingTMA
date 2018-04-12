package com.tam.app;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    private static ApplicationContext context;

    public static void main(String[] args) {
        context = new ClassPathXmlApplicationContext("Beans.xml");
        CountryCollection object = (CountryCollection) context.getBean("countryCollection");
        
        object.getCountryList();
        object.getCountrySet();
        object.getCountryMap();
        object.getCountryProp();
        System.out.println(object.toString());
    }
    
}
