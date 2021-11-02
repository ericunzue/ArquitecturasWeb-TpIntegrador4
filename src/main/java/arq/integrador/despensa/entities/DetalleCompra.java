package arq.integrador.despensa.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@IdClass(value=DetalleCompraId.class)
@Entity
public class DetalleCompra {
	
	@Id
	@ManyToOne
	@JoinColumn(name="idCompra")
	private Compra compra;
	
	@Id
	@OneToOne
	@JoinColumn(name="idProducto")
	private Producto producto;
	
	private int cantidad;
	
	private double total;
	
	public DetalleCompra() {
		// TODO Auto-generated constructor stub
	}

	public DetalleCompra(Compra compra, Producto producto, int cantidad) {
		super();
		this.compra = compra;
		this.producto = producto;
		this.cantidad = cantidad;
		this.total = cantidad*producto.getPrecio();
	}
	
	
	
	
	

}
