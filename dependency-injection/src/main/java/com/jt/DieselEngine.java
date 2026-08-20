package com.jt;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Primary
@Component
public class DieselEngine implements Engine{

    @Override
                                                 
    public void startEngine() {
        // TODO Auto-generated method stub
    System.out.println("Diesel Engine Starting");           //​PetrolEngine.java (Implementation): Implements the Engine interface 
                                                            // and is annotated with @Component so Spring manages it as a bean.
                                                            // It contains the actual execution logic (e.g., printing "Petrol Engine Starting").

    }

    @Override
    public void stopEngine() {
        // TODO Auto-generated method stub
    System.out.println("Diesel Engine Sopping");
    }

    
}

