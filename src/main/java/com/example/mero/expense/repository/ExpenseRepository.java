package com.example.mero.expense.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.mero.expense.model.Expense;

public interface ExpenseRepository extends JpaRepository<Expense, Long> {

	
}
