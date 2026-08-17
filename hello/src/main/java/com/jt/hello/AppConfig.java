package com.jt.hello;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class AppConfig {
    @Bean
    @Scope("prototype")
    public Student student(){
       // Student ss = new Student();
       // return ss;

        return new Student();
    }
}
