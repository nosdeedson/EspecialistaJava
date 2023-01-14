package com.br.ejs.herancaProblemaCorrecao.problema;

import com.br.ejs.herancaProblemaCorrecao.NoteBook;

public class LocacaoPorDiaSeguroSantander extends LocacaoPorDia{
    public LocacaoPorDiaSeguroSantander(NoteBook noteBook) {
        super(noteBook);
    }

    @Override
    public double calcularValorDevido(int horasUtilizadas) {
        double valorDevido = super.calcularValorDevido(horasUtilizadas);
        valorDevido += (valorDevido * 0.05) + (valorDevido * 0.01);
        return  valorDevido;
    }
}
