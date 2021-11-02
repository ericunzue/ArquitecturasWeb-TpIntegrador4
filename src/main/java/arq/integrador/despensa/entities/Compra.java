package arq.integrador.despensa.entities;






import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Compra {

		@Id
		@GeneratedValue(strategy=GenerationType.AUTO)
		private int idCompra;
		@ManyToOne
		@JoinColumn(name="idCliente")
		private Cliente cliente;
		//		private List<Producto> compras;
		@Column
		@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss",timezone="GMT+8")
		private Date fecha;

		public Compra() {

		}

		public Compra(Cliente cliente) {
				super();
				this.cliente = cliente;
				long miliseconds = System.currentTimeMillis();				
				this.fecha = new Date(miliseconds);			
			
			
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

		public Date getFecha() {
			return fecha;
		}

	




}
