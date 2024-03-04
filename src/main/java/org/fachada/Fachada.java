package org.fachada;

import org.model.Veiculo;
import org.repositorio.RepositorioVeiculos;
import org.shared.Marcas;

import java.util.ArrayList;

public class Fachada {

    private RepositorioVeiculos veiculosAtuais = new RepositorioVeiculos();
    private Marcas marcas = new Marcas();

    public void CadastrarVeiculo(String marca, String modelo, double autonomia, String tipoMotorizacao, double capacidade, double quantidadeCombustivel){
        Boolean validarMarcaEModelo = marcas.verificarModelo(modelo, marca);
        if(validarMarcaEModelo){
            veiculosAtuais.cadastrarVeiculo(modelo, marca, autonomia, tipoMotorizacao, capacidade, quantidadeCombustivel);
        }

        throw new IllegalArgumentException("Marca não condiz com o modelo enviado");
    }

    public void ReabastecerFrotaPorTipoCombustivel(String tipoComb, double quantLitros){
        ArrayList<Veiculo> veiculosPorTipoComb = veiculosAtuais.ListarVeiculoPorTipoDeCombustivel(tipoComb);
        for(Veiculo veiculos: veiculosPorTipoComb){
            veiculos.setQuantidadeCombustivel(quantLitros);
        }
    }

    public ArrayList<Veiculo> ListarTodosOsVeiculos(){
        return this.veiculosAtuais.getVeiculosArmazenados();
    }

    public ArrayList<Veiculo> ListarVeiculosComMaiorAutonomia(){
        return this.veiculosAtuais.listarVeiculoPorMaiorAutonomia();
    }

    public ArrayList<Veiculo> ListarVeiculosComMenorAutonomia(){
        return this.veiculosAtuais.listarVeiculoPorMenorAutonomia();
    }

    public ArrayList<Veiculo>ListarVeiculosComAutonomiaMenorQuePerc(double perc){
        return this.veiculosAtuais.listarVeiculoPorAutonomiaInferior(perc);
    }



}