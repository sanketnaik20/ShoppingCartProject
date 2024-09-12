package com.ecom.ShoppingCart.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecom.ShoppingCart.model.Category;
import com.ecom.ShoppingCart.repo.CategoryRepo;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepo repo;

    @Override
    public Category saveCategory(Category category) {
        return repo.save(category);
    }

    @Override
    public List<Category> getAllCategory() {

        return repo.findAll();
    }

    @Override
    public Boolean existCategory(String name) {
        return repo.existsByName(name);
    }

}
