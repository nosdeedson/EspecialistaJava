package com.br.ejs.generics.classGeneric;

public class Principal {

    public static void main(String[] args) {
        Pilha<Produto> pilha = new Pilha<>();
        Produto p = new Produto("feijão");
        Produto p2 = new Produto("arroz");

        pilha.colocar(p);
        pilha.colocar(p2);

        try {
            Produto retirado = pilha.retirar();
            System.out.println(retirado.getDescricao());
            retirado = pilha.retirar();
            System.out.println(retirado.getDescricao());
            retirado = pilha.retirar();
            System.out.println(retirado.getDescricao());
        }catch (PilhaException e){
            System.out.println(e.getMessage());
        }

        var outraPilha = new Pilha<String>();
        outraPilha.colocar("teste 1");
        outraPilha.colocar("teste 2");

        try {
            String t = outraPilha.retirar();
            System.out.println(t);
            t = outraPilha.retirar();
            System.out.println(t);
            t = outraPilha.retirar();
            System.out.println(t);
        } catch (PilhaException e){
            System.out.println(e.getMessage());
        }
    }
}
