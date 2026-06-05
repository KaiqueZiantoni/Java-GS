package br.com.astropharma.view;

import br.com.astropharma.model.empresa.CentroDeDistribuicao;
import br.com.astropharma.model.empresa.Empresa;
import br.com.astropharma.model.empresa.Farmacia;
import br.com.astropharma.model.empresa.IndustriaFarmaceutica;
import br.com.astropharma.model.exclusividadeRegiao.DensidadeRegional;
import br.com.astropharma.model.exclusividadeRegiao.Infraestrutura;
import br.com.astropharma.model.exclusividadeRegiao.MudancaClimatica;
import br.com.astropharma.model.exclusividadeRegiao.Regiao;

import javax.swing.*;

public class Terminal {
    static void main(String[] args) {
        JOptionPane.showMessageDialog(null, "Bem-vindo ao Sistema do AstroPharma");
        // IMITANDO API. já que não há conexão ainda. Esses dados seriam automatizados no sistema real, ou pelos dados de API, ou pelo banco de dados criado.
        //Define a região
        String nomeRegiao = JOptionPane.showInputDialog("Digite o nome da Microrregião monitorada pelo satélite:");
        // Entradas do Clima
        double temperatura = Double.parseDouble(JOptionPane.showInputDialog("Informe a Temperatura capturada pelo satélite (°C):"));
        double umidade = Double.parseDouble(JOptionPane.showInputDialog("Informe a Umidade do Ar capturada (%):"));
        // Entradas de População
        int populacao = Integer.parseInt(JOptionPane.showInputDialog("Qual a população total estimada para " + nomeRegiao + "?"));
        int idadeMedia = Integer.parseInt(JOptionPane.showInputDialog("Qual a idade média dessa população?"));


        //*******************************************************************************************************************
        // INSTANCIAS DE REGIÃO(todas)
        Regiao regiaoBase = new Regiao(nomeRegiao);
        MudancaClimatica climaAtual = new MudancaClimatica(nomeRegiao, temperatura, umidade);
        DensidadeRegional densidadeLocal = new DensidadeRegional(nomeRegiao, populacao, idadeMedia, 1);
        Infraestrutura infraLocal = new Infraestrutura(nomeRegiao, true, true, 5, true);

        //*******************************************************************************************************************
        //DADOS SUPLY CHAIN. Nessa parte vamos continuar imitando banco de dados de forma manual, já que não temos o banco de dados propriamente criado.
        // Entradas da Farmácia
        int estoqueFarmacia = Integer.parseInt(JOptionPane.showInputDialog("Qual o estoque atual de medicamentos da Farmácia local?"));
        int atendimentos = Integer.parseInt(JOptionPane.showInputDialog("Qual a média de atendimentos diários normais?"));

        // Para definir o Fator de Risco Climático do metodo  que usa o risco climático (CalcularRiscoFata) que tambem viria direto da API, de forma mais elaborada.
        String menuRisco = """
                O gestor define o fator de risco climático com base no satélite:
                1.0 - Estável (Sem agravamento)
                1.5 - Risco Moderado (Ondas leves)
                2.0 - Risco Severo (Extremos climáticos)""";
        double fatorRisco = Double.parseDouble(JOptionPane.showInputDialog(menuRisco));

        //*******************************************************************************************************************
        // EMPRESA. Aqui instanciamos dados da classe pai empresa.
        Empresa empresaBase = new Empresa("AstroPharma", "Global", true);
        Farmacia farmaciaLocal = new Farmacia("AstroPharma " + nomeRegiao, nomeRegiao, true, atendimentos, estoqueFarmacia, false, 5);
        CentroDeDistribuicao cdPrincipal = new CentroDeDistribuicao("CD Sudeste", "São Paulo", true);
        IndustriaFarmaceutica industriaBase = new IndustriaFarmaceutica("Indústria Astro", "Manaus", true);

        // Ajustando os estoques e relacionamentos obrigatórios
        cdPrincipal.setQtdEstoque(10000); // CD tem 10 mil caixas
        farmaciaLocal.setClimaLocal(climaAtual); // Relacionando a farmácia com o clima da região

        //*******************************************************************************************************************
        // metodos -----------------------------------------------------------------------------------------------------------

        // prever doenças
        String alertaDoencas = climaAtual.identificarDoencasPorClima();
        boolean isDoencaRespiratoria = alertaDoencas.contains("respiratorias") || alertaDoencas.contains("Gripais");

        // tempo de surto
        int diasParaSurto = densidadeLocal.preverDiasParaPicoContagio(isDoencaRespiratoria);

        // Quebra de estoque
        double porcentagemFalta = farmaciaLocal.calcularRiscoFalta(fatorRisco);

        // Decisao do envio.
        // Usa a população, o risco da farmácia e o alerta para enviar caixas
        int caixasParaEnvio = cdPrincipal.sugerirEnvioPreditivo(populacao, porcentagemFalta);


        // Saída *********************************************************************************************

        String relatorioFinal = "***SISTEMA ASTROPHARMA: LOG DE OBJETOS***\n\n" +
                "--- OBJETOS DA CADEIA LOGÍSTICA ---\n" +
                "1. " + empresaBase.toString() + "\n" +
                "2. " + industriaBase.toString() + "\n" +
                "3. " + cdPrincipal.toString() + "\n" +
                "4. " + farmaciaLocal.toString() + "\n\n" +
                "--- OBJETOS DE MONITORAMENTO ESPACIAL ---\n" +
                "5. " + regiaoBase.toString() + "\n" +
                "6. " + climaAtual.toString() + "\n" +
                "7. " + densidadeLocal.toString() + "\n" +
                "8. " + infraLocal.toString() + "\n\n" +
                "====== RESULTADOS DA INTELIGÊNCIA PREDITIVA ======\n" +
                "-> DIAGNÓSTICO SATÉLITE: " + alertaDoencas + "\n" +
                "-> PICO DO SURTO ESTIMADO EM: " + diasParaSurto + " dias.\n" +
                "-> CHANCE DE DESABASTECIMENTO: " + porcentagemFalta + "%\n" +
                "-> AÇÃO: O CD enviará " + caixasParaEnvio + " caixas para a região.";

        // Exibe tudo de uma vez para o professor avaliar
        JOptionPane.showMessageDialog(null, relatorioFinal);
    }
}
