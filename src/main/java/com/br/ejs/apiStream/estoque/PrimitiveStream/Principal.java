package com.br.ejs.apiStream.estoque.PrimitiveStream;

import com.br.ejs.apiStream.estoque.CadastroProduto;
import com.br.ejs.apiStream.estoque.Produto;

import java.math.BigDecimal;
import java.util.List;
import java.util.function.DoubleConsumer;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class Principal {
    public static void main(String[] args) {
        var cadastroProduto = new CadastroProduto();

        List<Produto> produtos = cadastroProduto.obterTodos();
//        imprimir(produtos);
        printingQuantities(produtos);

        System.out.println("________ Changing to Long ____________________");
        LongStream longStream = produtos.stream().mapToLong(Produto::getQuantidade);
        printingLong(longStream);

        System.out.println("________ Changing to double ____________________");
        DoubleStream doubleStream = produtos.stream().mapToDouble(produto -> produto.getQuantidade());
        printingDouble(doubleStream);

        Stream<BigDecimal> bigDecimalStream = produtos.stream()
                .filter(produto -> produto.temEstoque())
                .map(produto -> new BigDecimal(produto.getQuantidade()));

        bigDecimalStream.forEach(bigDecimal -> System.out.println(bigDecimal.getClass().getName()));

        System.out.println("________ Changing to BigDecimal ____________________");
        convertingToBigDecimal(produtos);
    }

    public static void convertingToBigDecimal(List<Produto> produtos){
        Stream<BigDecimal> bigDecimalStream = produtos.stream()
                .filter(produto -> produto.temEstoque())
                .map(produto -> new BigDecimal(produto.getQuantidade()));

        bigDecimalStream.forEach(bigDecimal ->{
            System.out.println(bigDecimal.getClass().getName() + " = " + bigDecimal);
        });

        System.out.println("--------------- best way to do the code above");
        produtos.stream()
                .filter(Produto::temEstoque)
                .map(produto -> BigDecimal.valueOf(produto.getQuantidade()))
                .forEach(System.out::println);
    }
    public static void printingFloat(Stream<BigDecimal> bigDecimalStream){

    }

    public static void printingDouble(DoubleStream doubleStream){
        doubleStream.forEach(System.out::println);
    }

    public static void printingLong(LongStream longStream){
        longStream.forEach(l -> System.out.println(l));
    }

    public static void printingQuantities(List<Produto> produtos){

//        IntStream stream = produtos.stream()
//                        .filter(produto -> produto.temEstoque())
//                                .mapToInt(Produto::getQuantidade);
//        stream.forEach(i -> System.out.println(i));
        System.out.println("---------------- BEST WAY -------------------------");
        produtos.stream()
                .filter(Produto::temEstoque)
                .mapToInt(Produto::getQuantidade)
                .forEach(System.out::println);
    }

    public static void imprimir(List<Produto> produtos){
        produtos.stream()
                .forEach(produto -> {
                    produto.inativar();
                    System.out.println(produto + "\n");
                });
    }
}
