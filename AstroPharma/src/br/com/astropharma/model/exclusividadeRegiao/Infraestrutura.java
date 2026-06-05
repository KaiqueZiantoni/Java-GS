package br.com.astropharma.model.exclusividadeRegiao;

public class Infraestrutura extends Regiao{
    private boolean saneamentoBasico;
    private boolean energiaEletrica;
    private int qtdFarmaciasRegiao;
    private boolean acessoAguaPotavel;

    public Infraestrutura(String regiao, boolean saneamentoBasico, boolean energiaEletrica, int qtdFarmaciasRegiao, boolean acessoAguaPotavel){
        super(regiao);
        this.acessoAguaPotavel = acessoAguaPotavel;
        this.energiaEletrica = energiaEletrica;
        this.qtdFarmaciasRegiao = qtdFarmaciasRegiao;
        this.saneamentoBasico = saneamentoBasico;
    }

    public boolean isSaneamentoBasico() {
        return saneamentoBasico;
    }

    public void setSaneamentoBasico(boolean saneamentoBasico) {
        this.saneamentoBasico = saneamentoBasico;
    }

    public boolean isEnergiaEletrica() {
        return energiaEletrica;
    }

    public void setEnergiaEletrica(boolean energiaEletrica) {
        this.energiaEletrica = energiaEletrica;
    }

    public int getQtdFarmaciasRegiao() {
        return qtdFarmaciasRegiao;
    }

    public void setQtdFarmaciasRegiao(int qtdFarmaciasRegiao) {
        this.qtdFarmaciasRegiao = qtdFarmaciasRegiao;
    }

    public boolean isAcessoAguaPotavel() {
        return acessoAguaPotavel;
    }

    public void setAcessoAguaPotavel(boolean acessoAguaPotavel) {
        this.acessoAguaPotavel = acessoAguaPotavel;
    }

    @Override
    public String toString() {
        String agua = this.acessoAguaPotavel ? "Sim" : "Não";
        String saneamento = this.saneamentoBasico ? "Sim" : "Não";
        return super.toString() + "\n   ↳ [INFRAESTRUTURA] Água Potável: " + agua + " | Saneamento: " + saneamento + " | Farmácias Locais: " + qtdFarmaciasRegiao;
    }
}
