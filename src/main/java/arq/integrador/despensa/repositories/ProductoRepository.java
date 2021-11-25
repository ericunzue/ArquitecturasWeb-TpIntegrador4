package arq.integrador.despensa.repositories;

import java.util.List;

import org.springframework.data.domain.Pageable;
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
	
	
	@Query("SELECT p  FROM DetalleCompra det JOIN det.producto p group by p order by sum(det.cantidad) desc")
	List<Producto> getProductoMasVendido(Pageable pageable);

}
