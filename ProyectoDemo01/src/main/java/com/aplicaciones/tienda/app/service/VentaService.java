package com.aplicaciones.tienda.app.service;

import com.aplicaciones.tienda.app.entity.Venta;

public interface VentaService {
	public Iterable<Venta> findAll();
	public Venta save(Venta venta);
}
