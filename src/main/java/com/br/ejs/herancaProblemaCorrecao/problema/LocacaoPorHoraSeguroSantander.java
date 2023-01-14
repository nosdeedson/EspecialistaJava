package com.br.ejs.herancaProblemaCorrecao.problema;

import com.br.ejs.herancaProblemaCorrecao.NoteBook;

public class LocacaoPorHoraSeguroSantander extends LocacaoPorHora{
    public LocacaoPorHoraSeguroSantander(NoteBook noteBook) {
        super(noteBook);
    }

    @Override
    public double calcularValorDevido(int horasUtilizadas) {
        double valorDevido = super.calcularValorDevido(horasUtilizadas);
        valorDevido += (valorDevido * 0.05);
        return  valorDevido;
    }
}
