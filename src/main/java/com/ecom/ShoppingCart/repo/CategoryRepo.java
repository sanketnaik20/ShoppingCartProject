package com.ecom.ShoppingCart.repo;

import org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecom.ShoppingCart.model.Category;

@Repository
public interface CategoryRepo extends JpaRepository<Category, Integer> {

    public Boolean existsByName(String name);
}
