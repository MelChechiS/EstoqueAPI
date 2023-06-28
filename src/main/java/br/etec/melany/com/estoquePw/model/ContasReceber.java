package br.etec.melany.com.estoquePw.model;

import javax.persistence.*;
import java.math.BigInteger;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "contasreceber")

public class ContasReceber {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer id;

    private Date dataconta;

    private BigInteger valorconta;


    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    @ManyToOne
    @JoinColumn(name="idcliente")
    private Cliente cliente;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ContasReceber that = (ContasReceber) o;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
