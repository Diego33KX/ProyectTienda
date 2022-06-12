package com.aplicaciones.tienda.app.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aplicaciones.tienda.app.entity.Category;
import com.aplicaciones.tienda.app.repository.CategoryRepository;

@Service
public class CategoryServiceImplement implements CategoryService {

	//INYECCIÓN DE DEPENDENCIA
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Override
	@Transactional(readOnly = true)
	public Iterable<Category> findAll() {
		
		return categoryRepository.findAll();
	}

	@Override
	@Transactional
	public Category save(Category category) {
		
		return categoryRepository.save(category);
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Category> findById(Long id) {
		return categoryRepository.findById(id);
	}
	
	
}
