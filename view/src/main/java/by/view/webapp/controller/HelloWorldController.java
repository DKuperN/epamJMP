package by.view.webapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Denis on 09.07.2016.
 */
@Controller
public class HelloWorldController {
    private String message = "Hello world in SpringMVC webapp!";

    @RequestMapping("/hello")
    public ModelAndView showMessage(@RequestParam(value = "name", required = false, defaultValue = "World") String name){
        System.out.println("in HelloWorldController");
        ModelAndView view = new ModelAndView("helloworld");
        view.addObject("message", message);
        view.addObject("name", name);
        return view;
    }
}
