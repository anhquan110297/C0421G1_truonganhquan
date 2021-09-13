package com.codegym.blog_update.controllers;

import com.codegym.blog_update.models.Entity.Blog;
import com.codegym.blog_update.models.Entity.Category;
import com.codegym.blog_update.models.services.BlogServiceInterface;
import com.codegym.blog_update.models.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// crossOgrigin them vao de update khong bi loi, loi~ khong cho update
@CrossOrigin (origins = "*")
@RestController
// bat buoc phai co api, api interface
@RequestMapping ("/api/blog")
public class BlogControllerRest {
    @Autowired
    private BlogServiceInterface blogService;

    @Autowired
    private CategoryService categoryService;

    @GetMapping(value = "/list")
    public ResponseEntity<List<Blog>> show(@PageableDefault(value = 2) Pageable pageable) {
        List<Blog> blogList = blogService.showAll();
        if (blogList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blogList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Blog> showDetail(@PathVariable int id){
        Blog blog = blogService.findById(id);
        if (blog==null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(blog,HttpStatus.OK);
    }

    @GetMapping("/search")
    public ResponseEntity<List<Blog>> searchBlog(@RequestParam String category){
        List<Blog> blogList = blogService.findBlogCategory(category);
        if (blogList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blogList, HttpStatus.OK);
    }

    @GetMapping("/category")
    public ResponseEntity<List< Category >> showList(){
        List<Category> categoryList = categoryService.findAll();
        if (categoryList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(categoryList,HttpStatus.OK);
    }

}
