package by.view.webapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Denis on 09.07.2016.
 */
@Controller
public class AddDeleteBicycleController {
    private String message = "Hello world in SpringMVC webapp!";

    @RequestMapping("/addordeletebicycle")
    public ModelAndView showMessage(@RequestParam(value = "edit", required = false, defaultValue = "0") String edit){
        System.out.println("in AddDeleteBicycleController");
        ModelAndView view = new ModelAndView("addordeletebicycle");
        view.addObject("edit", edit);
        return view;
    }
}
