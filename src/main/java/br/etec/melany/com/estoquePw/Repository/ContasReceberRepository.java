package br.etec.melany.com.estoquePw.Repository;

import br.etec.melany.com.estoquePw.model.ContasReceber;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface ContasReceberRepository extends JpaRepository<ContasReceber, Long> {
}
