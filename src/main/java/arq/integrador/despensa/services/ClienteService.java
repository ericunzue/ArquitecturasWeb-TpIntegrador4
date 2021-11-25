package arq.integrador.despensa.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import arq.integrador.despensa.dto.ComprasPorClienteDTO;
import arq.integrador.despensa.entities.Cliente;
import arq.integrador.despensa.repositories.ClienteRepository;

@Service
public class ClienteService {

		@Autowired
		private ClienteRepository clientes;

		public List<Cliente> getClientes() {

				return this.clientes.findAll();
		}

		public Optional<Cliente> getClienteById(int id) {
				return this.clientes.findById(id);
		}

		public void deleteById(int id) {
				this.clientes.deleteById(id);
		}


		public boolean addCliente(Cliente cliente) {
				return this.clientes.save(cliente)!=null;

		}
		
		public List<ComprasPorClienteDTO> comprasPorCliente(){
			
			return this.clientes.selectTotalComprasClientes();
			
		}


		public boolean update(int id ,Cliente clienteModificado) {
				Cliente cliente = this.clientes.getById(id);
				System.out.println(cliente);
				cliente.setNombre_apellido(clienteModificado.getNombre_apellido());
				cliente.setDireccion(clienteModificado.getDireccion());
				System.out.println(cliente);

				return this.clientes.save(cliente)!=null;

		}

}
