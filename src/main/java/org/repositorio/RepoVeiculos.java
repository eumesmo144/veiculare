package org.repositorio;

import org.model.Veiculo;

import java.util.ArrayList;
import java.util.Comparator;

public class RepositorioVeiculos {
    private ArrayList<Veiculo> veiculosArmazenados = new ArrayList<>();

    public Veiculo cadastrarVeiculo(String marca, String modelo, double autonomia, String tipoMotorizacao, double capacidade, double quantidadeCombustivel){
        Veiculo veiculoNovo = new Veiculo(marca, modelo, autonomia, tipoMotorizacao, capacidade, quantidadeCombustivel);
        veiculosArmazenados.add(veiculoNovo);
        return veiculoNovo;
    }

    public ArrayList<Veiculo> getVeiculosArmazenados(){
        return this.veiculosArmazenados;
    }

    public ArrayList<Veiculo> localizarVeiculosPorMotorizacao(String motorizacao){
        ArrayList<Veiculo> veiculosEncontrados = new ArrayList<Veiculo>();

        for(Veiculo veiculo: veiculosArmazenados){
            if(veiculo.getTipoMotorizacao().equals(motorizacao)){
                veiculosEncontrados.add(veiculo);
            }
        }

        return veiculosEncontrados;
    }

    public ArrayList<Veiculo> listarVeiculoPorMaiorAutonomia() {
        ArrayList<Veiculo> veiculosEncontrados = new ArrayList<>();

        for (Veiculo veiculo : veiculosArmazenados) {
            veiculosEncontrados.add(veiculo);
            //organiza os veiculos de maior autonomia
            veiculosEncontrados.sort(Comparator.comparing(Veiculo::getAutonomia).reversed());
        }

        while (veiculosEncontrados.size() > 10) {
            veiculosEncontrados.remove(veiculosEncontrados.size() - 1);
        }
        return veiculosEncontrados;
    }

    public ArrayList<Veiculo> listarVeiculoPorMenorAutonomia() {
        ArrayList<Veiculo> veiculosEncontrados = new ArrayList<>();

        for (Veiculo veiculo : veiculosArmazenados) {
            veiculosEncontrados.add(veiculo);
            //organiza os veiculos de menor autonomia
            veiculosEncontrados.sort(Comparator.comparing(Veiculo::getAutonomia));
        }

        while (veiculosEncontrados.size() > 10) {
            veiculosEncontrados.remove(veiculosEncontrados.size() - 1);
        }

        return veiculosEncontrados;
    }

    public ArrayList<Veiculo> listarVeiculoPorAutonomiaInferior(double perc) {
        ArrayList<Veiculo> veiculosEncontrados = new ArrayList<>();

        for (Veiculo veiculo : veiculosArmazenados) {
            if(veiculo.getAutonomia()<perc)veiculosEncontrados.add(veiculo);
        }

        return veiculosEncontrados;
    }

    public ArrayList<Veiculo> ListarVeiculoPorTipoDeCombustivel(String tipoCombus){
        ArrayList<Veiculo> veiculosEncontrados = new ArrayList<>();

        for (Veiculo veiculo : veiculosArmazenados) {
            if(veiculo.getTipoMotorizacao().equals(tipoCombus)) veiculosEncontrados.add(veiculo);
        }

        return  veiculosEncontrados;
    }

}