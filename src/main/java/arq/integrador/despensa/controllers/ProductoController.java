package arq.integrador.despensa.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import arq.integrador.despensa.entities.Producto;
import arq.integrador.despensa.services.ProductoService;

@RestController
@CrossOrigin
@RequestMapping("/producto")
public class ProductoController {

	@Autowired
	private ProductoService servicioProducto;

	@PostMapping("")
	public ResponseEntity<Producto> addProducto(@RequestBody Producto producto) {
		boolean ok = this.servicioProducto.addProducto(producto);
		if (!ok) {
			return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
		}
		return new ResponseEntity<Producto>(producto, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Producto> getProducto(@PathVariable("id") int id) {
		Optional<Producto> producto = this.servicioProducto.getProductoById(id);
		if (producto.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<Producto>(producto.get(), HttpStatus.OK);
	}

	@GetMapping
	public List<Producto> getAll() {

		return this.servicioProducto.getProductos();
	}

	@PutMapping("/{id}")
	public ResponseEntity<Producto> update(@PathVariable("id") int id, @RequestBody Producto producto) {
		boolean ok = this.servicioProducto.update(id, producto);
		if (!ok) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<Producto>(producto, HttpStatus.OK);
	}
	
	@GetMapping("/productoCliente/{id}")
	public List<Producto> getProductoPorCliente(@PathVariable("id") int id) {
		List<Producto> productos = this.servicioProducto.getProductosPorCliente(id);
		return productos;
	}


}
