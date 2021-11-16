package arq.integrador.despensa.entities;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.CreationTimestamp;


import com.fasterxml.jackson.annotation.JsonFormat;



@Entity
public class Compra {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idCompra;
	
	@ManyToOne
	@JoinColumn(name="idCliente")
	
	private Cliente cliente;
	
	@OneToMany
	@Cascade(CascadeType.ALL)
	private List<DetalleCompra> detalles;
	
	public double getTotal() {
		return total;
	}

	@Column
	private double total;


	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT-3")
	@CreationTimestamp
	private LocalDateTime  fecha;

	public Compra() {

	}

	public Compra(Cliente cliente, List<DetalleCompra> detalles, double total) {
		super();
		this.cliente = cliente;
		this.detalles= new ArrayList<>(detalles);
		this.total = total; 


	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public int getIdCompra() {
		return idCompra;
	}

	public LocalDateTime getFecha() {
		return fecha;
	}
	
	public void setTotal(double total)
	{
		this.total= total;
	}
	public List<DetalleCompra> getDetalles() {
		return detalles;
	}

	@Override
	public String toString() {
		return "Compra [idCompra=" + idCompra + ", cliente=" + cliente + ", total=" + total + ", fecha=" + fecha + "]";
	}


	




}