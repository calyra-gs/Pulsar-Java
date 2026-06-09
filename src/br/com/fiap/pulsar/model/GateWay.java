package br.com.fiap.pulsar.model;

public class GateWay {
    private int id;
    private String nome;
    private AreaRisco areaAtendida;
    private boolean ativo;

    public GateWay() {
    }

    public GateWay(int id, String nome, AreaRisco areaAtendida, boolean ativo) {
        this.id = id;
        this.nome = nome;
        this.areaAtendida = areaAtendida;
        this.ativo = ativo;
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
