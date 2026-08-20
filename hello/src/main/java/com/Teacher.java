package com;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(value = "prototype")//It is a Scope of prototype//The @Scope annotation in Spring is used to define the lifecycle and visibility of a Spring Bean. 
                            // It tells the Spring IoC (Inversion of Control) container how many instances of a class to create and when to create them.
                            //​By default, if you do not specify @Scope, Spring treats every bean as a Singleton.
public class Teacher {
    public void sayHello(){
        System.out.println("Teacher says Hello");
    }

    //Custom Method 
    @Bean //refer to custom bean creation using java configuration to run set up code automatically when the application starts
    public CommandLineRunner commandLineRunner(){ //functional interface CommandLineRunner implicitly called Spring container
        return args ->{ //provide the implementation for single abstract method of the interface
            System.out.println("This method is called after the Spring conatainer is initialized");
        };
    }
}
// //​Spring Container Starts: Spring scans components (Teacher, Student, etc.) and loads @Bean methods.
// ​Bean Created: Spring calls commandLineRunner() and stores the returned runner bean.
// ​Post-Initialization Trigger: Spring automatically invokes the runner's lambda code, printing:
// ​"This method is called after the Spring conatainer is initialized"