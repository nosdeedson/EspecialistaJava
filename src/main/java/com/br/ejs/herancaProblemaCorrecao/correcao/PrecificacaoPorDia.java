package com.br.ejs.herancaProblemaCorrecao.correcao;

import com.br.ejs.herancaProblemaCorrecao.NoteBook;

public class PrecificacaoPorDia implements Precificacao{
    @Override
    public double calcularValorTotal(NoteBook noteBook, int horasUtilizadas) {
        int dias = (int) Math.ceil(horasUtilizadas /24d);
        return dias * noteBook.getPrecoPorDia();
    }
}
