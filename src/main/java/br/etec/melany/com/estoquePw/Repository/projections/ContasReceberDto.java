package br.etec.melany.com.estoquePw.Repository.projections;

import java.math.BigInteger;

public class ContasReceberDto {

    private Integer id;

    private String nomecliente;

    private BigInteger valorconta;

    public ContasReceberDto(Integer id, String nomecliente, BigInteger valorconta) {
        this.id = id;
        this.nomecliente= nomecliente;
        this.valorconta = valorconta;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNomecliente() {
        return nomecliente;
    }

    public void setNomecliente(String nomecliente) {
        this.nomecliente = nomecliente;
    }

    public BigInteger getValorconta() {
        return valorconta;
    }

    public void setValorconta(BigInteger valorconta) {
        this.valorconta = valorconta;
    }
}
