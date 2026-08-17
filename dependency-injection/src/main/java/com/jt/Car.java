package com.jt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Car {
        private Engine engine;
         
        //DT(Dependency Injection)
        //DI is a mechanism in which Spring Contanier automatically inject the bean inside a class reference variable 
        //In simple words Spring Container automatically assigns the adress of the bean inside another class reference variable

        // 1 . Field Based Injection - not recomended
        // @Autowired // dependency injection
        // private Engine engine;

        // 2 . Setter Method Based Injection - recomended
        // private Engine engine;
        // @Autowired
        // public void setEngine(Engine engine){
        //     // System.out.println("parameter engine" +engine);
        //     // System.out.println("variable engine" +this.engine);
        //     this.engine = engine;
        // }

        // 3 . Consturctor Based Injection - higher recomended
        // private Engine engine;
 
        @Autowired
        public Car(Engine engine){
            this.engine = engine;
            System.out.println("parameterized constructor");
        }

        public Car(){
            System.out.println("Non parameterized constructor");
        }
        
    public void startCar(){
       // Engine engine = new Engine();
        engine.startEngine();

        System.out.println("Car is Stoped");
    }

    public void stopCar(){
        //Engine engine = new Engine();
        engine.startEngine();

        System.out.println("Car is Stoped");
    
    }
}
