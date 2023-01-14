package com.br.ejs.herancaProblemaCorrecao.problema;

import com.br.ejs.herancaProblemaCorrecao.NoteBook;

public class LocacaoPorDia extends Locacao {
    public LocacaoPorDia(NoteBook noteBook) {
        super(noteBook);
    }

    @Override
    public double calcularValorDevido(int horasUtilizadas) {
        int dias = (int) Math.ceil(horasUtilizadas / 24d);
        return dias * this.getNoteBook().getPrecoPorDia();
    }
}
