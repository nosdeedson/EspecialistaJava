package com.br.ejs.herancaProblemaCorrecao.correcao;

import com.br.ejs.herancaProblemaCorrecao.NoteBook;

public class PrecificacaoPorHora implements Precificacao{

    @Override
    public double calcularValorTotal(NoteBook noteBook, int horasUtilizadas) {
        double valor = horasUtilizadas * noteBook.getPrecoPorHora();
        return valor;
    }
}
