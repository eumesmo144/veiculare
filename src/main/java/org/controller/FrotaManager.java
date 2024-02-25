package org.controller;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import org.model.Veiculo;
public class FrotaManager {
    private List<Veiculo> frota;
    public FrotaManager(){
        frota = new ArrayList<>();
    }
    public void cadastrarVeiculo(Veiculo veiculo){
        frota.add(veiculo);
    }
    public List<Veiculo> listarVeiculoMaiorAutonomia(){
        List<Veiculo> veiculos = new ArrayList<>(frota);
        veiculos.sort(Comparator.comparing(Veiculo::getAutonomia).reversed());
        return veiculos.subList(0, Math.min(10, veiculos.size()));
    }
    public List<Veiculo> listarVeiculosMenorAutonomia(){
        List<Veiculo> veiculos = new ArrayList<>(frota);
        veiculos.sort(Comparator.comparing(Veiculo::getAutonomia));
        return veiculos.subList(0, Math.min(10, veiculos.size()));
    }
    public List<Veiculo> listarVeiculosTipoMotorizacao(String tipoMotorizacao){
        List<Veiculo> TiposVeiculos = new ArrayList<>();
        for (Veiculo veiculo: frota) {
            if (veiculo.getTipoMotorizacao().equalsIgnoreCase(tipoMotorizacao)){
                TiposVeiculos.add(veiculo);
            }
        }
        return TiposVeiculos;
    }

    public void abastecerFrota(String tipoCombustivel, double quantidade){
        for (Veiculo veiculo: frota){
            if (veiculo.getTipoMotorizacao().equalsIgnoreCase(tipoCombustivel)) {
                veiculo.abastecer(quantidade);

            }
        }
    }
    public List<Veiculo> listarVeiculosAutonomiaInferior(double porcentagem) {
        List<Veiculo> veiculosAutonomiaInferior = new ArrayList<>();
        for (Veiculo veiculo : frota) {
            double autonomiaAtual = (veiculo.getQuantidadeCombustivel() / veiculo.getCapacidade()) * veiculo.getAutonomia();
            if (autonomiaAtual < porcentagem){
                veiculosAutonomiaInferior.add(veiculo);
            }
        }
        return veiculosAutonomiaInferior;
    }
    public static void main(String[] args){
        FrotaManager managenment = new FrotaManager();
        managenment.cadastrarVeiculo(new Veiculo("Volkswagen", "Golf", 110, "Gasolina", 40, 22));
        managenment.cadastrarVeiculo(new Veiculo("Ford", "Fiesta", 95, "Gasolina", 35, 20));
        managenment.cadastrarVeiculo(new Veiculo("Toyota", "Yaris", 100, "Gasolina", 38, 21));
        managenment.cadastrarVeiculo(new Veiculo("Honda", "Fit", 105, "Gasolina", 37, 22));
        managenment.cadastrarVeiculo(new Veiculo("Chevrolet", "Onix", 98, "Flex", 40, 23));
        managenment.cadastrarVeiculo(new Veiculo("Hyundai", "HB20", 97, "Flex", 39, 22));
        managenment.cadastrarVeiculo(new Veiculo("Kia", "Rio", 95, "Gasolina", 36, 20));
        managenment.cadastrarVeiculo(new Veiculo("Nissan", "Versa", 102, "Flex", 38, 21));
        managenment.cadastrarVeiculo(new Veiculo("Subaru", "Outback", 115, "Gasolina", 42, 24));
        managenment.cadastrarVeiculo(new Veiculo("Mazda", "CX-5", 110, "Gasolina", 41, 23));
        managenment.cadastrarVeiculo(new Veiculo("Audi", "A3", 120, "Diesel", 44, 25));
        managenment.cadastrarVeiculo(new Veiculo("BMW", "X3", 125, "Gasolina", 45, 26));
        managenment.cadastrarVeiculo(new Veiculo("Mercedes-Benz", "GLA", 118, "Gasolina", 43, 24));
        managenment.cadastrarVeiculo(new Veiculo("Tesla", "Model S", 250, "Elétrico", 350, 0));
        managenment.cadastrarVeiculo(new Veiculo("Renault", "Captur", 105, "Flex", 37, 20));
        managenment.cadastrarVeiculo(new Veiculo("Peugeot", "208", 98, "Flex", 39, 21));
        managenment.cadastrarVeiculo(new Veiculo("Fiat", "Argo", 100, "Diesel", 38, 22));
        managenment.cadastrarVeiculo(new Veiculo("Citroen", "C3", 97, "Flex", 36, 20));
        managenment.cadastrarVeiculo(new Veiculo("SEAT", "Ibiza", 95, "Gasolina", 35, 19));


        List<Veiculo> maioresAutonomias = managenment.listarVeiculoMaiorAutonomia();
        System.out.println("-----------TOP-10-MAIORES-AUTONOMIAS-----------------------");
        for (Veiculo veiculo : maioresAutonomias) {
            System.out.println("Marca: " + veiculo.getMarca() + ", Modelo: " + veiculo.getModelo() + ", Autonomia: " + veiculo.getAutonomia());
        }

        List<Veiculo> menoresAutonomias = managenment.listarVeiculosMenorAutonomia();
        System.out.println("-----------TOP-10-AUTONOMIAS-MAIS-BUCHAS------------------");
        for (Veiculo veiculo : menoresAutonomias) {
            System.out.println("Marca: " + veiculo.getMarca() + ", Modelo: " + veiculo.getModelo() + ", Autonomia: " + veiculo.getAutonomia());
        }
        List<Veiculo> carrosGas = managenment.listarVeiculosTipoMotorizacao("Gasolina");
        System.out.println("-----------------GASOLINA---------------------");
        for (Veiculo veiculo : carrosGas) {
            System.out.println("Marca: " + veiculo.getMarca() + ", Modelo: " + veiculo.getModelo() + ", Motorização: " + veiculo.getTipoMotorizacao());

        }
        List<Veiculo> carrosDiesel = managenment.listarVeiculosTipoMotorizacao("Diesel");
        System.out.println("------------------DIESEL----------------------");
        for (Veiculo veiculo : carrosDiesel) {
            System.out.println("Marca: " + veiculo.getMarca() + ", Modelo: " + veiculo.getModelo() + ", Motorização: " + veiculo.getTipoMotorizacao());

        }
        List<Veiculo> carrosFlex = managenment.listarVeiculosTipoMotorizacao("Flex");
        System.out.println("-----------------FLEX------------------------");
        for (Veiculo veiculo : carrosFlex) {
            System.out.println("Marca: " + veiculo.getMarca() + ", Modelo: " + veiculo.getModelo() + ", Motorização: " + veiculo.getTipoMotorizacao());

        }
        List<Veiculo> carrosEletrico = managenment.listarVeiculosTipoMotorizacao("Elétrico");
        System.out.println("---------------ELÉTRICOS---------------------");
        for (Veiculo veiculo : carrosEletrico) {
            System.out.println("Marca: " + veiculo.getMarca() + ", Modelo: " + veiculo.getModelo() + ", Motorização: " + veiculo.getTipoMotorizacao());

        }
        managenment.abastecerFrota("Flex", 20);
        List<Veiculo> carrosLower70 = managenment.listarVeiculosAutonomiaInferior(70);
        System.out.println("-----------Carros-com-menos-70%-no-tanque----------------");
        for (Veiculo veiculo : carrosLower70){
            System.out.println("Marca: " + veiculo.getMarca() + ", Modelo: " + veiculo.getModelo() + ", Capacidade: " + veiculo.getCapacidade() + ", Tanque" + veiculo.getQuantidadeCombustivel());

        }



    }
}
