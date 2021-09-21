package com.codegym.register_form.controllers;
import com.codegym.register_form.dto.UsersDto;
import com.codegym.register_form.models.entity.Users;
import com.codegym.register_form.models.services.RegisterFormServiceInterface;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import java.util.List;

@Controller
@RequestMapping (value = "/home")
public class RegisterFormController {
    @Autowired
    private RegisterFormServiceInterface registerFormService;

    @GetMapping (value = "/view")
    public String viewList (Model model){
        List< Users > usersList = registerFormService.findAll();
        model.addAttribute("usersList",usersList);
        return "view";
    }

    @GetMapping (value = "/create")
    public String showCreate (Model model){
        UsersDto usersDto = new UsersDto();
        model.addAttribute("usersDto",usersDto);
        return "create";
    }

    @PostMapping (value = "/create")
    public String create (@ModelAttribute @Validated UsersDto usersDto, BindingResult bindingResult, RedirectAttributes redirectAttributes){
        // Nếu có lỗi sẽ quăng lõio ra
        if (bindingResult.hasFieldErrors()){
            
            return "create";
        } else {
            Users users = new Users();
            //chuyển đổi đối tượng từ userDTO sang user vì user k thể bắt validate (chỉ thao tác với DB k xử lí nghiệp vụ)
            BeanUtils.copyProperties(usersDto,users);
            this.registerFormService.save(users);
            redirectAttributes.addFlashAttribute("msg","Create Success!");
            return "redirect:/home/view";
        }
    }

}
