package arq.integrador.despensa.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import arq.integrador.despensa.entities.Cliente;
import arq.integrador.despensa.repositories.ClienteRepository;

@Service
public class ClienteService {

		@Autowired
		private ClienteRepository clientes;

		public List<Cliente> getLibros() {

				return this.clientes.findAll();
		}



		public boolean addCliente(Cliente cliente) {
				return this.clientes.save(cliente)!=null;


		}

}
