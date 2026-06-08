package br.com.fiap.pulsar.model;

public class AreaRisco {
    private int id;
    private String nome;
    private String tipoRisco;
    private String nivelRisco;

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

    public String getTipoRisco() {
        return tipoRisco;
    }

    public void setTipoRisco(String tipoRisco) {
        this.tipoRisco = tipoRisco;
    }

    public String getNivelRisco() {
        return nivelRisco;
    }

    public void setNivelRisco(String nivelRisco) {
        this.nivelRisco = nivelRisco;
    }

    @Override
    public String toString() {
        return "AreaRisco{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", tipoRisco='" + tipoRisco + '\'' +
                ", nivelRisco='" + nivelRisco + '\'' +
                '}';
    }
}
