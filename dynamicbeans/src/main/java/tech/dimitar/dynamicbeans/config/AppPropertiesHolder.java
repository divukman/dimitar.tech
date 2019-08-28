package tech.dimitar.dynamicbeans.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.util.ArrayList;
import java.util.List;

/**
 * Reads in the properties file and maps the properties to local fields/arrays.
 */

//@Configuration
//@EnableConfigurationProperties
//@PropertySource("classpath:application.properties")
//@ConfigurationProperties(prefix="app.config") // from properties, find all app.config* values
public class AppPropertiesHolder {

    private List<Bean> beans = new ArrayList<>();

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

    public List<Bean> getBeans() {
        return beans;
    }

    public void setBeans(List<Bean> beans) {
        this.beans = beans;
    }

    public List<Bean> getBeanList() {
        return beans;
    }
}
