package com.jt;

import org.springframework.stereotype.Component;

 @Component
// public class Engine {
//     public void startEngine(){
//         System.out.println("Engine is starting");
//     }                                                                //​Engine.java (Interface): Defines the contract
//                                                                      // with startEngine() and stopEngine() methods.

// public void stopEngine(){
//     System.out.println("Engine is stoppimg");
// }
// }

public interface Engine {
    void startEngine();
    void stopEngine();
}
