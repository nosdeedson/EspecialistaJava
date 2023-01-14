package com.br.ejs.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CardapioList {

    private List<ItemCardapio> itens;

    public CardapioList(){
        this.itens = new ArrayList<>();
    }

    public void adicionar(ItemCardapio itemCardapio){
        this.itens.add(itemCardapio);
    }

    public void remover( int index){
        this.itens.remove(index);
    }

    public List<ItemCardapio> itensBaratos(double minimo, double maximo){
        List<ItemCardapio> itensBaratos = new ArrayList<>();
        for (ItemCardapio item : this.itens){
            if (item.getPreco() >= minimo && item.getPreco() <= maximo){
                itensBaratos.add(item);
            }
        }
        return itensBaratos;
    }
    public void imprimir(){
        System.out.println(Arrays.asList(this.itens).toString());
    }


}
