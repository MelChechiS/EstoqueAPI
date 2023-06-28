package br.etec.melany.com.estoquePw.Repository.Cliente;

import br.etec.melany.com.estoquePw.Repository.filter.ClienteFilter;
import br.etec.melany.com.estoquePw.model.Cliente;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ClienteRepositoryQuery {
    public Page<Cliente> Filtrar(ClienteFilter clienteFilter, Pageable pageble);

}
