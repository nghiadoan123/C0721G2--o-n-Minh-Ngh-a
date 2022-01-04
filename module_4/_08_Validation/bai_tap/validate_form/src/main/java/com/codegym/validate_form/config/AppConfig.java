package com.codegym.validate_form.config;


import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;

@Configuration
public class AppConfig {

    // dùng với cách implements Validator
    @Bean
    public MessageSource messageSource(){
        ResourceBundleMessageSource resourceBundleMessageSource = new ResourceBundleMessageSource();
        resourceBundleMessageSource.setBasenames("message/name_validate");
        return resourceBundleMessageSource;
    }
}
