package com.br.ejs.model;

import java.util.Arrays;

public class Cardapio {

    private ItemCardapio[] itens;

    public Cardapio() {
        this.itens = new ItemCardapio[0];
    }

    public void adicionarItem(ItemCardapio item){
       this.itens = Arrays.copyOf(itens, itens.length + 1 );
       this.itens[itens.length - 1] = item;
    }

    public void removerItem(int indice){
        ItemCardapio[] comeco = Arrays.copyOfRange(this.itens, 0, (indice));
        ItemCardapio[] fim = Arrays.copyOfRange(this.itens, (indice +1), this.itens.length);
        this.itens = new ItemCardapio[comeco.length +  fim.length ];
        this.itens = Arrays.copyOfRange(comeco, 0, comeco.length + 1);
        System.arraycopy(fim, 0, this.itens, comeco.length, fim.length);
    }

    public void imprimir(double precoMinimo, double precoMaximo){
        for ( ItemCardapio item : this.itens ) {
            System.out.println(item.toString());
        }
    }

    @Override
    public String toString() {
        return "Cardapio{" +
                "itens=" + Arrays.toString(itens) +
                '}';
    }
}
