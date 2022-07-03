package com.aplicaciones.tienda.app.service;

import java.util.List;

import com.aplicaciones.tienda.app.entity.Venta;

public interface VentaService {
	public Iterable<Venta> findAll();
	public Venta save(Venta venta);
	
	public List<Venta> findByCliente(String cliente);
	
    public Double suma();
    public int cantidad();
    public int cliente();
    public String producto();
    public int cantidades();
    public Double totales();
    public String nombrecliente();
}
