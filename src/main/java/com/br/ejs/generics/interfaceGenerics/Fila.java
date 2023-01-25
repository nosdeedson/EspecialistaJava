package com.br.ejs.generics.interfaceGenerics;

import java.util.Arrays;

public class Fila<T> implements Colecao<T>{

    private T[] items;

    public Fila(){
        this.items = (T[]) new Object[0];
    }
    @Override
    public void colocar(T item) {
        this.items = Arrays.copyOf(this.items, (this.items.length + 1));
        this.items[(this.items.length - 1)] = item;
    }

    @Override
    public T retirar() {
        if (this.items.length == 0){
            throw  new ColecaoVaziaException("Fila vazia.");
        }
        T item = this.items[0];
        this.items = Arrays.copyOfRange(this.items, 1, (this.items.length));
        return item;
    }
}
