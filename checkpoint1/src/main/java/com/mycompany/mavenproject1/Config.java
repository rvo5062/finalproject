/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject1;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.UrlBasedViewResolver;
import org.springframework.web.servlet.view.JstlView;

/**
 *
 * @author ryanoneill
 */
@Configuration
@EnableWebMvc
@ComponentScan("com.core.mavenproject1")
public class Config extends WebMvcConfigurerAdapter {
    
    @Bean
    public UrlBasedViewResolver setupViewResolver() {
        UrlBasedViewResolver resolver = new UrlBasedViewResolver();
        resolver.setPrefix("/views/");
        resolver.setSuffix(".jsp");
        resolver.setViewClass(JstlView.class);
        return resolver;
    }
    
    @Bean
    LoginBean loginBean() {
        return new LoginBean();
    }
    
    @Override
    public void addInterceptors(InterceptorRegistry registery) {
        registery.addInterceptor(new LoginInterceptor()).addPathPatterns("/login");
    }
}
