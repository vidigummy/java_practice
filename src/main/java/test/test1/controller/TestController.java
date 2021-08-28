package test.test1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import test.test1.service.TestService;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class TestController {
    
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home(Model model){
        System.out.println("home");
        model.addAttribute("ryu");
        return "index.html";
    }

    @RequestMapping(value = "/students", method = RequestMethod.GET)
    public String student(Model model){
        System.out.println("students");
        TestService testService = new TestService();
        return "index.html";
    }

    @RequestMapping(value = "/input",  method =  RequestMethod.GET)
    public String input(Model model){
        return "input.html";
    }

    @RequestMapping(value="/input", method=RequestMethod.POST)
    public SomeData requestMethodName(@RequestParam String param) {
        System.out.println("hi");
        return "input.html";
    }
    
}
