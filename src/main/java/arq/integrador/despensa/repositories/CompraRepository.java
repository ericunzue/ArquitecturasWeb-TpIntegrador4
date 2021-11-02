package arq.integrador.despensa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import arq.integrador.despensa.entities.Compra;

public interface CompraRepository extends JpaRepository<Compra, Integer> {

}
