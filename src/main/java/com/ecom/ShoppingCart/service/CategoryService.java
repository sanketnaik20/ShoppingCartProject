package com.ecom.ShoppingCart.service;

import java.util.*;
import com.ecom.ShoppingCart.model.Category;

public interface CategoryService {


    public Category saveCategory(Category category);
    public Boolean existCategory(String name);
    public List<Category> getAllCategory();
}
