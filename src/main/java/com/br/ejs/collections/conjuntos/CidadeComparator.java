package com.br.ejs.collections.conjuntos;

import java.util.Comparator;

public class CidadeComparator implements Comparator<Cidade> {

    @Override
    public int compare(Cidade o1, Cidade o2) {
        return Integer.compare(o1.getCodigoIbge(), o2.getCodigoIbge());
    }
}
