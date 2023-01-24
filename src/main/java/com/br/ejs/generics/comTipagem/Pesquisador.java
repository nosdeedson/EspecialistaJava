package com.br.ejs.generics.comTipagem;

public class Pesquisador {

    public  static <T extends Nomeavel> T pesquisar(T[] objetos, String nome){
        for (T obj: objetos){
            if (obj.getNome().equals(nome)){
                return obj;
            }
        }
        throw new RuntimeException("Nenhum nome igual");
    }
}
