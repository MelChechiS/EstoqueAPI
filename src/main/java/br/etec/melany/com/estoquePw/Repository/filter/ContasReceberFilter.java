package br.etec.melany.com.estoquePw.Repository.filter;

import java.math.BigInteger;
import java.util.Date;

public class ContasReceberFilter {

    private String nomecliente;

    private Date dataconta;

    private BigInteger valorconta;

    public String getNomecliente() {
        return nomecliente;
    }

    public void setNomecliente(String nomecliente) {
        this.nomecliente = nomecliente;
    }

    public Date getDataconta() {
        return dataconta;
    }

    public void setDataconta(Date dataconta) {
        this.dataconta = dataconta;
    }

    public BigInteger getValorconta() {
        return valorconta;
    }

    public void setValorconta(BigInteger valorconta) {
        this.valorconta = valorconta;
    }
}
