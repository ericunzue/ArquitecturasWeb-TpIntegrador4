package arq.integrador.despensa.entities;

import java.sql.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Compra {

		@Id
		@GeneratedValue(strategy=GenerationType.AUTO)
		private int idCompra;
		@ManyToOne
		@JoinColumn(name="idCliente")
		private Cliente cliente;
		//		private List<Producto> compras;
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




}
