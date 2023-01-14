package com.br.ejs.herancaProblemaCorrecao.problema;

import com.br.ejs.herancaProblemaCorrecao.NoteBook;

public class LocacaoPorHora extends Locacao {

    public LocacaoPorHora(NoteBook noteBook) {
        super(noteBook);
    }

    @Override
    public double calcularValorDevido(int horasUtilizadas) {
        return horasUtilizadas * this.getNoteBook().getPrecoPorHora();
    }
}
