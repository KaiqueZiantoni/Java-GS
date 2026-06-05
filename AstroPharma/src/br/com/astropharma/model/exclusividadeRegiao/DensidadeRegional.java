package br.com.astropharma.model.exclusividadeRegiao;

public class DensidadeRegional extends Regiao {
    private int qtdPopulacional;
    private int mediaIdadePopulacional;
    private int zonaRegional;

    public DensidadeRegional(String regiao, int qtdPopulacional, int mediaIdadePopulacional, int zonaRegional){
        super(regiao);
        this.mediaIdadePopulacional = mediaIdadePopulacional;
        this.zonaRegional = zonaRegional;
        this.qtdPopulacional = qtdPopulacional;
    }


    public int preverDiasParaPicoContagio(boolean doencaRespiratoria) {
        int diasPrevisao = 30; // Numero padrão pra basear o tempo antes do surto acontecer (Pensando em quantidade de pessoas)

        // Regra 1: Se for uma área muito populosa, o contágio é mais rápido (cai 10 dias)
        if (this.qtdPopulacional > 50000) {
            diasPrevisao = diasPrevisao - 10;
        }

        // Regra 2: Se for doença respiratória E a média de idade for idosa, agrava mais rápido
        if (doencaRespiratoria) {
            if (this.mediaIdadePopulacional > 60) {
                diasPrevisao = diasPrevisao - 5;
            }
        }
        return diasPrevisao;
    }


    //getter setter -------------------------------------------------------------------------------------------------------------
    public int getQtdPopulacional() {
        return qtdPopulacional;
    }

    public void setQtdPopulacional(int qtdPopulacional) {
        this.qtdPopulacional = qtdPopulacional;
    }

    public int getMediaIdadePopulacional() {
        return mediaIdadePopulacional;
    }

    public void setMediaIdadePopulacional(int mediaIdadePopulacional) {
        this.mediaIdadePopulacional = mediaIdadePopulacional;
    }

    public int getZonaRegional() {
        return zonaRegional;
    }

    public void setZonaRegional(int zonaRegional) {
        this.zonaRegional = zonaRegional;
    }


    @Override
    public String toString() {
        return super.toString() + "\n   ↳ [DEMOGRAFIA] População: " + qtdPopulacional + " habitantes | Idade Média: " + mediaIdadePopulacional + " anos";
    }}
