package com.br.ejs.herancaProblemaCorrecao;

import com.br.ejs.herancaProblemaCorrecao.correcao.*;
import com.br.ejs.herancaProblemaCorrecao.problema.*;
import com.br.ejs.herancaProblemaCorrecao.problema.Locacao;

public class Principal {

    public static void main(String[] args) {

        /**
         * O problema de usar herança aqui para locação para cada novo tipo de locação temos
         * que criar uma nova classe, o que tira a flexibilidade do código nestes casos seria melhor
         * usar composição ao invés de herança.
         * Para cada comportamento de locação é melhor usar uma interface como comportamentos
         * a serem implementados, pois tipos de locação e seguro são comportamentos diferentes de
         * locação.
         */
        NoteBook noteBook = new NoteBook("macbook", 5, 100);

        Locacao locacao = new LocacaoPorDia(noteBook);
        System.out.println("preço por dia: " + locacao.calcularValorDevido(25));

        locacao = new LocacaoPorHora(noteBook);
        System.out.println(locacao.calcularValorDevido(15));

        locacao = new LocacaoPorHoraSeguroSantander(noteBook);
        System.out.println(locacao.calcularValorDevido(15));

        locacao = new LocacaoPorDiaSeguroSantander(noteBook);
        System.out.println(locacao.calcularValorDevido(15));

        /* Locação usando interfaces para determinar os comportamentos da mesma*/
        System.out.println("Locação usando interfaces \n");

        Precificacao precificacaoPorDia = new PrecificacaoPorDia();
        Precificacao precificacaoPorHora = new PrecificacaoPorHora();

        com.br.ejs.herancaProblemaCorrecao.correcao.Locacao locacaoCorrecao =
                new com.br.ejs.herancaProblemaCorrecao.correcao.Locacao(noteBook, precificacaoPorDia);

        System.out.println(locacaoCorrecao.calcularValorDevido(25));

        locacaoCorrecao =
                new com.br.ejs.herancaProblemaCorrecao.correcao.Locacao(noteBook, precificacaoPorHora);

        System.out.println(locacaoCorrecao.calcularValorDevido(15));

        /*preficicacao com seguro*/
        Seguro seguro = new SeguroSantander();

        locacaoCorrecao =
                new com.br.ejs.herancaProblemaCorrecao.correcao.Locacao(noteBook, precificacaoPorDia, seguro);
        System.out.println(locacaoCorrecao.calcularValorDevido(15));

        locacaoCorrecao =
                new com.br.ejs.herancaProblemaCorrecao.correcao.Locacao(noteBook, precificacaoPorHora, seguro);
        System.out.println(locacaoCorrecao.calcularValorDevido(15));

        seguro = new Seguroitau();
        locacaoCorrecao =
                new com.br.ejs.herancaProblemaCorrecao.correcao.Locacao(noteBook, precificacaoPorDia, seguro);
        System.out.println(locacaoCorrecao.calcularValorDevido(15));

        locacaoCorrecao =
                new com.br.ejs.herancaProblemaCorrecao.correcao.Locacao(noteBook, precificacaoPorHora, seguro);
        System.out.println(locacaoCorrecao.calcularValorDevido(15));


    }
}
