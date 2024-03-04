package org.shared;

import java.util.HashMap;

public class Marcas {
    private static HashMap<String, String> marcasModelos = new HashMap<>();
    public Marcas (){

        marcasModelos.put("BMW", "BMW Serie 3");
        marcasModelos.put("BMW", "BMW X6");
        marcasModelos.put("BMW", "BMW Z4");
        marcasModelos.put("BMW", "BMW 435i");

        marcasModelos.put("Porsche                                                                                                                                                                                                                                                                  ", "Porsche 911");
        marcasModelos.put("Porsche", "Porsche Cayenne");
        marcasModelos.put("Porsche", "Porsche Panamera");
        marcasModelos.put("Porsche", "Porsche Cayman");

        marcasModelos.put("Alpina", "Alpina B7");
        marcasModelos.put("Alpina", "Alpina D7");
        marcasModelos.put("Alpina", "Alpina D5 S");
        marcasModelos.put("Alpina", "Alpina XD4 S");

    }

    public HashMap<String,String> getMarcasModelos(){
        return this.marcasModelos;
    }

    public static Boolean verificarModelo(String modelo, String marca) {
        String modeloEncontrado = marcasModelos.getOrDefault(marca, null);
        if (modeloEncontrado != null && modeloEncontrado.equals(modelo)) {
            return true;
        }
        return false;
    }


}