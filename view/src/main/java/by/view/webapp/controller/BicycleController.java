package by.view.webapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Denis on 09.07.2016.
 */
@Controller
public class BicycleController {

    @RequestMapping("/viewbicycle")
    public ModelAndView showBicycle(){
        System.out.println("in BicycleController");
        ModelAndView view = new ModelAndView("viewBicycle");
        return view;
    }
}
