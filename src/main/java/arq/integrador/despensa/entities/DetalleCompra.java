package arq.integrador.despensa.entities;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.CascadeType;
import javax.persistence.EmbeddedId;
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
	@ManyToOne(cascade={CascadeType.ALL})
	
	@JoinColumn(name="idCompra")

	private Compra compra;
	
	@Id
	@ManyToOne(cascade={CascadeType.ALL})
	@JoinColumn(name="idProducto")
	private Producto producto;	
	
	private int cantidad;
	
	private double total;
	
	public DetalleCompra() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "DetalleCompra [compra=" + compra + ", producto=" + producto + ", cantidad=" + cantidad + ", total="
				+ total + "]";
	}

	public DetalleCompra(Compra compra, Producto producto, int cantidad,double total) {
		super();
		this.compra = compra;
		this.producto = producto;
		this.cantidad = cantidad;
		this.total = total;
	}
	
	
	
	
	

}
