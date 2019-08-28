package tech.dimitar.dynamicbeans.config;

import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(value = RetentionPolicy.RUNTIME)
@Documented
@Import(MyBeanFactory.class)
public @interface EnableMyBeanFactory {
    String path() default "";
}