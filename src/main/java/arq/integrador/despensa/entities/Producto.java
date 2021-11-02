package arq.integrador.despensa.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Producto {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idProducto;
	
	private String nombre;
	private int stock;
	private double precio;
	public Producto(String nombre, int stock, double precio) {
		super();
		this.nombre = nombre;
		this.stock = stock;
		this.precio = precio;
	}
	
	public Producto() {
		// TODO Auto-generated constructor stub
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public int getIdProducto() {
		return idProducto;
	}
	
	
	
	
}
