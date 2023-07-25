package com.example.controller;

import com.example.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("products")
@Controller

public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public String list(Model model) {
        model.addAttribute("products", productService.getAllProduct());
        return "product/list";
    }
}
