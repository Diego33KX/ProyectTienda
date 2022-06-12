package com.aplicaciones.tienda.app.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aplicaciones.tienda.app.entity.Category;
import com.aplicaciones.tienda.app.service.CategoryService;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {
	//INYECCIÓN DE DEPENDENCIAS
	@Autowired
	private CategoryService categoryService;
	
	//CREATE A NEW CATEGORY
	@PostMapping
	public ResponseEntity<?> create(@RequestBody Category category){
		return ResponseEntity.status(HttpStatus.CREATED).body(categoryService.save(category));
	}
	
	//READ ALL CATEGORIES
	@GetMapping
	public List<Category> readAll(){
		List<Category> categories = StreamSupport
				.stream(categoryService.findAll().spliterator(), false)
				.collect(Collectors.toList());
		return categories;
	}
	
	//READ BY ID
	@GetMapping("/{id}")
	public ResponseEntity<?> read(@PathVariable(value = "id") Long categoryId){
		Optional<Category> oCategory = categoryService.findById(categoryId);
		if(!oCategory.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(oCategory);
	}
}
