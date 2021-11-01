package arq.integrador.despensa.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import arq.integrador.despensa.entities.Cliente;
import arq.integrador.despensa.services.ClienteService;


@RestController
@CrossOrigin(origins = "http://127.0.0.1:5500")
@RequestMapping("/cliente")
public class ClienteController {

		@Autowired
		private ClienteService servicioCliente;

		@GetMapping
		public List<Cliente> getAll() {

				return this.servicioCliente.getClientes();
		}

		@GetMapping("/{id}")
		public ResponseEntity<Cliente> getCliente(@PathVariable("id") int id){
				Optional<Cliente> cliente = this.servicioCliente.getClienteById(id);
				if (cliente.isEmpty()) {
						return new ResponseEntity<>(HttpStatus.NOT_FOUND);
				}

				return new ResponseEntity<Cliente>(cliente.get(),HttpStatus.OK);
		}

		@PostMapping("")
		public ResponseEntity<Cliente> addCliente(@RequestBody Cliente cliente){
				boolean ok = this.servicioCliente.addCliente(cliente);
				if (!ok) {
						return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
				}
				return new ResponseEntity<Cliente>(cliente,HttpStatus.OK);
		}

		@DeleteMapping("/{id}")
		public ResponseEntity<Cliente> deleteCliente(@PathVariable("id") int id){
				Optional<Cliente> cliente = this.servicioCliente.getClienteById(id);
				if (cliente.isEmpty()) {
						return new ResponseEntity<>(HttpStatus.NOT_FOUND);
				}
				this.servicioCliente.deleteById(id);
				return new ResponseEntity<Cliente>(cliente.get(),HttpStatus.OK);
		}

		@PutMapping("/{id}")
		public ResponseEntity<Cliente> update(@PathVariable("id") int id,@RequestBody Cliente cliente) {
				boolean ok = this.servicioCliente.update(id,cliente);
				if (!ok) {
						return new ResponseEntity<>(HttpStatus.NO_CONTENT);
				}
				return new ResponseEntity<Cliente>(cliente,HttpStatus.OK);
		}



}
