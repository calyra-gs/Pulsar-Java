package br.com.fiap.pulsar.model;

public class Morador {
    private int id;
    private String nome;
    private String telefone;
    private String status;
    private boolean possuiVulneravel;
    private AreaRisco areaRisco;

    public Morador() {
    }

    public Morador(int id, String nome, String telefone, String status,
                   boolean possuiVulneravel, AreaRisco areaRisco) {
        this.id = id;
        this.nome = nome;
        this.telefone = telefone;
        this.status = status;
        this.possuiVulneravel = possuiVulneravel;
        this.areaRisco = areaRisco;
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

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public boolean isPossuiVulneravel() {
        return possuiVulneravel;
    }

    public void setPossuiVulneravel(boolean possuiVulneravel) {
        this.possuiVulneravel = possuiVulneravel;
    }

    public AreaRisco getAreaRisco() {
        return areaRisco;
    }

    public void setAreaRisco(AreaRisco areaRisco) {
        this.areaRisco = areaRisco;
    }

    @Override
    public String toString() {
        return "Morador{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", telefone='" + telefone + '\'' +
                ", status='" + status + '\'' +
                ", possuiVulneravel=" + possuiVulneravel +
                ", areaRisco=" + areaRisco +
                '}';
    }
}
