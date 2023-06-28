package br.etec.melany.com.estoquePw.Resource;

import br.etec.melany.com.estoquePw.Repository.ClienteRepository;
import br.etec.melany.com.estoquePw.model.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

public class ClienteResource {

    @Autowired
    private ClienteRepository clienteRepository;

    @GetMapping("/todos")
    public List<Cliente> listarTodosClientes(){
        return clienteRepository.findAll();
    }
}
