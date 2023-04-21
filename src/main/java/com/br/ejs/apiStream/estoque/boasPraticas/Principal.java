package com.br.ejs.apiStream.estoque.boasPraticas;

import com.br.ejs.apiStream.estoque.CadastroProduto;
import com.br.ejs.apiStream.estoque.Fabricante;
import com.br.ejs.apiStream.estoque.Produto;

import java.util.ArrayList;
import java.util.List;

public class Principal {
    public static void main(String[] args) {
        var cadastroProduto = new CadastroProduto();

        List<Produto> produtos = cadastroProduto.obterTodos();
        System.out.println("--------------- WRONG WAY TO USE THE STREAM API");
        wrongWayToUseStream(produtos);
        System.out.println("--------------- RIGTH WAY TO USE THE STREAM API");
        rightWayToUseStream(produtos);
    }

    private static void rightWayToUseStream(List<Produto> produtos) {
        List<Fabricante> fabricantes = produtos.stream()
                .filter(Produto::temEstoque)
                .map(Produto::getFabricante)
                .distinct()
                .toList();
        fabricantes.forEach(System.out::println);
    }

    /**
     * this method is using the Stream API in a wrong way
     * because it change the variable "fabricantes",
     * the methods of the Stream API should just use or change the results of the Stream API METHODS
     * in other words, the foreach below should change just the result of the filter method that was used first
     * it is not a goot practice when the methods change a atribute of the system.
     * this is not a rule just a convention, even though the methods above and the method below show the same result
     * when we use functional programming the correct way to proceed is when the results of the current method
     * will be the parameters of the next method
     * @param produtos
     */
    public static void wrongWayToUseStream(List<Produto> produtos){
        List<Fabricante> fabricantes = new ArrayList<>();
        produtos.stream()
                .filter(Produto::temEstoque)
                .forEach(produto -> {
                    if(!fabricantes.contains(produto)){
                        fabricantes.add(produto.getFabricante());
                    }
                });
        fabricantes.forEach(System.out::println);
    }
}
