package br.com.astropharma.model.exclusividadeRegiao;

public class MudancaClimatica extends Regiao{
    private double temperaturaAtual;
    private double umidadeAr;


    public MudancaClimatica(String regiao, double temperaturaAtual, double umidadeAr) {
        super(regiao);
        this.temperaturaAtual = temperaturaAtual;
        this.umidadeAr = umidadeAr;
    }

    public String identificarDoencasPorClima() {
        String alerta = "Clima normal. Sem alertas de surtos.";

        // Temp. alta
        if (this.temperaturaAtual > 35.0) {
            // Se a temperatura está alta (>35) eu avalio a umidade do ar, pra identificar chance de doenças respiratorias
            if (this.umidadeAr < 30.0) {
                alerta = "Alerta: Risco de doencas respiratorias e desidratacao (Calor Seco).";
            } else {
                alerta = "Alerta: Risco de surto de Dengue/Zika Virus devido a proliferacao de mosquitos (Calor Umido).";
            }
        }
        // Temp. Baixa
        else if (this.temperaturaAtual < 15.0) {
            alerta = "Alerta: Risco de Sindromes Gripais e Pneumonia (Onda de Frio).";
        }

        return alerta;
    }












    public double getTemperaturaAtual() {
        return temperaturaAtual;
    }

    public void setTemperaturaAtual(double temperaturaAtual) {
        this.temperaturaAtual = temperaturaAtual;
    }

    public double getUmidadeAr() {
        return umidadeAr;
    }

    public void setUmidadeAr(double umidadeAr) {
        this.umidadeAr = umidadeAr;
    }


    @Override
    public String toString() {
        return super.toString() + "\n   ↳ [CLIMA ORBITAL] Temperatura: " + temperaturaAtual + "°C | Umidade: " + umidadeAr + "%";
    }}

