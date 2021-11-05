package arq.integrador.despensa.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import arq.integrador.despensa.entities.Compra;

import arq.integrador.despensa.services.CompraService;

@RestController
@CrossOrigin(origins = "http://127.0.0.1:5500")
@RequestMapping("/compra")
public class CompraController {
	
	@Autowired
	private CompraService servicioCompra;
	
	@PostMapping("")
	public ResponseEntity<Compra> addCompra(@RequestBody Compra compra){
			boolean ok = this.servicioCompra.addCompra(compra);
			if (!ok) {
					return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
			}
			return new ResponseEntity<Compra>(compra,HttpStatus.OK);
	}
	
	
	


	
	
	
}
