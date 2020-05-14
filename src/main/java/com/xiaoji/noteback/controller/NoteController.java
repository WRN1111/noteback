package com.xiaoji.noteback.controller;

import com.xiaoji.noteback.pojo.Category;
import com.xiaoji.noteback.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;


@Controller
public class NoteController {
    @Autowired
    CategoryService categoryService;

    @CrossOrigin
    @GetMapping("api/categories")
    @ResponseBody
    public List<Category> getCategoryList(){
        return categoryService.getAll();
    }
}
