package com.aplicaciones.tienda.app.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.aplicaciones.tienda.app.entity.Compra;
import com.aplicaciones.tienda.app.entity.Product;
import com.aplicaciones.tienda.app.entity.Venta;
import com.aplicaciones.tienda.app.service.ProductService;
import com.aplicaciones.tienda.app.service.VentaService;

@RestController
@CrossOrigin(origins = "*",methods= {RequestMethod.GET,RequestMethod.POST})
@RequestMapping("/api/ventas")
public class VentaController {
	@Autowired
	private VentaService ventaService;
	@Autowired
	private ProductService productService;
	
	@Autowired
    @Lazy
    private VentaController ventaController;
	@PostMapping
	public ResponseEntity<?> create (@RequestBody List<Compra> productos){
		Venta venta;
	
		for (int i=0; i<productos.size();i++) {
			//System.out.println(productos.get(i).getNombre());
			//System.out.println(productos.get(i).getCantidad());
			//System.out.println(productos.get(i).getPrecio());
			String nombre = productos.get(i).getNombre();
			Product producto = productService.findByNombre(nombre);
			
			if(productos.get(i).getCantidad()<producto.getStock()){
				int diferencia = producto.getStock()-productos.get(i).getCantidad();
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
				producto.setStock(diferencia);
				productService.save(producto);
				System.out.println(diferencia);
				System.out.println(productos.get(i).getImg_atras());
				ventaService.save(venta);
			}			
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
	@GetMapping("/{cliente}")
	public ResponseEntity<?> readbycliente(@PathVariable(value = "cliente") String cliente){
		List<Venta> venCliente = ventaService.findByCliente(cliente);
		if(venCliente.size()==0) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(venCliente);
	}
	@GetMapping(path = "/suma")
    public double suma(){
        double total=ventaService.suma();
         return total;
    }

    @GetMapping(path = "/cantidad")
    public int cantidad(){
        int cantidad=ventaService.cantidad();
         return cantidad;
    }

    @GetMapping(path = "/cliente")
    public int cliente(){
        int cliente=ventaService.cliente();
         return cliente;
    }
    @GetMapping(path = "/producto")
    public String producto(){
        String pro=ventaService.producto();
         return pro;
    }

    @GetMapping(path = "/cantidades")
    public int cantidades(){
        int can=ventaService.cantidades();
         return can;
    }
    @GetMapping(path = "/totales")
    public Double totales(){
        Double tot=ventaService.totales();
         return tot;
    }

    @GetMapping(path = "/nombre")
    public String nombrecli(){
        String nom=ventaService.nombrecliente();
         return nom;
    }

    @GetMapping(path = "/cliente2")
    public ArrayList<Venta> ventasend(){

        String pro=ventaController.producto();
        int can=ventaController.cantidades();
        double tot =ventaController.totales();
        String nom =ventaController.nombrecli();

        int cantidad =ventaController.cantidad();
        int cliente = ventaController.cliente();
        double b = cliente;
        double suma = ventaController.suma();

        Venta venta = new Venta();
        venta.setId((long) 1);
        venta.setProducto(pro);
        venta.setPrecio(tot);
        venta.setSubtotal(can);
        venta.setCliente(nom);
        venta.setFecha((new Date()));

        venta.setCantidad(cantidad);
        venta.setTotal(suma);
        venta.setIgv(b);

         ArrayList<Venta> lista = new ArrayList<Venta>();
         lista.add(venta);
         return lista;
    }
}
