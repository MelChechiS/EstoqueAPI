package br.etec.melany.com.estoquePw.Resource;

import br.etec.melany.com.estoquePw.Repository.ContasReceberRepository;
import br.etec.melany.com.estoquePw.model.ContasReceber;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

public class ContasReceberResource {

    @Autowired
    private ContasReceberRepository contasReceberRepository;

    @GetMapping("/todos")
    public List<ContasReceber> listarTodasContasReceber(){
        return contasReceberRepository.findAll();
    }
}
