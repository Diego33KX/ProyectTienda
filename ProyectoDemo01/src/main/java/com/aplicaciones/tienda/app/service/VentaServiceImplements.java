package com.aplicaciones.tienda.app.service;

import java.util.List;

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
	//BUSCA POR CLIENTE
	@Override
	public List<Venta> findByCliente(String cliente) {
		
		return ventaRepository.findByCliente(cliente);
	}
	
	
	@Override
    @Transactional
    public Double suma() {

        return (Double) ventaRepository.total();
    }

    @Override
    @Transactional
    public int cantidad() {
        return ventaRepository.cantidad();
    }

    @Override
    @Transactional
    public int cliente() {
        return ventaRepository.cliente();
    }

    @Override
    @Transactional
    public String producto() {
        return ventaRepository.producto();
    }

    @Override
    @Transactional
    public int cantidades() {
        return ventaRepository.cantidades();
    }

    @Override
    @Transactional
    public Double totales() {
        return ventaRepository.totales();
    }

    @Override
    public String nombrecliente() {
        return ventaRepository.nombrecliente();
    }
}
