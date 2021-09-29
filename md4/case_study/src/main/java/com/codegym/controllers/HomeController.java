package com.codegym.controllers;


import com.codegym.dto.UserDto;
import com.codegym.models.entity.security.Role;
import com.codegym.models.entity.security.User;
import com.codegym.models.services.security_service.impl.RoleService;
import com.codegym.models.services.security_service.interfacee.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
public class HomeController {
    @Autowired
    UserService userService;
    @Autowired
    RoleService roleService;

    @GetMapping(value = {"","/home"})
    public String getHomePage (){
        return "home-page";
    }

    @GetMapping(value = "/login")
    public String getLogin (Model model){
        UserDto userDto = new UserDto();
        model.addAttribute("userDto", userDto);
        return "login2";
    }


    @GetMapping(value = "/signup")
    public String showSignUp(Model model) {
        UserDto userDto = new UserDto();
        model.addAttribute("userDto", userDto);
        return "login2";
    }

    @PostMapping(value = "/anhquandeptrai")
    public String doCreate(@Valid @ModelAttribute("userDto")  UserDto userDto,
                           BindingResult bindingResult, RedirectAttributes redirectAttributes,
                           Model model) {
        if (bindingResult.hasFieldErrors()) {
            //load lai du lieu
            return "login2";
        } else {
            BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
            String password = passwordEncoder.encode(userDto.getPassWord());
            userDto.setPassWord(password);
            List<Role> roleList = new ArrayList<>();
            roleList.add(roleService.findRoleByName("ROLE_USER"));
            User user = new User();
            user.setEnabled(true);
            user.setRoles(roleList);
            BeanUtils.copyProperties(userDto, user);
            userService.save(user);
            redirectAttributes.addFlashAttribute("msg", "Create " + userDto.getUserName() + " success!!!");
            return "redirect:/login";
        }
    }

}
