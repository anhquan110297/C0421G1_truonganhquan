package bai_tap.controllers;

import bai_tap.models.services.ISandwichCondimentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.jws.WebParam;
import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

@Controller
public class SandwichCondiments {
    @Autowired
    private ISandwichCondimentsService sandwichService;

    @RequestMapping (value = "/show-select")
    public String showSave(HttpServletRequest request, ModelMap modelMap){
        return "index";
    }

    @RequestMapping (value = "/sandwich")
    public ModelAndView save(@RequestParam("condiment") String[] condiment) {
        ModelAndView modelAndView = new ModelAndView("index");
        String result = Arrays.toString(condiment);
        modelAndView.addObject("condiment",result);
        return modelAndView;
    }
}
