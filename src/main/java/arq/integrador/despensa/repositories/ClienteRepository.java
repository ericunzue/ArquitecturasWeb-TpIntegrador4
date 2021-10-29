package arq.integrador.despensa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import arq.integrador.despensa.entities.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

}
