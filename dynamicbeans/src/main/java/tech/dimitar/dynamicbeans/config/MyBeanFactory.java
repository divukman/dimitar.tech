package tech.dimitar.dynamicbeans;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;
import tech.dimitar.dynamicbeans.custom.CustomBeanToBeInjected;


@Configuration
public class MyBeanFactory implements ImportBeanDefinitionRegistrar {

    @Autowired
    private AppPropertiesHolder appPropertiesHolder;


    @Override
    public void registerBeanDefinitions(AnnotationMetadata annotationMetadata, BeanDefinitionRegistry beanDefinitionRegistry) {
        appPropertiesHolder.getBeanList().stream().forEach( beanConfig-> {
            BeanDefinition bd = new RootBeanDefinition(CustomBeanToBeInjected.class);
            bd.getConstructorArgumentValues().addGenericArgumentValue(beanConfig.getText());
            beanDefinitionRegistry.registerBeanDefinition(beanConfig.getName(), bd);
        });
    }
}
