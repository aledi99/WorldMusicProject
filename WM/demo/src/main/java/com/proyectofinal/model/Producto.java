package com.proyectofinal.model;

import java.time.LocalDate;

/**
 * 
 * @author alediaz
 * @version 1.5 Clase Model de los Productos que se venderán en la aplicación
 */
public class Producto {

	private String nombre, descripcion;
	private LocalDate fechaPubl; // Fecha en la cual el Producto ha salido al mercado de la tienda
	private double pvp; // Precio del producto
	private Tag tagProducto; // Serán los Tags que estarán asociados a los Productos, junto a los generales.
	private boolean stock; // El valor será "true" si está disponible-en stock; y "false" si no queda
							// ninguna unidad del producto
	private long idProducto;

	
	/**
	 * Constructor 
	 */
	public Producto() {
		
	}
	
	/**
	 * Constructor de la clase Producto
	 * @param nombre
	 * @param descripcion
	 * @param fechaPubl
	 * @param pvp
	 * @param tagProducto
	 * @param stock
	 * @param idProducto
	 */
	public Producto(String nombre, String descripcion, LocalDate fechaPubl, double pvp, Tag tagProducto, boolean stock,
			long idProducto) {
		super();
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.fechaPubl = fechaPubl;
		this.pvp = pvp;
		this.tagProducto = tagProducto;
		this.stock = stock;
		this.idProducto = idProducto;
	}

	
	//Getters & Setters
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public LocalDate getFechaPubl() {
		return fechaPubl;
	}

	public void setFechaPubl(LocalDate fechaPubl) {
		this.fechaPubl = fechaPubl;
	}

	public double getPvp() {
		return pvp;
	}

	public void setPvp(double pvp) {
		this.pvp = pvp;
	}

	public Tag getTagProducto() {
		return tagProducto;
	}

	public void setTagProducto(Tag tagProducto) {
		this.tagProducto = tagProducto;
	}

	public boolean isStock() {
		return stock;
	}

	public void setStock(boolean stock) {
		this.stock = stock;
	}

	public long getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(long idProducto) {
		this.idProducto = idProducto;
	}

	//hashCode()
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((descripcion == null) ? 0 : descripcion.hashCode());
		result = prime * result + ((fechaPubl == null) ? 0 : fechaPubl.hashCode());
		result = prime * result + (int) (idProducto ^ (idProducto >>> 32));
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		long temp;
		temp = Double.doubleToLongBits(pvp);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + (stock ? 1231 : 1237);
		result = prime * result + ((tagProducto == null) ? 0 : tagProducto.hashCode());
		return result;
	}

	//equals()
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Producto other = (Producto) obj;
		if (descripcion == null) {
			if (other.descripcion != null)
				return false;
		} else if (!descripcion.equals(other.descripcion))
			return false;
		if (fechaPubl == null) {
			if (other.fechaPubl != null)
				return false;
		} else if (!fechaPubl.equals(other.fechaPubl))
			return false;
		if (idProducto != other.idProducto)
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		if (Double.doubleToLongBits(pvp) != Double.doubleToLongBits(other.pvp))
			return false;
		if (stock != other.stock)
			return false;
		if (tagProducto == null) {
			if (other.tagProducto != null)
				return false;
		} else if (!tagProducto.equals(other.tagProducto))
			return false;
		return true;
	}
	
	//toString()

	@Override
	public String toString() {
		return "Producto [nombre=" + nombre + ", descripcion=" + descripcion + ", fechaPubl=" + fechaPubl + ", pvp="
				+ pvp + ", tagProducto=" + tagProducto + ", stock=" + stock + ", idProducto=" + idProducto + "]";
	}
	
	
	
	

}
