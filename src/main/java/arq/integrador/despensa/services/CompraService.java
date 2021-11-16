package arq.integrador.despensa.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import arq.integrador.despensa.entities.Compra;

import arq.integrador.despensa.repositories.CompraRepository;

@Service
public class CompraService {
	
	@Autowired
	private CompraRepository compras;

	
	public List<Compra> getCompras() {

		return this.compras.findAll();
}

public Optional<Compra> getCompraById(int id) {
		return this.compras.findById(id);
}

public void deleteById(int id) {
		this.compras.deleteById(id);
}


public boolean addCompra(Compra compra) {
	System.out.println(compra);
		return this.compras.save(compra)!=null;

}


public boolean update(int id ,Compra compraModificado) {
		Compra compra = this.compras.getById(id);
		compra.setCliente(compraModificado.getCliente());
		return this.compras.save(compra)!=null;

}
}
