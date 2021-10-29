package arq.integrador.despensa.entities;

import java.sql.Date;
import java.util.List;

public class Compra {

		private int idCompra;
		private Cliente cliente;
		//		private List<Producto> compras;
		//		private Date fechaCompra;

		public Compra() {
				// TODO Auto-generated constructor stub
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




}
