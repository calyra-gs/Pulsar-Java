package br.com.fiap.pulsar.terminal;

import br.com.fiap.pulsar.model.Alerta;
import br.com.fiap.pulsar.model.AreaRisco;
import br.com.fiap.pulsar.model.GateWay;
import br.com.fiap.pulsar.model.Morador;
import br.com.fiap.pulsar.model.Ocorrencia;
import br.com.fiap.pulsar.model.OrgaoResponsavel;
import br.com.fiap.pulsar.model.RotaMensagem;
import br.com.fiap.pulsar.service.SistemaPulsar;

import java.util.Scanner;

public class Terminal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SistemaPulsar sistema = new SistemaPulsar();

        System.out.println("=== PULSAR - SIMULACAO JAVA ===");
        System.out.println("Preencha as informacoes para simular o funcionamento do Pulsar.");
        System.out.println();

        AreaRisco areaRisco = cadastrarAreaRisco(scanner);
        OrgaoResponsavel orgao = cadastrarOrgaoResponsavel(scanner);
        Morador morador = cadastrarMorador(scanner, areaRisco);
        GateWay gatewayPrincipal = cadastrarGateway(scanner, 1, "principal", areaRisco);
        GateWay gatewayAlternativo = cadastrarGateway(scanner, 2, "alternativo", areaRisco);

        System.out.println();
        System.out.println("=== EMISSAO DO ALERTA ===");
        String tipoDesastre = lerTexto(scanner, "Tipo de desastre: ");
        String mensagemAlerta = lerTexto(scanner, "Mensagem oficial do alerta: ");

        Alerta alerta = sistema.emitirAlerta(
                1,
                tipoDesastre,
                areaRisco.getNivelRisco(),
                mensagemAlerta,
                orgao,
                areaRisco
        );

        RotaMensagem rotaMensagem = sistema.simularRotaMensagem(alerta, gatewayPrincipal, gatewayAlternativo);

        System.out.println();
        System.out.println("=== RESPOSTA DO MORADOR ===");
        System.out.println("Exemplos de tipo: Preciso de resgate | Evacuei | Estou seguro");
        String tipoOcorrencia = lerTexto(scanner, "Tipo da ocorrencia: ");
        String descricaoOcorrencia = lerTexto(scanner, "Descricao da ocorrencia: ");

        Ocorrencia ocorrencia = sistema.registrarOcorrencia(
                1,
                morador,
                tipoOcorrencia,
                descricaoOcorrencia
        );

        String resumoOperacional = sistema.gerarResumoOperacional(alerta, ocorrencia, rotaMensagem);

        imprimirResultado(
                areaRisco,
                orgao,
                morador,
                gatewayPrincipal,
                gatewayAlternativo,
                alerta,
                rotaMensagem,
                ocorrencia,
                resumoOperacional
        );
        scanner.close();
    }

    private static AreaRisco cadastrarAreaRisco(Scanner scanner) {
        System.out.println("=== AREA DE RISCO ===");

        AreaRisco areaRisco = new AreaRisco();
        areaRisco.setId(1);
        areaRisco.setNome(lerTexto(scanner, "Bairro/area atingida: "));
        areaRisco.setTipoRisco(lerTexto(scanner, "Tipo de risco: "));
        areaRisco.setNivelRisco(lerTexto(scanner, "Nivel de risco: "));
        return areaRisco;
    }

    private static OrgaoResponsavel cadastrarOrgaoResponsavel(Scanner scanner) {
        System.out.println();
        System.out.println("=== ORGAO RESPONSAVEL ===");

        OrgaoResponsavel orgao = new OrgaoResponsavel();
        orgao.setId(1);
        orgao.setNome(lerTexto(scanner, "Nome do orgao: "));
        orgao.setTipo(lerTexto(scanner, "Tipo do orgao: "));
        orgao.setCidade(lerTexto(scanner, "Cidade: "));
        return orgao;
    }

    private static Morador cadastrarMorador(Scanner scanner, AreaRisco areaRisco) {
        System.out.println();
        System.out.println("=== MORADOR ===");

        Morador morador = new Morador();
        morador.setId(1);
        morador.setNome(lerTexto(scanner, "Nome do morador: "));
        morador.setTelefone(lerTexto(scanner, "Telefone: "));
        morador.setStatus(lerTexto(scanner, "Status inicial: "));
        morador.setPossuiVulneravel(lerBooleano(scanner, "Ha pessoa vulneravel no local? (s/n): "));
        morador.setAreaRisco(areaRisco);
        return morador;
    }

    private static GateWay cadastrarGateway(Scanner scanner, int id, String tipoGateway, AreaRisco areaRisco) {
        System.out.println();
        System.out.println("=== GATEWAY " + tipoGateway.toUpperCase() + " ===");

        GateWay gateway = new GateWay();
        gateway.setId(id);
        gateway.setNome(lerTexto(scanner, "Nome do gateway " + tipoGateway + ": "));
        gateway.setAreaAtendida(areaRisco);
        gateway.setAtivo(lerBooleano(scanner, "Gateway " + tipoGateway + " esta ativo? (s/n): "));
        return gateway;
    }

    private static void imprimirResultado(AreaRisco areaRisco, OrgaoResponsavel orgao, Morador morador,
                                          GateWay gatewayPrincipal, GateWay gatewayAlternativo, Alerta alerta,
                                          RotaMensagem rotaMensagem, Ocorrencia ocorrencia,
                                          String resumoOperacional) {
        System.out.println();
        System.out.println("=== RESULTADO DA SIMULACAO ===");
        System.out.println();
        System.out.println("Area de risco cadastrada:");
        System.out.println("ID: " + areaRisco.getId());
        System.out.println("Bairro: " + areaRisco.getNome());
        System.out.println("Tipo de risco: " + areaRisco.getTipoRisco());
        System.out.println("Nivel de risco: " + areaRisco.getNivelRisco());
        System.out.println();
        System.out.println("Orgao responsavel:");
        System.out.println("ID: " + orgao.getId());
        System.out.println("Nome: " + orgao.getNome());
        System.out.println("Tipo: " + orgao.getTipo());
        System.out.println("Cidade: " + orgao.getCidade());
        System.out.println();
        System.out.println("Morador:");
        System.out.println("ID: " + morador.getId());
        System.out.println("Nome: " + morador.getNome());
        System.out.println("Telefone: " + morador.getTelefone());
        System.out.println("Status inicial: " + morador.getStatus());
        System.out.println("Pessoa vulneravel no local: " + simNao(morador.isPossuiVulneravel()));
        System.out.println("Area vinculada: " + morador.getAreaRisco().getNome());
        System.out.println();
        System.out.println("Gateways cadastrados:");
        System.out.println(gatewayPrincipal.getNome() + " - ativo: " + simNao(gatewayPrincipal.isAtivo()));
        System.out.println(gatewayAlternativo.getNome() + " - ativo: " + simNao(gatewayAlternativo.isAtivo()));
        System.out.println();
        System.out.println("Alerta emitido:");
        System.out.println("ID: " + alerta.getId());
        System.out.println("Tipo de desastre: " + alerta.getTipoDesastre());
        System.out.println("Nivel de risco: " + alerta.getNivelRisco());
        System.out.println("Mensagem: " + alerta.getMensagem());
        System.out.println("Area do alerta: " + alerta.getAreaRisco().getNome());
        System.out.println("Orgao emissor: " + alerta.getOrgaoResponsavel().getNome());
        System.out.println();
        System.out.println("Simulacao da rota:");
        System.out.println("Origem: " + rotaMensagem.getOrigem());
        System.out.println("Destino: " + rotaMensagem.getDestino());
        System.out.println("Quantidade de saltos: " + rotaMensagem.getQuantidadeSaltos());

        if (!gatewayPrincipal.isAtivo()) {
            System.out.println("Gateway principal indisponivel.");
            System.out.println("Mensagem guardada e reencaminhada pelo gateway alternativo.");
        } else {
            System.out.println(rotaMensagem.getStatus() + ".");
        }
        System.out.println();
        System.out.println("Resposta do morador:");
        System.out.println("ID: " + ocorrencia.getId());
        System.out.println("Morador vinculado: " + ocorrencia.getMorador().getNome());
        System.out.println("Tipo: " + ocorrencia.getTipo());
        System.out.println("Descricao: " + ocorrencia.getDescricao());
        System.out.println();
        System.out.println("Prioridade calculada:");
        System.out.println(ocorrencia.getPrioridade() + " - " + descreverPrioridade(ocorrencia.getPrioridade()));
        System.out.println();
        System.out.println("Resumo operacional gerado pelo sistema:");
        System.out.println(resumoOperacional);
        System.out.println();
        System.out.println("Estado final dos objetos:");
        System.out.println(areaRisco);
        System.out.println(orgao);
        System.out.println(morador);
        System.out.println(gatewayPrincipal);
        System.out.println(gatewayAlternativo);
        System.out.println(alerta);
        System.out.println(rotaMensagem);
        System.out.println(ocorrencia);
    }

    private static String lerTexto(Scanner scanner, String mensagem) {
        System.out.print(mensagem);
        String texto = scanner.nextLine().trim();

        while (texto.isEmpty()) {
            System.out.print("Campo obrigatorio. " + mensagem);
            texto = scanner.nextLine().trim();
        }

        return texto;
    }

    private static boolean lerBooleano(Scanner scanner, String mensagem) {
        System.out.print(mensagem);
        String resposta = scanner.nextLine().trim();

        while (!"s".equalsIgnoreCase(resposta) && !"n".equalsIgnoreCase(resposta)) {
            System.out.print("Digite s para sim ou n para nao. " + mensagem);
            resposta = scanner.nextLine().trim();
        }

        return "s".equalsIgnoreCase(resposta);
    }

    private static String descreverPrioridade(int prioridade) {
        if (prioridade == 1) {
            return "Critica";
        } else if (prioridade == 2) {
            return "Alta";
        } else if (prioridade == 3) {
            return "Media";
        } else {
            return "Baixa";
        }
    }

    private static String simNao(boolean valor) {
        if (valor) {
            return "sim";
        }

        return "nao";
    }
}
