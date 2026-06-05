package br.com.astropharma.model.empresa;

public class CentroDeDistribuicao extends Empresa {
    private boolean faltaIndustria;
    private int tempoEntregaFarmacia;
    private int qtdEstoque;
    //relações -----------------------------
    private Farmacia farmaciaAtendida;

    //Construtores--------------------------------------------------------------------------------------------------------------
    public CentroDeDistribuicao(String nomeFantasia, String localidade, boolean estoqueAbastecido) {
        super(nomeFantasia, localidade, estoqueAbastecido);
    }

    public CentroDeDistribuicao(int tempoEntregaFarmacia) {
        this.tempoEntregaFarmacia = tempoEntregaFarmacia;
    }
//Métodos -----------------------------------------------------------------------------------------------------------------


    public int sugerirEnvioPreditivo(int populacaoEmRisco, double porcentagemRisco) {

        // Se o estoque nao tiver abastecido por falha da industria, o envio e impossivel, por isso, retorna 0.
        if (super.getEstoqueAbastecido() == false) {
            return 0;
        }
        //Mesma coisa de cima, se esta em falta na industria, retorna 0 tambem, pois nao tem como enviar.
        if (this.faltaIndustria) {
            return 0;
        }

        // Pega a porcentagem e divide o risco por 100, pra transformar em decimal, pro calculo de multiplicar pela população ser possivel.
        double multiplicador = porcentagemRisco / 100.0;
        double calculoEnvio = populacaoEmRisco * multiplicador;

        // Só pra converter pra inteiro
        int qtdSugerida = (int) calculoEnvio;

        // validação, se nao tem no estoque, não envia.
        if (qtdSugerida > this.qtdEstoque) {
            qtdSugerida = this.qtdEstoque; // mas garanto que envie quantos tem
        }

        return qtdSugerida;
    }


// Getter e setter --------------------------------------------------------------------------------------------------------


    public boolean isFaltaIndustria() {
        return faltaIndustria;
    }

    public void setFaltaIndustria(boolean faltaIndustria) {
        this.faltaIndustria = faltaIndustria;
    }

    public int getTempoEntregaFarmacia() {
        return tempoEntregaFarmacia;
    }

    public void setTempoEntregaFarmacia(int tempoEntregaFarmacia) {
        this.tempoEntregaFarmacia = tempoEntregaFarmacia;
    }

    public int getQtdEstoque() {
        return qtdEstoque;
    }

    public void setQtdEstoque(int qtdEstoque) {
        this.qtdEstoque = qtdEstoque;
    }

    public Farmacia getFarmaciaAtendida() {
        return farmaciaAtendida;
    }

    public void setFarmaciaAtendida(Farmacia farmaciaAtendida) {
        this.farmaciaAtendida = farmaciaAtendida;
    }

    @Override
    public String toString() {
        return super.toString() + "\n   ↳ [CENTRO DISTRIB.] Estoque Global: " + qtdEstoque + " cx | Prazo p/ Farmácia: " + tempoEntregaFarmacia + " dias";
    }
}