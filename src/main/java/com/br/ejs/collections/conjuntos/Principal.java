package com.br.ejs.collections.conjuntos;

import java.util.*;

public class Principal{
    public static void main(String[] args) {
        // Performance é mais importante (não garante a ordem dos elementos)
//        Set<Cidade> cidades = new HashSet<>();

        // Performance é importante, mas precisa manter ordem de inserção dos elementos
//        Set<Cidade> cidades = new LinkedHashSet<>();

        // Performance é menos importante e precisa manter a ordem natural dos elementos
        /*
            bellow we add the CidadeComparator to possibility the code to compare Cidade
            if we don't pass it the TreeSet won't work, to this happen the class Cidade has to
            implement Comparable. In others words, there are two ways to compare things in Java
            the first one is when the class implements Comparable the other one is when we create a class
            that implements Comparator
         */
        Set<Cidade> cidades = new TreeSet<>(new CidadeComparator());

        cidades.add(new Cidade(3170206, "Uberlândia", 706_597));
        cidades.add(new Cidade(3170107, "Uberaba", 340_277));
        cidades.add(new Cidade(3550308, "São Paulo", 12_396_372));
        cidades.add(new Cidade(3106200, "Belo Horizonte", 2_530_701));
        cidades.add(new Cidade(2304400, "Fortaleza", 2_703_391));
        cidades.add(new Cidade(1100205, "Porto Velho", 548_952));

        Iterator<Cidade> iterator = cidades.iterator();
        while(iterator.hasNext()){
            Cidade cidade = iterator.next();
            System.out.println(cidade.toString());
        }
    }
}
