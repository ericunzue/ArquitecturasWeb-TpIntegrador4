package arq.integrador.despensa.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

//@IdClass(value=DetalleCompraId.class)
@Entity
public class DetalleCompra {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idDetalle;

	@OneToOne
	@JoinColumn(name = "idProducto", nullable = false)
	private Producto producto;

	@ManyToOne(cascade = CascadeType.ALL)

	@JoinColumn(name = "idCompra")

	private Compra compra;

	private int cantidad;

	private double total;

	public DetalleCompra() {
		// TODO Auto-generated constructor stub
	}

	public DetalleCompra(Compra compra, Producto producto, int cantidad, double total) {

		super();
		this.producto = producto;
		this.cantidad = cantidad;
		this.total = cantidad * this.producto.getPrecio();
		this.total = total;

	}

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
		return "DetalleCompra [ producto=" + producto + ", cantidad=" + cantidad + ", total=" + total + "]";
	}

}
