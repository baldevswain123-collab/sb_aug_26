package com;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(value = "prototype")//It is a Scope of prototype
public class Teacher {
    public void sayHello(){
        System.out.println("Teacher says Hello");
    }

    //Custom Method 
    @Bean
    public CommandLineRunner commandLineRunner(){ //functional interface CommandLineRunner implicitly called Spring container
        return args ->{
            System.out.println("This method is callde after the Spring conatainer is initialized");
        };
    }
}
