package com.aplicaciones.tienda.app.service;

import java.util.Optional;

import com.aplicaciones.tienda.app.entity.Category;

public interface CategoryService {
	public Iterable<Category> findAll();
	public Category save(Category category);
	public Optional<Category> findById(Long id);
}
