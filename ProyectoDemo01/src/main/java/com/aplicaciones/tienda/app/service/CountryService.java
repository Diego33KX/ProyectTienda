package com.aplicaciones.tienda.app.service;

import java.util.Optional;

import com.aplicaciones.tienda.app.entity.Country;

public interface CountryService {
	public Iterable<Country> findAll();
	public Country save(Country country);
	public Optional<Country> findById(Long id);
}
