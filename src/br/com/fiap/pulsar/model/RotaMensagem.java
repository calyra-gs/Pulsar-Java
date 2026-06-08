package br.com.fiap.pulsar.model;

public class RotaMensagem {
    private int id;
    private String origem;
    private String destino;
    private String status;
    private int quantidadeSaltos;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOrigem() {
        return origem;
    }

    public void setOrigem(String origem) {
        this.origem = origem;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getQuantidadeSaltos() {
        return quantidadeSaltos;
    }

    public void setQuantidadeSaltos(int quantidadeSaltos) {
        this.quantidadeSaltos = quantidadeSaltos;
    }

    @Override
    public String toString() {
        return "RotaMensagem{" +
                "id=" + id +
                ", origem='" + origem + '\'' +
                ", destino='" + destino + '\'' +
                ", status='" + status + '\'' +
                ", quantidadeSaltos=" + quantidadeSaltos +
                '}';
    }
}
