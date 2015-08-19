package com.maolei.springmvc.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@EnableWebMvc
public class MvcConfig extends WebMvcConfigurerAdapter {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/home").setViewName("home");
        registry.addViewController("/").setViewName("home");
        registry.addViewController("/logout").setViewName("home");
        registry.addViewController("/logout/success").setViewName("logout");
        registry.addViewController("/hello").setViewName("hello");
        registry.addViewController("/admin").setViewName("admin");
        registry.addViewController("/login").setViewName("login");
        registry.addViewController("/login/form").setViewName("login");
        registry.addViewController("/actor/actor").setViewName("actor/actor");
    }

}