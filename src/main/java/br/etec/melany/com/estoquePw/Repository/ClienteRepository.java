package br.etec.melany.com.estoquePw.Repository;

import br.etec.melany.com.estoquePw.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface ClienteRepository extends JpaRepository<Cliente, Integer>{

}




