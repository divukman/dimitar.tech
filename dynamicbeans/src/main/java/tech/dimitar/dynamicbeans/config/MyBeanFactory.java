package tech.dimitar.dynamicbeans.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.annotation.AnnotationAttributes;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.type.AnnotationMetadata;
import tech.dimitar.dynamicbeans.custombeans.CustomBeanToBeInjected;

import java.util.ArrayList;
import java.util.List;


@Configuration
@PropertySource("classpath:application.properties")
@EnableConfigurationProperties
@ConfigurationProperties(prefix="app.config") // from properties, find all app.config* values
public class MyBeanFactory implements ImportBeanDefinitionRegistrar {

    private List<AppPropertiesHolder.Bean> beans = new ArrayList<>();

    public static class Bean {
        private String name;
        private String text;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }

        @Override
        public String toString() {
            return "Bean{" +
                    "name='" + name + '\'' +
                    ", text='" + text + '\'' +
                    '}';
        }
    }

    public List<AppPropertiesHolder.Bean> getBeans() {
        return beans;
    }

    public void setBeans(List<AppPropertiesHolder.Bean> beans) {
        this.beans = beans;
    }

    public List<AppPropertiesHolder.Bean> getBeanList() {
        return beans;
    }

    @Override
    public void registerBeanDefinitions(AnnotationMetadata annotationMetadata, BeanDefinitionRegistry beanDefinitionRegistry) {

        String clsName = MyBeanFactory.class.getName();
        AnnotationAttributes attrs = AnnotationAttributes.fromMap(annotationMetadata.getAnnotationAttributes(clsName, false));

        if (!attrs.getString("path").equals("")) {
            String path = attrs.getString("path");
            ResourceLoader loader = new DefaultResourceLoader();
            Resource resource = loader.getResource(path);
            // you can get the value from your property files
        }

//        beans.stream().forEach( beanConfig-> {
//            BeanDefinition bd = new RootBeanDefinition(CustomBeanToBeInjected.class);
//            bd.getConstructorArgumentValues().addGenericArgumentValue(beanConfig.getText());
//            beanDefinitionRegistry.registerBeanDefinition(beanConfig.getName(), bd);
//        });
    }
}
