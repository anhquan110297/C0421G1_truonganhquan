package com.godegym.controllers;

import com.godegym.models.entity.Question;
import com.godegym.models.service.IQuestionService;
import com.godegym.models.service.IQuestionTypeService;
import com.godegym.models.service.QuestionService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping (value = "/question")
public class QuestionController {
    @Autowired
    IQuestionService questionService;

    @Autowired
    IQuestionTypeService questionTypeService;




    @GetMapping(value = "/list")
    public String showList(@PageableDefault(value = 3) Pageable pageable, Model model,
                           @RequestParam(value = "searchByTitle" ,required = false) String title) throws Exception {
        if (title != null){
          Page<Question> questionPage =  questionService.findAllByTitleContaining(title,pageable);
          if (questionPage == null){
              throw new Exception("Not Found");
          } else {
              model.addAttribute("questionPage", questionPage);
              model.addAttribute("title", title);
              model.addAttribute("questionTypeList", questionTypeService.findAll());
              model.addAttribute("questionTypeList", questionTypeService.findAll());
              return "view/list";
          }
        } else {
            model.addAttribute("questionTypeList", questionTypeService.findAll());
            model.addAttribute("questionList", questionService.findAll(pageable));
            return "view/list";
        }
    }

    @GetMapping(value = "/create")
    public String showCreate(Model model) {
        Question question = new Question();
        model.addAttribute("question", question);
        model.addAttribute("questionTypeList",questionTypeService.findAll());
        return "view/create";
    }

    @PostMapping(value = "/create")
    public String doCreate(@ModelAttribute("question") Question question,
                           BindingResult bindingResult, RedirectAttributes redirectAttributes,
                           Model model) {
        if (bindingResult.hasFieldErrors()) {
            //load lai du lieu
            model.addAttribute("questionTypeList",questionTypeService.findAll());
            return "view/create";
        } else {
            this.questionService.save(question);
            redirectAttributes.addFlashAttribute("msg", "Create " + question.getTitle() + " success!!!");
            return "redirect:/question/list";
        }
    }
//
    @GetMapping(value = "/edit/{id}")
    public String viewEdit(@PathVariable Integer id, Model model) {
        model.addAttribute("question", this.questionService.findById(id));
        model.addAttribute("questionTypeList",questionTypeService.findAll());

        return "view/edit";
    }

    @PostMapping(value = "/edit")
    public String doEdit(@ModelAttribute("question") Question question
            , BindingResult bindingResult, RedirectAttributes redirectAttributes, Model model) {
        this.questionService.save(question);
        redirectAttributes.addFlashAttribute("msg", "Update" + question.getTitle() + " success!!!");
        return "redirect:/question/list";
    }
//
    @PostMapping("/delete")
    public String doDelete(@RequestParam(value = "questionId") int id,RedirectAttributes redirectAttributes) throws Exception {
        Question question = this.questionService.findById(id);
        if (question == null){
            throw new Exception ("Đối tượng không tìm thấy");
        } else {
            this.questionService.delete(question);
            redirectAttributes.addFlashAttribute("msg","Delete Success!");
            return "redirect:/question/list";
        }
    }

    @GetMapping(value = "/detail/{id}")
    public String viewDetail(@PathVariable Integer id, Model model) {
        model.addAttribute("question", this.questionService.findById(id));
        model.addAttribute("questionTypeList",questionTypeService.findAll());
        return "view/detail";
    }


}
