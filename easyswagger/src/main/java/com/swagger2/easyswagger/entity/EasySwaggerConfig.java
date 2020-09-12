package com.swagger2.easyswagger.entity;

import com.swagger2.easyswagger.core.Swagger2Hook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.WebApplicationContext;
import springfox.documentation.spring.web.DocumentationCache;

@Configuration
public class EasySwaggerConfig {
    @Autowired
    DocumentationCache documentationCache;
    @Autowired
    WebApplicationContext applicationContext;

    public EasySwaggerConfig() {
    }

    @Bean
    Swagger2Hook provideInit() {
        return new Swagger2Hook(documentationCache, applicationContext);
    }
}
