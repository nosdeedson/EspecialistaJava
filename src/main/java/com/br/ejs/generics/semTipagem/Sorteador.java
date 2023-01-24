package com.br.ejs.generics.semTipagem;

import java.util.Random;

public class Sorteador {

    private static Random RANDOM =  new Random();

    public static <T> T sortear(T[] objetos){
        if (objetos.length == 0){
            throw  new IllegalArgumentException("Informe um array com elementos");
        }
        int posicao = RANDOM.nextInt(objetos.length);
        return objetos[posicao];
    }
}
