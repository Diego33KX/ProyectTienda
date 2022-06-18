package com.aplicaciones.tienda.app.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.aplicaciones.tienda.app.entity.Compra;
import com.aplicaciones.tienda.app.entity.Venta;
import com.aplicaciones.tienda.app.service.VentaService;

@RestController
@CrossOrigin(origins = "*",methods= {RequestMethod.GET,RequestMethod.POST})
@RequestMapping("/api/ventas")
public class VentaController {
	@Autowired
	private VentaService ventaService;
	
	@PostMapping
	public ResponseEntity<?> create (@RequestBody List<Compra> productos){
		Venta venta;
		for (int i=0; i<productos.size();i++) {
			//System.out.println(productos.get(i).getNombre());
			//System.out.println(productos.get(i).getCantidad());
			//System.out.println(productos.get(i).getPrecio());
			double subtotal = productos.get(i).getCantidad()*productos.get(i).getPrecio();
			System.out.println(subtotal); 
			double igv = subtotal*0.18;
			double total = igv + subtotal;
			venta = new Venta();
			venta.setProducto(productos.get(i).getNombre());
			venta.setCantidad(productos.get(i).getCantidad());
			venta.setPrecio(productos.get(i).getPrecio());
			venta.setSubtotal(subtotal);
			venta.setIgv(igv);
			venta.setTotal(total);
			venta.setCliente(productos.get(i).getImg_atras());
			System.out.println(productos.get(i).getImg_atras());
			ventaService.save(venta);
		}
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}
	
	@GetMapping
	public List<Venta> readAll(){
		List<Venta> ventas = StreamSupport
				.stream(ventaService.findAll().spliterator(), false)
				.collect(Collectors.toList());
		return ventas;
	}
}
