package com.br.ejs.collections;

import java.util.*;

public class CadastroPacoreViagem {

    List<PacoteViagem> pacoteViagems = new ArrayList<>();

    public void adicionar(String descricao, double precoDiaria) {
        if(this.pacoteViagems.contains(descricao)){
            throw  new PacoteViagemException("Pacote já existe");
        }
        this.pacoteViagems.add(new PacoteViagem(descricao, precoDiaria));
    }

    public List<PacoteViagem> obterTodos() {
        return this.pacoteViagems;
    }

    public void ordenar() {
        Collections.sort(this.pacoteViagems);
//        Collections.reverse(this.pacoteViagems);
//        Collections.sort(this.pacoteViagems, Comparator.reverseOrder());
    }

    public void ordenarPorPrecoDecrescente() {
//        Collections.sort(this.pacoteViagems, new PacoteViagemComparator());
        this.pacoteViagems.sort(new PacoteViagemComparator());
//        this.pacoteViagems.sort(
//                new PacoteViagemComparator().reversed().thenComparing(Comparator.naturalOrder()));
    }


    public void removerPorDescricao(String descricao) {
        Iterator<PacoteViagem> pacoteViagemIterator = pacoteViagems.listIterator();
        while (pacoteViagemIterator.hasNext()){
            PacoteViagem p = pacoteViagemIterator.next();
            if (p.getDescricao().equals(descricao)){
                this.pacoteViagems.remove(p);
                break;
            }
            if(!pacoteViagemIterator.hasNext()){
                throw  new PacoteViagemException("não existe pacote de viagem com esta descrição");
            }
        }
    }

    public PacoteViagem buscarPorDescricao(String descricao) {
        for (PacoteViagem pacoteViagem : this.pacoteViagems) {
            if (pacoteViagem.getDescricao().equals(descricao)){
                return pacoteViagem;
            }
        }
        throw  new PacoteViagemException("Não existe pacote de viagem com esta descrição: " + descricao);
    }
}
