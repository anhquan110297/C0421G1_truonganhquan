package bai_tap.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Operation {
    @RequestMapping ("show-operation")
    public String show (){
        return "index";
    }
    @RequestMapping (value = "/operation")
    public ModelAndView operation (@RequestParam String operator , int numberA , int numberB ){
        ModelAndView modelAndView = new ModelAndView("index");
        String result = "";
        switch (operator){
            case "plus":
              result = String.valueOf(numberA + numberB);
                break;
            case "subtract":
                result = String.valueOf(numberA - numberB);
                break;
            case "multi":
                result = String.valueOf(numberA * numberB);
                break;
            case "divine":
                if (numberB == 0){
                    result = null;
                } else {
                    result = String.valueOf(numberA / numberB);
                }
                break;
        }
        modelAndView.addObject("result2",result);
        return modelAndView;
    }
}
