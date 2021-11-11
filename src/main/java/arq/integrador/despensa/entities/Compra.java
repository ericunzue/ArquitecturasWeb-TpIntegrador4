package arq.integrador.despensa.entities;


import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;



@Entity
public class Compra {

	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)	
	
	private int idCompra;
	
	@ManyToOne
	@JoinColumn(name="idCliente")
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Cliente cliente;
	//		private List<Producto> compras;
	private double total;


	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
	@CreationTimestamp
	private LocalDateTime  fecha;

	public Compra() {

	}

	public Compra(Cliente cliente) {
		super();
		this.cliente = cliente;	


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

	@Override
	public String toString() {
		return "Compra [idCompra=" + idCompra + ", cliente=" + cliente + ", total=" + total + ", fecha=" + fecha + "]";
	}

	
	


	




}
