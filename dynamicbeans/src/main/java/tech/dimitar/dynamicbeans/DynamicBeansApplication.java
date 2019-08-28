package tech.dimitar.dynamicbeans;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import tech.dimitar.dynamicbeans.config.AppPropertiesHolder;
import tech.dimitar.dynamicbeans.config.EnableMyBeanFactory;
import tech.dimitar.dynamicbeans.config.MyBeanFactory;

@SpringBootApplication
@EnableConfigurationProperties(MyBeanFactory.class)
@EnableMyBeanFactory(path="classpath:aplication.properties")
public class DynamicBeansApplication {

	public static void main(String[] args) {
		SpringApplication.run(DynamicBeansApplication.class, args);
	}

}
