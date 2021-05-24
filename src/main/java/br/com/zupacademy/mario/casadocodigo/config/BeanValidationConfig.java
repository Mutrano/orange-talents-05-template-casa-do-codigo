package br.com.zupacademy.mario.casadocodigo.config;

import java.util.Map;

import org.springframework.boot.autoconfigure.orm.jpa.HibernatePropertiesCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.Validator;

// code from https://gist.github.com/rponte/e6530d90e38a625874bf174d24abaaa0

@Configuration
public class BeanValidationConfig {

    /**
     * The idea here is to configure Hibernate to use the same ValidatorFactory used by Spring,  
     * so that Hibernate will be able to handle custom validations that need to use dependency injection (DI)
     */
    @Bean
    public HibernatePropertiesCustomizer hibernatePropertiesCustomizer(final Validator validator) {
        return new HibernatePropertiesCustomizer() {
            @Override
            public void customize(Map<String, Object> hibernateProperties) {
                hibernateProperties.put("javax.persistence.validation.factory", validator);
            }
        }; // or replace with lambda: return hibernateProperties -> hibernateProperties.put("javax.persistence.validation.factory", validator);
    }
}