package arq.integrador.despensa.entities;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Cliente {

		@Id
		@GeneratedValue(strategy=GenerationType.AUTO)
		@Column(nullable = false)
		private int idCliente;
		private String nombre_apellido;
		private String direccion;

		public Cliente() {
				// TODO Auto-generated constructor stub
		}

		public Cliente(String nombre_apellido, String direccion) {
				super();
				this.nombre_apellido = nombre_apellido;
				this.direccion = direccion;
		}

		public String getNombre_apellido() {
				return nombre_apellido;
		}

		public void setNombre_apellido(String nombre_apellido) {
				this.nombre_apellido = nombre_apellido;
		}

		public String getDireccion() {
				return direccion;
		}

		public void setDireccion(String direccion) {
				this.direccion = direccion;
		}

		public int getIdCliente() {
				return idCliente;
		}

		@Override
		public String toString() {
			return "Cliente [idCliente=" + idCliente + ", nombre_apellido=" + nombre_apellido + ", direccion="
					+ direccion + "]";
		}

	
		


}
