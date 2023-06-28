package br.etec.melany.com.estoquePw.Repository.ContasReceber;

import br.etec.melany.com.estoquePw.Repository.filter.ContasReceberFilter;
import br.etec.melany.com.estoquePw.Repository.projections.ContasReceberDto;

import br.etec.melany.com.estoquePw.model.ContasReceber;
import org.apache.commons.lang3.StringUtils;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;


import java.util.ArrayList;
import java.util.List;

public class ContasReceberRepositoryImpl implements ContasReceberRepositoryQuery{

    @PersistenceContext
    private EntityManager manager;

    @Override
    public Page<ContasReceberDto> filtrar(ContasReceberFilter contasReceberFilter, Pageable pageable) {
        CriteriaBuilder builder = manager.getCriteriaBuilder();
        CriteriaQuery<ContasReceberDto> criteria = builder.createQuery(ContasReceberDto.class);
        Root<ContasReceber> root = criteria.from(ContasReceber.class);

        criteria.select(builder.construct(ContasReceberDto.class
                , root.get("id")
                , root.get("cliente").get("nomecliente")
                , root.get("dataconta")
                , root.get("valorconta")
        ));

        Predicate[] predicates = criarRestricoes(contasReceberFilter, builder, root);
        criteria.where(predicates);
        criteria.orderBy(builder.asc(root.get("cliente").get("nomecliente")));

        TypedQuery<ContasReceberDto> query = manager.createQuery(criteria);

        adicionarRestricoesDePaginacao(query, pageable);

        return new PageImpl<>(query.getResultList(), pageable, totalDePaginas(contasReceberFilter));
    }

    private Long totalDePaginas (ContasReceberFilter contasReceberFilter){
        CriteriaBuilder builder = manager.getCriteriaBuilder();
        CriteriaQuery<Long> criteria = builder.createQuery(Long.class);
        Root<ContasReceber> root = criteria.from(ContasReceber.class);

        Predicate[] predicates = criarRestricoes(contasReceberFilter, builder, root);
        criteria.where(predicates);
        criteria.orderBy(builder.asc(root.get("cliente").get("nomecliente")));

        criteria.select(builder.count(root));

        return manager.createQuery(criteria).getSingleResult();
    }

    private void adicionarRestricoesDePaginacao (TypedQuery <?> query, Pageable pageable){
        int paginaAtual = pageable.getPageNumber();
        int totalDeRegistrosPorPagina = pageable.getPageSize();
        int primeiroRegistroDaPagina = paginaAtual * totalDeRegistrosPorPagina;

        query.setFirstResult(primeiroRegistroDaPagina);
        query.setMaxResults(totalDeRegistrosPorPagina);
    }


    private Predicate[] criarRestricoes(ContasReceberFilter contasReceberFilter, CriteriaBuilder builder, Root<ContasReceber> root) {
        List<Predicate> predicates = new ArrayList<>();

        if (!StringUtils.isEmpty(contasReceberFilter.getNomecliente())) {
            predicates.add(builder.like(builder.lower(root.get("cliente").get("nomecliente")),
                    "%" + contasReceberFilter.getNomecliente().toLowerCase() + "%"));
        }

        if(contasReceberFilter.getValorconta() != null){
            predicates.add(builder.equal(root.get("valorconta"), contasReceberFilter.getValorconta()));
        }

        if(contasReceberFilter.getDataconta() != null){
            predicates.add(builder.greaterThanOrEqualTo(root.get("dataconta"), contasReceberFilter.getDataconta()));
        }

        return predicates.toArray(new Predicate[predicates.size()]);


    }
}



