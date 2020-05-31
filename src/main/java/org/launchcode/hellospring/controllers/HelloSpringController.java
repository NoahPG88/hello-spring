package org.launchcode.hellospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class HelloSpringController {
    //Responds to /hello?name=LaunchCode
    @RequestMapping(value = "hello", method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public String hello(@RequestParam String name) {
        return "Hello, " + name + "!";
    }

    //Responds to /hello/LaunchCode
    @GetMapping("hello/{name}")
    @ResponseBody
    public String helloAgain(@PathVariable String name) {
        return "Hello, " + name + "!";
    }

    @GetMapping("form")
    @ResponseBody
    public String helloForm(){
        String html = "<html>" +
                "<body>" +
                "<form method = 'post' action = '/hello'>" +
                "<input type = 'text' name = 'name' />" +
                "<input type - 'submit' value = 'Greet Me!' />" +
                "</form>" +
                "</body>" +
                "</html>";
        return html;
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