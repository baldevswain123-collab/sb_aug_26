package com.jt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Car {
        //private Engine engine;
         
        //DT(Dependency Injection)
        //DI is a mechanism in which Spring Contanier automatically inject the bean inside a class reference variable 
        //In simple words Spring Container automatically assigns the adress of the bean inside another class reference variable

        // 1 . Field Based Injection - not recomended
        // @Autowired // dependency injection //Once a class is annotated with @Component, 
                                            // Spring can inject it into other classes using @Autowired
        // private Engine engine;           //​Car.java (Dependent Class): Annotated with @Component, representing a consumer of the Engine.
                                           //It uses Constructor-Based Dependency Injection (@Autowired) to receive an instance of Engine 
                                           // automatically from the Spring container without manually creating it using new .

        // 2 . Setter Method Based Injection - recomended
        // private Engine engine;
        // @Autowired
        // public void setEngine(Engine engine){
        //     // System.out.println("parameter engine" +engine);   
        //     // System.out.println("variable engine" +this.engine);
        //     this.engine = engine;
        // }

        // 3 . Consturctor Based Injection - higher recomended
         private Engine engine;
 
        @Autowired
        public Car(@Qualifier("petrol")Engine engine){
            this.engine = engine;                                       //​1.this.engine: Refers directly to the instance variable belonging to the Car object.
                                                                        //The engine instance variable exists in two places depending on whether 
                                                                        // you mean in the source code or in memory at run.
                                                                        //​2.engine (on the right): Refers to the local parameter passed into the constructor 
                                                                        // (the bean injected by Spring = Engine engine).
            System.out.println("parameterized constructor");
        }

        public Car(){
            System.out.println("Non parameterized constructor");
        }
        
    public void startCar(){
       // Engine engine = new Engine();
        engine.startEngine();

        System.out.println("Car is Started");
    }

    public void stopCar(){
        //Engine engine = new Engine();
        engine.startEngine();

        System.out.println("Car is Stoped");
    
    }
}
