package arq.integrador.despensa.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import arq.integrador.despensa.entities.Cliente;
import arq.integrador.despensa.services.ClienteService;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

		@Autowired
		private ClienteService servicioCliente;

		@GetMapping
		public boolean getAll() {

				return true;
		}
		@PostMapping("")
		public ResponseEntity<Cliente> addCliente(@RequestBody Cliente cliente){
				boolean ok = this.servicioCliente.addCliente(cliente);
				if (!ok) {
						return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
				}
				return new ResponseEntity<Cliente>(cliente,HttpStatus.OK);
		}

}
