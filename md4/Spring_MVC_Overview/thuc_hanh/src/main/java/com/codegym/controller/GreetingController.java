package com.codegym.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class GreetingController {
    @GetMapping(value = "")
    public String showList() {
        return "index";
    }

    @PostMapping(value = "/anhquan")
    public String anhquan(HttpServletRequest request, ModelMap modelMap){
        // dòng này là để lấy giá trị vnd từ ô input
        int vnd = Integer.parseInt(request.getParameter("vnd"));
        int usd = vnd/23000;
        //dòng này để đẩy giá trị lên file jsp để hiển thị ra
        modelMap.addAttribute("usd",usd);
        return "index";
    }


}
