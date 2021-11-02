package arq.integrador.despensa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import arq.integrador.despensa.entities.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Integer> {

}
