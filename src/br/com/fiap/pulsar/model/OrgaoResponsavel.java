package br.com.fiap.pulsar.model;

public class OrgaoResponsavel {
    private int id;
    private String nome;
    private String tipo;
    private String cidade;

    public OrgaoResponsavel() {
    }

    public OrgaoResponsavel(int id, String nome, String tipo, String cidade) {
        this.id = id;
        this.nome = nome;
        this.tipo = tipo;
        this.cidade = cidade;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    @Override
    public String toString() {
        return "OrgaoResponsavel{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", tipo='" + tipo + '\'' +
                ", cidade='" + cidade + '\'' +
                '}';
    }
}
