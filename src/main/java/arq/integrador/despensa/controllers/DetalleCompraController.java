package arq.integrador.despensa.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import arq.integrador.despensa.entities.DetalleCompra;

import arq.integrador.despensa.services.DetalleCompraService;

@RestController
@CrossOrigin(origins = "http://127.0.0.1:5500")
@RequestMapping("/detalle")

public class DetalleCompraController {
	
	@Autowired
	private DetalleCompraService servicioDetalle;
	
	@PostMapping("")
	public ResponseEntity<DetalleCompra> addDetalle(@RequestBody DetalleCompra detalleC){
			System.out.println(detalleC.toString());
			boolean ok = this.servicioDetalle.addDetalle(detalleC);
			if (!ok) {
					return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
			}
			return new ResponseEntity<DetalleCompra>(detalleC,HttpStatus.OK);
	}

}
