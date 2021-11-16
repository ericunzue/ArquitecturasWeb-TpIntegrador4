package arq.integrador.despensa.entities;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

//@IdClass(value=DetalleCompraId.class)
@Entity
public class DetalleCompra {

//	@Id
//	@ManyToOne
//	@JoinColumn(name = "idCompra")
//	private Compra compra;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idDetalle;

//	@Id
	@OneToOne
	@JoinColumn(name="idProducto", nullable = false)
	private Producto producto;

	private int cantidad;

	private double total;

	public DetalleCompra() {
		// TODO Auto-generated constructor stub
	}
	public DetalleCompra(Producto producto) {
		super();
//		this.compra = compra;
		this.producto = producto;
		this.cantidad = cantidad;
		this.total = cantidad * this.producto.getPrecio();
	}
	
//	public Compra getCompra() {
//		return compra;
//	}
//	public void setCompra(Compra compra) {
//		this.compra = compra;
//	}
	public Producto getProducto() {
		return producto;
	}
	public void setProducto(Producto producto) {
		this.producto = producto;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	@Override
	public String toString() {
		return "DetalleCompra [ producto=" + producto + ", cantidad=" + cantidad + ", total="
				+ total + "]";
	}

	

}
