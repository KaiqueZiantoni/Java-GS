package br.com.astropharma.model.empresa;

import br.com.astropharma.model.exclusividadeRegiao.DensidadeRegional;
import br.com.astropharma.model.exclusividadeRegiao.Infraestrutura;
import br.com.astropharma.model.exclusividadeRegiao.MudancaClimatica;

public class Farmacia extends Empresa{
    private int atendimentosDiarios;
    private int qtdEstoque;
    //Tempo Reposição se refere a DATA em que o medicamento foi soliciado ao centro de distribuição
    private int tempoReposicao;
    //Analisar se a falta é no centro de distribuição;
    private boolean faltaCd;
    //Relações -----------------------------------------
    private MudancaClimatica indiceClimaLocal;
    private DensidadeRegional populacaoLocal;
    private Infraestrutura infraestruturaLocal;

//Construtores--------------------------------------------------------------------------------------------------------------

    public Farmacia(String nomeFantasia, String localidade, boolean estoqueAbastecido, int atendimentosDiarios, int qtdEstoque, boolean faltaCd, int tempoReposicao) {
        super(nomeFantasia, localidade, estoqueAbastecido);
        this.atendimentosDiarios = atendimentosDiarios;
        this.qtdEstoque = qtdEstoque;
        this.tempoReposicao = tempoReposicao;
        this.faltaCd = faltaCd;

    }
    public Farmacia(int tempoReposicao){
        this.tempoReposicao = tempoReposicao;
    }



//Métodos -----------------------------------------------------------------------------------------------------------------
    public double calcularRiscoFalta(double riscoClimatico){
        if(atendimentosDiarios ==0){
            atendimentosDiarios =1; // Evitar divisão por 0 pra não dar erro e evitar do sistema quebrar
        }
        double diasAntesFalta = 0;
        if(super.getEstoqueAbastecido() == true){
            diasAntesFalta = (double) qtdEstoque / atendimentosDiarios;
        }else {
            diasAntesFalta =0;
        }

        double chanceFalta = 0;
        if(diasAntesFalta < tempoReposicao){
            chanceFalta = 50.0; //Chance base de uso para verificar falta de medicamentos, ira variar de acordo com a mudança temperatura inserido
        }else {
            chanceFalta = 10;//Chance base baixa, pra na multiplicação pelo fator temperatura inserido
        }

        chanceFalta = riscoClimatico * chanceFalta;

        if (chanceFalta > 100){
            chanceFalta = 100; // Por ser porcentagem, evitarei que passe de 100%, portanto, se der maior que 100 no numero, transformo em 100., que é o maximo
        }

        return chanceFalta;
    }






// Getter e setter --------------------------------------------------------------------------------------------------------

    public int getAtendimentosDiarios() {
        return atendimentosDiarios;
    }

    public void setAtendimentosDiarios(int atendimentosDiarios) {
        this.atendimentosDiarios = atendimentosDiarios;
    }

    public int getQtdEstoque() {
        return qtdEstoque;
    }

    public void setQtdEstoque(int qtdEstoque) {
        this.qtdEstoque = qtdEstoque;
    }

    public boolean isFaltaCd() {
        return faltaCd;
    }

    public void setFaltaCd(boolean faltaCd) {
        this.faltaCd = faltaCd;
    }

    public int getTempoReposicao() {
        return tempoReposicao;
    }

    public void setTempoReposicao(int tempoReposicao) {
        this.tempoReposicao = tempoReposicao;
    }

    public MudancaClimatica getClimaLocal() {
        return indiceClimaLocal;
    }

    public void setClimaLocal(MudancaClimatica climaLocal) {
        this.indiceClimaLocal = climaLocal;
    }

    public DensidadeRegional getPopulacaoLocal() {
        return populacaoLocal;
    }

    public void setPopulacaoLocal(DensidadeRegional populacaoLocal) {
        this.populacaoLocal = populacaoLocal;
    }

    public Infraestrutura getInfraestruturaLocal() {
        return infraestruturaLocal;
    }

    public void setInfraestruturaLocal(Infraestrutura infraestruturaLocal) {
        this.infraestruturaLocal = infraestruturaLocal;
    }

    @Override
    public String toString() {
        return super.toString() + "\n   ↳ [FARMÁCIA] Demanda: " + atendimentosDiarios + " atend/dia | Estoque Local: " + qtdEstoque + " cx | Reposição: " + tempoReposicao + " dias";
    }}
