package com.br.ejs.herancaProblemaCorrecao.correcao;

import com.br.ejs.herancaProblemaCorrecao.NoteBook;

public interface Precificacao {

    /**
     * Esta interface faz o papel de calcular o valor devido
     * somando, quando for o caso o valor do seguro, mais o aluguel
     *
     */

    double calcularValorTotal(NoteBook noteBook, int horasUtilizadas);
}
