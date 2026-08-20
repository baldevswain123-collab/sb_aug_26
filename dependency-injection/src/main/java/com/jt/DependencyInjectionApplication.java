package com.jt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class DependencyInjectionApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(DependencyInjectionApplication.class, args);
		// Engine engine = context.getBean(Engine.class);
		// engine.startEngine();

		Car car = context.getBean(Car.class);	//(Main Class): Annotated with @SpringBootApplication. It bootstraps the Spring IoC container,
												//  retrieves the managed Car bean, and calls car.startCar() and car.stopCar().
		car.startCar();
		car.stopCar();
	}

}
