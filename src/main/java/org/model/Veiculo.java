package org.model;

public class Veiculo {
    private String marca;
    private String modelo;
    private double autonomia;
    private String tipoMotorizacao;
    private double capacidade;
    private double quantidadeCombustivel;

    public Veiculo(String marca, String modelo, double autonomia, String tipoMotorizacao, double capacidade, double quantidadeCombustivel){
        this.marca = marca;
        this.modelo = modelo;
        this.autonomia = autonomia;
        this.tipoMotorizacao = tipoMotorizacao;
        this.capacidade = capacidade;
        this.quantidadeCombustivel = quantidadeCombustivel;
    }
    public String getMarca(){
        return marca;
    }
    public String setMarca(String marca){
        return this.marca = marca;
    }
    public String getModelo(){
        return modelo;
    }
    public void setModelo(String modelo){
         this.modelo = modelo;
    }
    public double getAutonomia(){
        return autonomia;
    }
    public void setAutonomia(double autonomia){
         this.autonomia = autonomia;
    }
    public String getTipoMotorizacao(){
        return tipoMotorizacao;
    }
    public void setTipoMotorizacao(String tipoMotorizacao){
         this.tipoMotorizacao = tipoMotorizacao;
    }
    public double getCapacidade(){
        return capacidade;
    }
    public void setCapacidade(double capacidade){
         this.capacidade = capacidade;
    }
    public double getQuantidadeCombustivel(){
        return quantidadeCombustivel;
    }
    public void setQuantidadeCombustivel(double quantidadeCombustivel) {
        this.quantidadeCombustivel = quantidadeCombustivel;
    }
    public void abastecer(double quantidade){
        quantidadeCombustivel += quantidade;
        if (quantidadeCombustivel > capacidade) {
            quantidadeCombustivel = capacidade;
        }
    }
}
