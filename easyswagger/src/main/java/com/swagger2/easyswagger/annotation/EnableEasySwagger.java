package com.swagger2.easyswagger.annotation;

import com.swagger2.easyswagger.entity.EasySwaggerConfig;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
@Import({EasySwaggerConfig.class})
@Documented
public @interface EnableEasySwagger {
}
