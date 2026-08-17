package com.jt.hello;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;

import com.Teacher;

@ImportResource("beans.xml")
@SpringBootApplication
@ComponentScan(basePackages = {"com"})
public class HelloApplication { 

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(HelloApplication.class, args);//SpringApplication run is a Spring container
		
		//Using xml files  
		Greet greet = context.getBean(Greet.class);
		greet.sayHello();

		//Using Stereotype Annotation by use of @component Annotation
		Person person = context.getBean(Person.class);
		person.sayHello();

		//3.Using Configuration file
		Student student = context.getBean(Student.class);
		student.sayHello();

		Teacher teacher = context.getBean(Teacher.class);
		teacher.sayHello();

		//Singleton Scope
		System.out.println(teacher.hashCode());
		Teacher teacher1 = context.getBean(Teacher.class);
		System.out.println(teacher1.hashCode());

		System.out.println("Student1" + student.hashCode());
		Student student2 = context.getBean(Student.class);
		System.out.println("Student1" + student2.hashCode());

	}

}
