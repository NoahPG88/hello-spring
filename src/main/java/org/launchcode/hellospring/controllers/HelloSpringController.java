package org.launchcode.hellospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HelloSpringController {
    //Responds to /hello?name=LaunchCode
    @RequestMapping(value = "hello", method = {RequestMethod.GET, RequestMethod.POST})
    public String hello(@RequestParam String name, Model model) {
        String theGreeting = "Hello, " + name + "! " + "You old so and so...";
        model.addAttribute("greeting", theGreeting);
        return "hello";
    }

    //Responds to /hello/LaunchCode
    @GetMapping("hello/{name}")
    public String helloAgain(@PathVariable String name, Model model) {
        String standardGreeting = "Hello, " + name + "!";
        model.addAttribute("greeting", standardGreeting);
        return "hello";
    }

    @GetMapping("form")
    public String helloForm(){
        return "form";
    }

    @GetMapping("hello-names")
    public String helloNames(Model model) {
        List<String> nameList = new ArrayList<>();
        nameList.add("Steve");
        nameList.add("Nat");
        nameList.add("Tobi");
        model.addAttribute("names", nameList);
        return "hello-list";
    }
}


/* OLD VERSION:
@Controller
@ResponseBody
@RequestMapping("hello")
public class HelloController {

    // Handles request at path /hello
//    @GetMapping("hello")
//    @ResponseBody
//    public String hello() {
//        return "Hello, Spring!";
//    }

    //now at /hello/goodbye because "hello" is inherited by all within class
    @GetMapping("goodbye")
    public String goodbye() {
        return "Goodbye, Spring!";
    }

    // handles request of the form /hello?name=LaunchCode

    @RequestMapping(method = {RequestMapping.GET, RequestMethod.POST })
    public String helloWithQueryParam(@RequestParam String name){
        return "Hello " + name + " the computer is computing you... " + name.toUpperCase();
    }

    // Handles requests of the form /hello/LaunchCode
    @GetMapping("{name}")
    public String helloWithPathParam(@PathVariable String name){
        return "What's in a name anyway " + name + "? IT DOESN'T MATTER WHAT YOUR NAME IS!";
    }

    @GetMapping("form")
    public String helloForm(){
        return "<html>" +
                "<body>" +
                "<form action='hello' method='post'>" + //submit a request to /hello
                "<input type='text' name='name'>" +
                "<input type='submit' value='Greet me!'>" +
                "</form>" +
                "</body>" +
                "</html>";
    }
}
*/