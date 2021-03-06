package com.aplicaciones.tienda.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.aplicaciones.tienda.app.entity.Product;

public interface ProductService {
	//MUESTRA TODOS LOS PRODUCTOS
	public Iterable<Product> findAll();
	
	public Page<Product> findAll(Pageable pageable);
	
	public Optional<Product> findById(Long id);
	//Actualiza y registra
	public Product save(Product product);
	//Borrar
	public void deleteById(Long id);
	
	public List<Product> findByCategoriaId(int categoriaId);
	
	public List<Product> findByPaisId(int paisId);
	
	public abstract Product findByNombre(String nombre);
}
