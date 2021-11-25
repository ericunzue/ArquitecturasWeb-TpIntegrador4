package arq.integrador.despensa.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;

import arq.integrador.despensa.dto.ComprasPorClienteDTO;
import arq.integrador.despensa.entities.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

//	@GetMapping(value="/totalcompras",produces= MediaType.APPLICATION_JSON_VALUE)
	@Query("SELECT NEW arq.integrador.despensa.dto.ComprasPorClienteDTO(cli.nombre_apellido,cli.direccion, SUM(c.totalCompra) AS total_compras) "
			+ "FROM Compra c JOIN c.cliente cli GROUP BY cli.nombre_apellido, cli.direccion")
	public List<ComprasPorClienteDTO> selectTotalComprasClientes();
}
