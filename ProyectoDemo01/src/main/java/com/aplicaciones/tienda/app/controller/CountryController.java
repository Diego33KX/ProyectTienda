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

import com.aplicaciones.tienda.app.entity.Country;
import com.aplicaciones.tienda.app.service.CountryService;

@RestController
@RequestMapping("/api/countries")
public class CountryController {
	//INYECCIÓN DE DEPENDENCIAS
	@Autowired
	private CountryService countryService;
	
	//CREATE A NEW CATEGORY
	@PostMapping
	public ResponseEntity<?> create(@RequestBody Country country){
		return ResponseEntity.status(HttpStatus.CREATED).body(countryService.save(country));	
	}
	//READ ALL CATEGORIES
	@GetMapping
	public List<Country> readAll(){
		List<Country> countries = StreamSupport
				.stream(countryService.findAll().spliterator(), false)
				.collect(Collectors.toList());
		return countries;
	}
	
	//READ BY ID
	@GetMapping("/{id}")
	public ResponseEntity<?> read(@PathVariable(value="id") Long countryId){
		Optional<Country> oCountry = countryService.findById(countryId);
		if(!oCountry.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(oCountry);
	}
	
}
