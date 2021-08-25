package com.codegym.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Controller
public class Exercises {
    @GetMapping(value = "")
    public String showList() {
        return "index";
    }

    @PostMapping(value = "/moneyconvert")
    public String moneyConvert(HttpServletRequest request, ModelMap modelMap) {
        // dòng này là để lấy giá trị vnd từ ô input
        int vnd = Integer.parseInt(request.getParameter("vnd"));
        int usd = vnd / 23000;
        //dòng này để đẩy giá trị lên file jsp để hiển thị ra
        modelMap.addAttribute("usd", usd);
        return "index";
    }
    @PostMapping(value = "/dictionary")
    public String dictionary(HttpServletRequest request, ModelMap modelMap) {
        String vietnamese = request.getParameter("vietnamese");
        Map<String, String> list = new HashMap<>();
        list.put("but", "pen");
        list.put("ban phim", "keyboard");
        list.put("chuot", "rat");
        list.put("vo", "notebook");
        String result = list.get(vietnamese);
        if (result == null) {
            modelMap.addAttribute("msg", "Nothing");
        } else {
            modelMap.addAttribute("result2", result);
        }
        return "index";
    }


}
