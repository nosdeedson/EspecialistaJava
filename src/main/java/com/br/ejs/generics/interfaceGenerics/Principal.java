package com.br.ejs.generics.interfaceGenerics;

public class Principal {

    private static void  retirarTodo(Colecao<Produto> produtos){
        try {
            while (true){
                Produto p = produtos.retirar();
                System.out.println(p.getDescricao());
            }
        }catch (ColecaoVaziaException e){
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        System.out.println("fila");
        Colecao<Produto> produtos = new Fila<Produto>();
        Produto p = new Produto("feijão");
        Produto p2 = new Produto("arroz");

        produtos.colocar(p);
        produtos.colocar(p2);

        retirarTodo(produtos);
        System.out.println("pilha");

        var outraPilha = new Pilha<Produto>();
        outraPilha.colocar(p);
        outraPilha.colocar(p2);

        retirarTodo(outraPilha);
    }
}
