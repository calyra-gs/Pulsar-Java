package br.com.fiap.pulsar.model;

public class Ocorrencia {
    private int id;
    private Morador morador;
    private String tipo;
    private String descricao;
    private int prioridade;

    public Ocorrencia() {
    }

    public Ocorrencia(int id, Morador morador, String tipo, String descricao, int prioridade) {
        this.id = id;
        this.morador = morador;
        this.tipo = tipo;
        this.descricao = descricao;
        this.prioridade = prioridade;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Morador getMorador() {
        return morador;
    }

    public void setMorador(Morador morador) {
        this.morador = morador;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(int prioridade) {
        this.prioridade = prioridade;
    }

    @Override
    public String toString() {
        return "Ocorrencia{" +
                "id=" + id +
                ", morador=" + morador +
                ", tipo='" + tipo + '\'' +
                ", descricao='" + descricao + '\'' +
                ", prioridade=" + prioridade +
                '}';
    }
}
