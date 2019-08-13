package tech.dimitar.dynamicbeans;

import org.springframework.context.annotation.Import;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(value = RetentionPolicy.RUNTIME)
@Import(MyBeanFactory.class)
public @interface EnableMyBeanFactory {}