package arq.integrador.despensa.repositories;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import arq.integrador.despensa.entities.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Integer> {

	@Query("SELECT p FROM Producto p WHERE p.idProducto NOT IN "
			+ "(SELECT  d.producto FROM Compra c JOIN c.detalles d "
			+ "WHERE ((c.cliente.idCliente=?1) AND (DATE(c.fecha)=CURRENT_DATE())) "
			+ "GROUP BY d.producto HAVING SUM(d.cantidad)>=3"
			+ ")")
	List<Producto> getProductosHabilitadosPorCliente(int idCliente);
//	
//	"SELECT p FROM Producto p where p.id_producto not in (SELECT det.id_producto FROM Compra c"
//	+ " JOIN c.detalles det" + " where (c.cliente=?1 and (DATE(c.fecha) = CURRENT_DATE()))"
//	+ " GROUP BY det.id_producto" + " HAVING (sum(det.cantidad<=3)))")
//SELECT p FROM Producto p WHERE p.idProducto NOT IN(SELECT c.detalles FROM Compra c JOIN c.detalles det WHERE((c.cliente=?1) AND (DATE (c.fecha)=CURRENT_DATE())) GROUP BY det.idProducto HAVING (sum(det.cantidad<=1)) )
}
//("SELECT p FROM Producto p WHERE p.idProducto NOT IN (SELECT d FROM Compra c JOIN DetalleCompra d WHERE ((c.cliente=?1) AND (DATE(c.fecha)=CURRENT_DATE())) "
//+ ")")