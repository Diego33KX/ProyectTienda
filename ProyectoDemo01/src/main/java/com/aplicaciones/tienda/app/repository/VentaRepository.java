package com.aplicaciones.tienda.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.aplicaciones.tienda.app.entity.Venta;
@Repository
public interface VentaRepository extends JpaRepository<Venta, Long> {
	List<Venta> findByCliente(String cliente);
	@Query(value = "SELECT SUM(total) FROM ventas", nativeQuery = true)
    Double total();

	@Query(value = "SELECT SUM(cantidad) FROM ventas", nativeQuery = true)
	    int cantidad();
	
	@Query(value = "SELECT COUNT(cliente) FROM ventas", nativeQuery = true)
	    int cliente();
	
	@Query(value = "select producto from ventas where cantidad = (select max(cantidad) from ventas)", nativeQuery = true)
	    String producto();
	
	@Query(value = "select cantidad from ventas where cantidad = (select max(cantidad) from ventas)", nativeQuery = true)
	    int     cantidades();
	
	@Query(value = "select total from ventas where cantidad = (select max(cantidad) from ventas)", nativeQuery = true)
	    double     totales();
	
	@Query(value = "select cliente from ventas where cantidad = (select max(cantidad) from ventas)", nativeQuery = true)
	    String nombrecliente();
}
