package br.com.fiap.pulsar.model;

public class GateWay {
    private int id;
    private String nome;
    private AreaRisco areaAtendida;
    private boolean ativo;

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

    public AreaRisco getAreaAtendida() {
        return areaAtendida;
    }

    public void setAreaAtendida(AreaRisco areaAtendida) {
        this.areaAtendida = areaAtendida;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    @Override
    public String toString() {
        return "GateWay{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", areaAtendida=" + areaAtendida +
                ", ativo=" + ativo +
                '}';
    }
}
