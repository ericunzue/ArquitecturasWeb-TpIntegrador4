package arq.integrador.despensa.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import arq.integrador.despensa.entities.Producto;
import arq.integrador.despensa.repositories.ProductoRepository;

@Service
public class ProductoService {
	
	@Autowired
	private ProductoRepository productos;
	
	public List<Producto> getProductos() {

		return this.productos.findAll();
}

public Optional<Producto> getProductoById(int id) {
		return this.productos.findById(id);
}

public void deleteById(int id) {
		this.productos.deleteById(id);
}


public boolean addProducto(Producto producto) {
		return this.productos.save(producto)!=null;
		


}


public boolean update(int id ,Producto productoModificado) {
		Producto producto = this.productos.getById(id);
		producto.setNombre(productoModificado.getNombre());
		producto.setStock(productoModificado.getStock());
		producto.setPrecio(productoModificado.getPrecio());
	

		return this.productos.save(producto)!=null;

}

public List<Producto> getProductosPorCliente(Long idCliente){
	
	 return this.productos.getProductosHabilitadosPorCliente(idCliente);
}	

}
