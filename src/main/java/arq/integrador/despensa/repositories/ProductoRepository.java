package arq.integrador.despensa.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import arq.integrador.despensa.entities.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Integer> {
	
	
	
	@Modifying
	@Query( value="SELECT * FROM producto p where id_producto not in (SELECT det.id_producto FROM compra c inner join compra_detalles" 
			+ " d on c.id_compra=d.compra_id_compra inner join detalle_compra det" 
			+ " on d.detalles_id_detalle= det.id_detalle"
			+ " where c.id_cliente=:idCliente"
			+ " GROUP BY  det.id_producto"
			+ " HAVING (sum(det.cantidad <=3)))",nativeQuery=true)
	List<Producto>getProductosHabilitadosPorCliente(Long idCliente);

}
