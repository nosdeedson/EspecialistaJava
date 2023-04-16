package com.br.ejs.apiStream.estoque.especialStreamReduce;

import com.br.ejs.apiStream.estoque.CadastroProduto;
import com.br.ejs.apiStream.estoque.Produto;

import java.util.List;

public class Principal {

    public static void main(String[] args) {
        var cadastroProduto = new CadastroProduto();
        List<Produto> produtos = cadastroProduto.obterTodos();
        System.out.println("---------- adding ---------------------");
        usingSum(produtos);
        System.out.println("---------- average ---------------------");
        usingAverage(produtos);
        System.out.println("---------- counting ---------------------");
        usingCount(produtos);
    }

    private static void usingCount(List<Produto> produtos) {
        long count = produtos.stream()
                .filter(Produto::temEstoque)
                // count came from IntStream
                .count();
        System.out.println("quantities of product with stock: " + count);
    }

    public static void usingAverage(List<Produto> produtos){
        double average = produtos.stream()
                .mapToInt(Produto::getQuantidade)
                // average came from IntStream
                .average()
                .orElse(0.0);
        System.out.println("average of products quantities:" + average);
    }

    public static void usingSum(List<Produto> produtos){
        int sum = produtos.stream()
                .mapToInt(Produto::getQuantidade)
                // sum came from IntStream
                .sum();
        System.out.println("sum of products quantities: " + sum);
    }
}
