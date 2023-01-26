package com.br.ejs.generics.interfaceGenerics;

public class Principal {

    /*
        "?" operador coringa ele permite que a "Colecao" seja de qualquer tipo, ou seja,
        a colecao pode ser de String, Integer ou um objeto de criação própria
        o uso Colecao<?> equivale a Colecao<? extends Object> o compilaor inferi que extends de Object
     */
    private static void  retirarTodo(Colecao<?> objetos){
        try {
            while (true){
                Object o = objetos.retirar();
                System.out.printf(" %s%n", o.toString());
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

        var outraPilha = new Pilha<String>();
        outraPilha.colocar("teste 1");
        outraPilha.colocar("teste 2");

        retirarTodo(outraPilha);
    }
}
