package com.br.ejs.generics.classGeneric;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Pilha<T> {

    private T[] items;

    public Pilha(){
        this.items = (T[]) new Object[0];
    }

    public void colocar(T item){
        this.items = Arrays.copyOf(items, (items.length + 1));
        this.items[(items.length-1)] = item;
    }

    public T retirar(){

        if (this.items.length == 0){
            throw  new PilhaException("Pilha vazia.");
        }
        T item = this.items[(items.length - 1)];
        this.items = Arrays.copyOf(this.items, (this.items.length -1));
        return item;
    }
}
