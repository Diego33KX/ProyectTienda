package com.aplicaciones.tienda.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aplicaciones.tienda.app.entity.Venta;
import com.aplicaciones.tienda.app.repository.VentaRepository;
@Service
public class VentaServiceImplements implements VentaService{

	@Autowired
	private VentaRepository ventaRepository;
	
	@Override
	@Transactional(readOnly = true)
	public Iterable<Venta> findAll() {
		
		return ventaRepository.findAll();
	}

	@Override
	@Transactional
	public Venta save(Venta venta) {
		
		return ventaRepository.save(venta);
	}

}
