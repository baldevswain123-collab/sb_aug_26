package com.jt;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Primary
@Component("petrol")
public class PetrolEngine implements Engine{

    @Override                                             //The @Override annotation informs the Java compiler that a method is intended 
    //                                                      to override a method from a parent class or implement a method from 
    //                                                      an interface (such as startEngine() from Engine in your code).
    public void startEngine() {
        // TODO Auto-generated method stub
    System.out.println("Petrol Engine Starting");           //​PetrolEngine.java (Implementation): Implements the Engine interface 
                                                            // and is annotated with @Component so Spring manages it as a bean.
                                                            // It contains the actual execution logic (e.g., printing "Petrol Engine Starting").

    }

    @Override
    public void stopEngine() {
        // TODO Auto-generated method stub
    System.out.println("Petrol Engine Sopping");
    }

    
}
