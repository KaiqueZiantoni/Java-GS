package br.com.astropharma.model.empresa;

public class Empresa {
    private String nomeFantasia;
    private String localidade;
    //Estoque abastecido se refere a ter ou não o medicamento que será escolhido pelo usuário de acordo com sua demanda
    private Boolean estoqueAbastecido;


//Construtores--------------------------------------------------------------------------------------------------------------
    public Empresa(String nomeFantasia, String localidade, boolean estoqueAbastecido){
        this.estoqueAbastecido = estoqueAbastecido;
        this.localidade = localidade;
        this.nomeFantasia = nomeFantasia;
    }
    public Empresa(){
    }
//Métodos -----------------------------------------------------------------------------------------------------------------



// --------





// Getter e setter --------------------------------------------------------------------------------------------------------
    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }

    public String getLocalidade() {
        return localidade;
    }

    public void setLocalidade(String localidade) {
        this.localidade = localidade;
    }



    public Boolean getEstoqueAbastecido() {
        return estoqueAbastecido;
    }

    public void setEstoqueAbastecido(Boolean estoqueAbastecido) {
        this.estoqueAbastecido = estoqueAbastecido;
    }

    @Override
    public String toString() {
        String status = this.estoqueAbastecido ? "Abastecido" : "Em Falta";
        return "Empresa: " + nomeFantasia + " | Local: " + localidade + " | Status Base: " + status;
    }
}
