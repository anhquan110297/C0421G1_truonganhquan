package bai_tap.controllers;

import bai_tap.models.beans.Person;
import bai_tap.models.service.PersonServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/person")
public class PersonController {
    @Autowired
    @Qualifier("personServiceImp")
    PersonServiceInterface personServiceInterface;

    @GetMapping("/create")
    public String showForm (Model model){
        Person person = new Person();
        String [] country = {"Vietnamese","Lao","ThaiLand","Other"};
        String [] transport = {"Plan","Boat","Car","Other"};
        String [] symptom = {"Fever","Cough","Shortness Of Breath","\n" +
                "Sore Throat","Nausea","Diarrhea","Skin Bleeding","\n" +
                "Skin Rash"};
        model.addAttribute("newPerson",person);
        model.addAttribute("country",country);
        model.addAttribute("transport",transport);
        model.addAttribute("symptom",symptom);
        return "index";
    }

    @PostMapping(value = "create")
    public String submit(@ModelAttribute("newPerson") Person newPerson,
                         RedirectAttributes redirectAttributes,
                         Model model){
        this.personServiceInterface.savePerson(newPerson);
        redirectAttributes.addFlashAttribute("msg","Success!");
        return "index";
    }

}
