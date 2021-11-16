package arq.integrador.despensa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import arq.integrador.despensa.entities.DetalleCompra;
//import arq.integrador.despensa.entities.DetalleCompraId;

public interface DetalleCompraRepository extends JpaRepository<DetalleCompra, Integer> {

	
	
}
