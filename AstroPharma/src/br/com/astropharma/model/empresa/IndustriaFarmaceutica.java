package br.com.astropharma.model.empresa;

public class IndustriaFarmaceutica extends Empresa{
    //OTC se refere a materia prima pra fabricação do medicamento;
    private boolean otcEmFalta;
    private int tempoEntregaCD;
    //Relações ----------------
    private CentroDeDistribuicao centroAtendido; //Qual centro de distribuição atende

//Construtores--------------------------------------------------------------------------------------------------------------

    public IndustriaFarmaceutica(String nomeFantasia, String localidade, boolean estoqueAbastecido) {
        super(nomeFantasia, localidade, estoqueAbastecido);
    }
    public IndustriaFarmaceutica(int tempoEntregaCD){
        this.tempoEntregaCD = tempoEntregaCD;
    }
//Métodos -----------------------------------------------------------------------------------------------------------------


















// Getter e setter --------------------------------------------------------------------------------------------------------

    public boolean isOtcEmFalta() {
        return otcEmFalta;
    }

    public void setOtcEmFalta(boolean otcEmFalta) {
        this.otcEmFalta = otcEmFalta;
    }

    public int getTempoEntregaCD() {
        return tempoEntregaCD;
    }

    public void setTempoEntregaCD(int tempoEntregaCD) {
        this.tempoEntregaCD = tempoEntregaCD;
    }

    public CentroDeDistribuicao getCentroAtendido() {
        return centroAtendido;
    }

    public void setCentroAtendido(CentroDeDistribuicao centroAtendido) {
        this.centroAtendido = centroAtendido;
    }

    @Override
    public String toString() {
        String materiaPrima = this.otcEmFalta ? "Faltando (Risco na Cadeia)" : "Estoque OK";
        return super.toString() + "\n   ↳ [INDÚSTRIA] Matéria-prima: " + materiaPrima + " | Prazo p/ o CD: " + tempoEntregaCD + " dias";
    }
}
