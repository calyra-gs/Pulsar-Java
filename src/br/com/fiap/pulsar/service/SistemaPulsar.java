package br.com.fiap.pulsar.service;

import br.com.fiap.pulsar.model.Alerta;
import br.com.fiap.pulsar.model.AreaRisco;
import br.com.fiap.pulsar.model.GateWay;
import br.com.fiap.pulsar.model.Morador;
import br.com.fiap.pulsar.model.Ocorrencia;
import br.com.fiap.pulsar.model.OrgaoResponsavel;
import br.com.fiap.pulsar.model.RotaMensagem;

public class SistemaPulsar {
    public Alerta emitirAlerta(int id, String tipoDesastre, String nivelRisco, String mensagem,
                               OrgaoResponsavel orgao, AreaRisco area) {
        Alerta alerta = new Alerta();
        alerta.setId(id);
        alerta.setTipoDesastre(tipoDesastre);
        alerta.setNivelRisco(nivelRisco);
        alerta.setMensagem(mensagem);
        alerta.setOrgaoResponsavel(orgao);
        alerta.setAreaRisco(area);
        return alerta;
    }

    public Ocorrencia registrarOcorrencia(int id, Morador morador, String tipo, String descricao) {
        Ocorrencia ocorrencia = new Ocorrencia();
        ocorrencia.setId(id);
        ocorrencia.setMorador(morador);
        ocorrencia.setTipo(tipo);
        ocorrencia.setDescricao(descricao);
        ocorrencia.setPrioridade(calcularPrioridade(tipo, morador.isPossuiVulneravel()));
        return ocorrencia;
    }

    public int calcularPrioridade(String tipo, boolean possuiVulneravel) {
        if ("preciso de resgate".equalsIgnoreCase(tipo) && possuiVulneravel) {
            return 1;
        } else if ("preciso de resgate".equalsIgnoreCase(tipo)) {
            return 2;
        } else if ("evacuei".equalsIgnoreCase(tipo)) {
            return 3;
        } else {
            return 4;
        }
    }

    public RotaMensagem simularRotaMensagem(Alerta alerta, GateWay gatewayPrincipal, GateWay gatewayAlternativo) {
        RotaMensagem rotaMensagem = new RotaMensagem();
        rotaMensagem.setId(1);
        rotaMensagem.setOrigem(alerta.getOrgaoResponsavel().getNome());

        if (gatewayPrincipal.isAtivo()) {
            rotaMensagem.setDestino(gatewayPrincipal.getNome());
            rotaMensagem.setStatus("Mensagem entregue pelo gateway principal");
            rotaMensagem.setQuantidadeSaltos(2);
        } else {
            rotaMensagem.setDestino(gatewayAlternativo.getNome());
            rotaMensagem.setStatus("Gateway principal indisponivel. Mensagem guardada e reencaminhada pelo gateway alternativo");
            rotaMensagem.setQuantidadeSaltos(4);
        }

        return rotaMensagem;
    }

    public String gerarResumoOperacional(Alerta alerta, Ocorrencia ocorrencia, RotaMensagem rota) {
        return "Resumo Operacional Pulsar\n"
                + "Alerta: " + alerta.getMensagem() + "\n"
                + "Area: " + alerta.getAreaRisco().getNome() + "\n"
                + "Ocorrencia: " + ocorrencia.getTipo() + "\n"
                + "Prioridade: " + ocorrencia.getPrioridade() + "\n"
                + "Rota: " + rota.getStatus();
    }
}
