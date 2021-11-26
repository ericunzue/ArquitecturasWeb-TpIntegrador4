package arq.integrador.despensa.testJunit;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import arq.integrador.despensa.entities.Cliente;
import arq.integrador.despensa.entities.Compra;
import arq.integrador.despensa.entities.DetalleCompra;
import arq.integrador.despensa.entities.Producto;
import arq.integrador.despensa.services.ClienteService;
import arq.integrador.despensa.services.CompraService;
import arq.integrador.despensa.services.DetalleCompraService;
import arq.integrador.despensa.services.ProductoService;

@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
public class DespensaServiceTest {

	/** The product service. */
	@Autowired
	private ProductoService productoService;
	
	/** The compra service. */
	@Autowired
	private CompraService compraService;
	
	/** The details service. */
	@Autowired
	private DetalleCompraService detalleService;
	
	/** The client service. */
	@Autowired
	private ClienteService clienteService;
	
	/**
	 * Test Gets Compra by ID.
	 */
	@Test
	@Order(1)
	void getCompraById() {
		Assertions.assertEquals(compraService.getCompraById(5).get().getIdCompra(), 5);
	
}
	@Test
	@Order(2)
	void addProducto() {
		Producto p= new Producto("NuevoProducto",40,100);			
		int cantAnterior=productoService.getProductos().size();
		productoService.addProducto(p);
		Assertions.assertEquals(productoService.getProductos().size(),cantAnterior+1);
		
		
	}
	
	@Test
	@Order(3)	
	void addCliente() {
		
		Cliente cli=new Cliente("Mega Analia", "Bolivar");
		int cantClientes=clienteService.getClientes().size();
		clienteService.addCliente(cli);
		Assertions.assertEquals(clienteService.getClientes().size(),cantClientes+1);	
		
	}
	
}