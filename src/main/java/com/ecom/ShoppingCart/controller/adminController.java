package com.ecom.ShoppingCart.controller;

// import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.ecom.ShoppingCart.model.Category;
import com.ecom.ShoppingCart.service.CategoryService;

import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.HttpSessionEvent;

@Controller
@RequestMapping("/admin")
public class adminController {

    @Autowired
    private CategoryService service;

    @GetMapping("/")
    public String index() {
        return "admin/index";
    }

    @GetMapping("/loadAddProduct")
    public String loadAddProduct() {
        return "admin/add_product";
    }

    @GetMapping("/category")
    public String category() {
        return "admin/category";
    }

    @PostMapping("/saveCategory")
    public String saveCategory(@ModelAttribute Category category, @RequestParam("file") MultipartFile file,
            HttpSession session) {
        String imgName = file != null ? file.getOriginalFilename() : "default.jpg";
        category.setImageName(imgName);
        Boolean existCategory = service.existCategory(category.getName());
        if (existCategory) {
            session.setAttribute("errorMsg", "Category Name Already Exist");
        } else {

            Category saveCategory = service.saveCategory(category);
            if (ObjectUtils.isEmpty(category)) {
                session.setAttribute("errorMsg", "Not Saved internal server error");
            } else {
                session.setAttribute("succMsg", " Saved Succesfully");
            }
        }

        return "redirect:/admin/category"; // corrected redirection
    }
}
