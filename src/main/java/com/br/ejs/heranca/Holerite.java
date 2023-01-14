package com.br.ejs.heranca;

public record Holerite(String nome, String mesAno,  double valorSalario) {

    public void  imprimir(){
        System.out.println(this);
    }

}
