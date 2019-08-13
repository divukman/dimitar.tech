package tech.dimitar.spring.properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class PrintPropertiesRunner implements CommandLineRunner {

    @Autowired
    private AppPropertiesArray appPropertiesArray;

    @Value("${app.config.message}")
    private String message;

    @Autowired
    @Qualifier("${app.config.customBeanName}")
    DummyBean dummyBean;



    @Bean(name="${app.config.customBeanName}")
    public DummyBean dummyBean() {
        return DummyBean.builder().text("I am a dummy bean.").build();
    }


    @Override
    public void run(String... args) {
        System.out.println(String.format("Message from properties: %s", message));

        System.out.println("Dummy bean: " + dummyBean.getText());

        System.out.println("*******************************************************");
        System.out.println("Array of properties:");
        System.out.println("*************************");
        for ( AppPropertiesArray.Bean beanConfig : appPropertiesArray.getBeanList()) {
            System.out.println(beanConfig.toString());
        }
        System.out.println("*******************************************************");
    }
}