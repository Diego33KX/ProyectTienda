package com.aplicaciones.tienda.app.entity;

public class Compra {
	private Long id;
	private String nombre;
	private int categoriaId;
	private int paisId;
	private double precio;
	private int stock;
	private String marca;
	private String talla;
	private String genero;
	private String img_delante;
	private String img_atras;
	private int cantidad;
	private String descripcion;
	private String pub_date;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getCategoriaId() {
		return categoriaId;
	}
	public void setCategoriaId(int categoriaId) {
		this.categoriaId = categoriaId;
	}
	public int getPaisId() {
		return paisId;
	}
	public void setPaisId(int paisId) {
		this.paisId = paisId;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getTalla() {
		return talla;
	}
	public void setTalla(String talla) {
		this.talla = talla;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	public String getImg_delante() {
		return img_delante;
	}
	public void setImg_delante(String img_delante) {
		this.img_delante = img_delante;
	}
	public String getImg_atras() {
		return img_atras;
	}
	public void setImg_atras(String img_atras) {
		this.img_atras = img_atras;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getPub_date() {
		return pub_date;
	}
	public void setPub_date(String pub_date) {
		this.pub_date = pub_date;
	}
	
	
	
}
