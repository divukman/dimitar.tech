package tech.dimitar.dynamicbeans.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * Runner class that will print out (to std out) the list of bean properties read by AppProperties.
 */
//@Component
public class PrintAppPropertiesRunner implements CommandLineRunner {

    @Autowired
    private AppPropertiesHolder appPropertiesHolder;

//    @Resource(name="customBean0ID")
//    CustomBeanToBeInjected customBean0ID;


    @Override
    public void run(String... args) {
        System.out.println("*******************************************************");
        System.out.println("Config from properties:");
        System.out.println("*************************");
        for ( AppPropertiesHolder.Bean beanConfig : appPropertiesHolder.getBeanList()) {
            System.out.println(beanConfig.toString());
        }
        System.out.println("*******************************************************");
    }
}
