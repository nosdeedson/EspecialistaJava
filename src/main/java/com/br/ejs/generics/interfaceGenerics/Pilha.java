package com.br.ejs.generics.interfaceGenerics;

import com.br.ejs.generics.classGeneric.PilhaException;

import java.util.Arrays;

public class Pilha<T> implements Colecao<T> {

    private T[] items;

    public Pilha(){
        this.items = (T[]) new Object[0];
    }

    @Override
    public void colocar(T item){
        this.items = Arrays.copyOf(items, (items.length + 1));
        this.items[(items.length-1)] = item;
    }

    @Override
    public T retirar(){

        if (this.items.length == 0){
            throw  new ColecaoVaziaException("Pilha vazia.");
        }
        T item = this.items[(items.length - 1)];
        this.items = Arrays.copyOf(this.items, (this.items.length -1));
        return item;
    }
}
