package br.etec.melany.com.estoquePw.Repository.ContasReceber;

import br.etec.melany.com.estoquePw.Repository.filter.ContasReceberFilter;
import br.etec.melany.com.estoquePw.Repository.projections.ContasReceberDto;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ContasReceberRepositoryQuery {
    public Page<ContasReceberDto> filtrar(ContasReceberFilter contasReceberFilter, Pageable pageable);
}
