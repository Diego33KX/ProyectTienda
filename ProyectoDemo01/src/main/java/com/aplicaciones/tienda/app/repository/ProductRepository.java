package com.aplicaciones.tienda.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aplicaciones.tienda.app.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{
	List<Product> findByCategoriaId(int categoriaId);
	List<Product> findByPaisId(int paisId);
}
