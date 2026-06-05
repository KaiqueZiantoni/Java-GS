package br.com.astropharma.model.exclusividadeRegiao;

public class Regiao {
    private String regiao;


    public Regiao(String regiao){
        this.regiao = regiao;
    }



    // getter e setter -------------------------------------------------------------------------------------------------------------
    public String getRegiao() {
        return regiao;
    }

    public void setRegiao(String regiao) {
        this.regiao = regiao;
    }

    @Override
    public String toString() {
        return "📍 Região Alvo: " + regiao;
    }
}
