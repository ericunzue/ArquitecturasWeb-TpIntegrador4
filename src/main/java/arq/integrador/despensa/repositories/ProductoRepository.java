package arq.integrador.despensa.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import arq.integrador.despensa.entities.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Integer> {
	
	
	
	
	@Query("SELECT p FROM Producto p where p.id_producto not in (SELECT det.id_producto FROM Compra c" 
			+ " JOIN c.detalles det" 
			+ " where (c.cliente=?1 and (DATE(c.fecha) = CURRENT_DATE()))"
			+ " GROUP BY det.id_producto"
			+ " HAVING (sum(det.cantidad<=3)))")
	List<Producto>getProductosHabilitadosPorCliente(int idCliente);
	
	

}
