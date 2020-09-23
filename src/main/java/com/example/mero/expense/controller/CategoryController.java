package com.example.mero.expense.controller;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Collection;
import java.util.Optional;

import javax.validation.Valid;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.mero.expense.model.Category;
import com.example.mero.expense.repository.CategoryRepository;


@RestController
@RequestMapping("/api")  //specifies the kind of requests that this controller handles
public class CategoryController {

	private CategoryRepository categoryRepository;

	
	public CategoryController(CategoryRepository categoryRepository) {
		super();
		this.categoryRepository = categoryRepository;
	}
	
	
	//when a http get request is recived for /api then collection of categories will be called to handle the request
	@GetMapping("/categories")  
	Collection<Category> categories() {    //collection interface instead of list because I can have different implementations of categories
		return categoryRepository.findAll();  //this method is select * from category but I dont write it because jpa can do it for me
		
	}
	
	
	//category/id
	@GetMapping("/category/{id}")
	ResponseEntity<?> getCategory(@PathVariable Long id) {
		
		//this is optional because it might not found the id and it can return nothing as well
		Optional<Category> category = categoryRepository.findById(id);
		
		//if we get something from the top line then we are gonna map the it to response
		//response is going to be response entity and if its okay then put the response into body
		return category.map(response -> ResponseEntity.ok().body(response))
		
				//otherwise create a response entity and send not found
				.orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}
	
	@PostMapping("/category")
	ResponseEntity<Category> createCategory(@Valid @RequestBody Category category) throws URISyntaxException {
		
		Category result = categoryRepository.save(category); //insert into table ın aynısı
		
		return ResponseEntity.created(new URI("/api/category" + result.getId())).body(result);
	}
	
	
	@PutMapping("/category/{id}")
	//it will receive a valid request body
	ResponseEntity<Category> updateCategory(@Valid @RequestBody Category category) {
		
		Category result = categoryRepository.save(category);  //this is for updating table
		
		return ResponseEntity.ok().body(result);
	}
	
	
	@DeleteMapping("/category/{id}")
	//response entity is going to be generic type because you dont know for sure if you have
	//category in your hand or not
	ResponseEntity<?> deleteCategory(@PathVariable Long id) {
		
		categoryRepository.deleteById(id);
		
		//build basically means dont send anything in body
		//just build the response body
		return ResponseEntity.ok().build();
	}
	
	
	
}
