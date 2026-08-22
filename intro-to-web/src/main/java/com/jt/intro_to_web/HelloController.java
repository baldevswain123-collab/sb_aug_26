package com.jt.intro_to_web;

import java.io.PrintWriter;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
  
@Controller // 1.It marks the class as a Controller class      //which means that class is responsible to handle http request
public class HelloController {

    @RequestMapping("/home") //This annotation hanldes a custom path inside the controller class//path handling
                            // 
    public void sayHello(PrintWriter writer){
        System.out.println("Hello Web");
        writer.println("<h1>Hello Spring Web</h1> <p>Welcome Home</p>");
    }
    @RequestMapping
    public void landingPage(PrintWriter printWriter){
        System.out.println("landing Page");
        printWriter.println("Our First Landing Page");
    }
    @RequestMapping("/contact")
    public String contact (){
        return"contact-page";
    }
}
