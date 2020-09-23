package com.example.mero.expense.repository;

import com.example.mero.expense.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category,Long> {

      Category findByName(String name);

}
