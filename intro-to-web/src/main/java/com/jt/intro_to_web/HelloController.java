package com.jt.intro_to_web;

import java.io.PrintWriter;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class HelloController {
  @RequestMapping("/home")                                                   
  public void sayHello(PrintWriter writer) {  // PrintWrite is used to write character text directly  
    System.out.println("Hello Web");        //into the raw HTTP response  stream that gets sent back to clients browser
    writer.println("<h1>Hello Spring Web</h1> <p>Welcome Home</P>");
  }

  @RequestMapping("/")
  public void landingPage(PrintWriter printWriter) {
    System.out.println("landing Page1");
    printWriter.println("Our First Landing Page1");
  }


  @RequestMapping("/contact")
  public String contact() {
    return "contact-page";
  }


//   @RequestMapping("/submit-details")
//   public String submitDetails(HttpServletRequest request, Model model) { //When you add Model model as a method parameter, 
                                                                        // Spring automatically instantiates and manages the object for you.
//   System.out.println("Submit Details handled");                      //Model (org.springframework.ui.Model) is a data container used to 
                                                                        // pass data from your Controller (Java code) to your View (HTML/UI template).

//   String name = request.getParameter("name");  
//   String phone = request.getParameter("phone");

//   // System.out.println("name is:- " + name);
//   // System.out.println("phone is:- " + phone);

//   model.addAttribute("name1", name);         //It holds key-value pairs that template engines (like Thymeleaf, JSP, 
//   model.addAttribute("phone", phone);        //// or FreeMarker) read and display on the rendered webpage.


//   return "details-page";
//   }
// }

  // @RequestMapping(value = "/submit-details", method = RequestMethod.POST )
  // public String submitDetails(@RequestParam(value = "name1", required = false, defaultValue = "Springboot") String name1, @RequestParam String phone, Model model) {

  //   model.addAttribute("name1", name1);
  //   model.addAttribute("phone", phone);

  //   return "details-page";
  // }
  @RequestMapping(value = "/submit-details", method = RequestMethod.POST )
  public String submitDetails(@ModelAttribute Person person, Model model) {

    model.addAttribute("name1", person.getname1());
    model.addAttribute("phone", person.getPhone());

    return "details-page";
  }
}