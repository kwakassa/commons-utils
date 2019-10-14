package br.com.utils.pojo;

import java.util.Date;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlType(propOrder = {"nome", "data", "valor", "teste", "dias"})
@XmlRootElement(name = "foo")
public class FooPOJO {
    private String nome;
    private double valor;
    private Date datainicio;
    private String teste;

    @XmlElement
    public String getNome() {
        return this.nome;
    }

    public FooPOJO setNome(final String nome) {
        this.nome = nome;
        return this;
    }

    @XmlElement
    public double getValor() {
        return this.valor;
    }

    public FooPOJO setValor(final double valor) {
        this.valor = valor;
        return this;
    }

    @XmlElement
    public Date getData() {
        return this.datainicio;
    }

    public FooPOJO setData(final Date datainicio) {
        this.datainicio = datainicio;
        return this;
    }

    @XmlElement
    public String getTeste() {
        return "TesteABC";
    }

    public FooPOJO setTeste(final String teste) {
        return this;
    }

    @XmlElement
    public int getDias() {
        return 10;
    }
    // public FooPOJO setDias(){return this;}

}
