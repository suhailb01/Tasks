package com.example.Springtask.controller;

import com.example.Springtask.dto.Product;
import com.example.Springtask.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/api")
public class ProductController {
    @Autowired
    ProductService pds;
    @GetMapping("/product")
    public String product(){
        return "index";
    }
    @GetMapping("/add")
    public String add(Model model){
        Product product=new Product();
        model.addAttribute("product",product);
        return "add";
    }
    @GetMapping("/display")
    public String display(Model model){
        List<Product> products =pds.getAllProducts();
        model.addAttribute("products",products);
        return "display";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute("product") Product product){
        pds.save(product);
        return "redirect:/api/display";
    }

}
