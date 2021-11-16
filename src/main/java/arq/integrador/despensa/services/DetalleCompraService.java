package arq.integrador.despensa.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import arq.integrador.despensa.entities.DetalleCompra;
//import arq.integrador.despensa.entities.DetalleCompraId;

import arq.integrador.despensa.repositories.DetalleCompraRepository;

@Service
public class DetalleCompraService {
	
	@Autowired
	private DetalleCompraRepository detalle;

	
	public List<DetalleCompra> getDetalle() {

		return this.detalle.findAll();
}

//public Optional<DetalleCompra> getCompraById(DetalleCompra id) {
//		return this.detalle.findById(id);
//}




public boolean addDetalle(DetalleCompra detalleC) {
	System.out.println(detalleC.toString());
	return this.detalle.save(detalleC)!=null;

}



}