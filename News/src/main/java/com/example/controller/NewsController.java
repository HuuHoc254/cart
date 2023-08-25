package com.example.controller;

import com.example.entity.StaffEntity;
import com.example.model.Category;
import com.example.model.New;
import com.example.model.Staff;
import com.example.service.CategoryService;
import com.example.service.NewService;
import com.example.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("news")
public class NewsController {
    @Autowired
    private NewService newService;
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private StaffService staffService;

    @GetMapping
    public String showListNews(Model model) {
        model.addAttribute("news", newService.getAllNew());
        return "home";
    }

    @GetMapping("add-new")
    public String showFormAddNews(Model model) {
        List<Category> categories = categoryService.getAllCategory();
        List<Staff> staffs = staffService.getAllStaff();
        model.addAttribute("news", new New());
        model.addAttribute("categories", categories);
        model.addAttribute("staffs", staffs);
        return "add-news";
    }

    @PostMapping
    public String addNews(@ModelAttribute New aNew, Model model) {
        newService.create(aNew);
        model.addAttribute("news", newService.getAllNew());
        return "home";
    }

    @GetMapping("search")
    public String getSearch(Model model, @RequestParam String search) {
        model.addAttribute("news", newService.findByTitle(search));
        return "home";
    }
}
