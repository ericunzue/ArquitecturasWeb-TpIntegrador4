package arq.integrador.despensa.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import arq.integrador.despensa.dto.ComprasDiariasDTO;
import arq.integrador.despensa.entities.Compra;

public interface CompraRepository extends JpaRepository<Compra, Integer> {
	
	
	@Query("SELECT NEW arq.integrador.despensa.dto.ComprasDiariasDTO(c.fecha,c.totalCompra) "
			+ "FROM Compra c ORDER BY c.fecha")
    public List<ComprasDiariasDTO> selectVentasDiarias();


}
