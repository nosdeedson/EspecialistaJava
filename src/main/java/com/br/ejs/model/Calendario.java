package com.br.ejs.model;

public class Calendario {

    String[] meses = {
            "Janerio",
            "Fevereiro",
            "Março",
            "Abril",
            "Maio",
            "Junho",
            "Julho",
            "Agosto",
            "Setembro",
            "Outubro",
            "Novembro",
            "Dezembro"};

    public String obterMes(int index){
        return this.meses[index];
    }
}
