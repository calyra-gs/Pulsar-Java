package br.com.fiap.pulsar.model;

public class Alerta {
    private int id;
    private String tipoDesastre;
    private String nivelRisco;
    private String mensagem;
    private OrgaoResponsavel orgaoResponsavel;
    private AreaRisco areaRisco;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTipoDesastre() {
        return tipoDesastre;
    }

    public void setTipoDesastre(String tipoDesastre) {
        this.tipoDesastre = tipoDesastre;
    }

    public String getNivelRisco() {
        return nivelRisco;
    }

    public void setNivelRisco(String nivelRisco) {
        this.nivelRisco = nivelRisco;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public OrgaoResponsavel getOrgaoResponsavel() {
        return orgaoResponsavel;
    }

    public void setOrgaoResponsavel(OrgaoResponsavel orgaoResponsavel) {
        this.orgaoResponsavel = orgaoResponsavel;
    }

    public AreaRisco getAreaRisco() {
        return areaRisco;
    }

    public void setAreaRisco(AreaRisco areaRisco) {
        this.areaRisco = areaRisco;
    }

    @Override
    public String toString() {
        return "Alerta{" +
                "id=" + id +
                ", tipoDesastre='" + tipoDesastre + '\'' +
                ", nivelRisco='" + nivelRisco + '\'' +
                ", mensagem='" + mensagem + '\'' +
                ", orgaoResponsavel=" + orgaoResponsavel +
                ", areaRisco=" + areaRisco +
                '}';
    }
}
