package com.br.ejs.apiStream.estoque;

import java.math.BigDecimal;
import java.util.*;

import static java.util.stream.Collectors.*;


public class Principal2 {

    public static void main(String[] args) {
        var cadastroProduto = new CadastroProduto();

        List<Produto> produtos = cadastroProduto.obterTodos();
//        imprimir(produtos);
        totalAmountInStock(produtos);
        System.out.println("---------------- PRODUCT MAX STOCK -----------------------");
        productWithMaxStock(new ArrayList<Produto>());

        productWithMaxStock(produtos);
        System.out.println("--------------- CHEAPEST PRODUCT ---------------------");
        cheapestProduct(produtos);
        System.out.println("--------------- THE EXPENSIVE PRODUCT ---------------------");
        expensiveProduct(produtos);
        System.out.println("--------------- PRODUCTS IN STOCK ---------------------");
        productInStock(produtos);
        System.out.println("--------------- MAP OF PRODUCTS IN STOCK ---------------------");
        productsWithStock(produtos);
        System.out.println("--------------- LISTING MANUFACTURERS ---------------------");
        listingManufacturersOfProducts(produtos);

    }

    private static void listingManufacturersOfProducts(List<Produto> produtos) {
        Map<Fabricante, List<Produto>> manufacturers = produtos.stream()
                .filter(Produto::temEstoque)
                .collect(groupingBy(Produto::getFabricante)); // import static

        manufacturers.forEach((fabricante, produtos1) -> {
            System.out.println("############### Manufacturers ####################");
            System.out.println(fabricante.nome());
            System.out.println("------------- produtos ---------------");
            produtos1.forEach(produto -> {
                System.out.println(produto.getNome());
            });
            System.out.println("############### end products ####################");
        });
    }

    public static void productsWithStock(List<Produto> produtos){
        Map<String, Integer> estoque = produtos.stream()
                        .filter(Produto::temEstoque)
                                .collect(toMap(produto -> produto.getNome(), produto -> produto.getQuantidade()));
        System.out.println(estoque);

        System.out.println("--------------- simplifying ---------------------");

        estoque = produtos.stream()
                .filter(Produto::temEstoque)
                .collect(toMap(Produto::getNome, Produto::getQuantidade));

        System.out.println(estoque);
    }

    private static void productInStock(List<Produto> produtos) {

        System.out.println("--------------- first way ---------------------");
        List<Produto> productsInStock = produtos.stream()
                .filter(Produto::temEstoque)
                // here the new Arraylist is the container to receive the result of collect
                // the second lambida the list parameter is the new ArrayList which will receives products
                // the third lambida is necessary because the processing could reslt in two list and they must be combined
                .collect(
                        () -> new ArrayList<Produto>(),
                        (list, product) -> list.add(product),
                        (list1, list2) -> list1.addAll(list2)
                );
        productsInStock.forEach(System.out::println);

        System.out.println("--------------- simplifying ---------------------");

        productsInStock = produtos.stream()
                .filter(Produto::temEstoque)
                // here we have the same concept of the code above, but was used the method referece to do the actions
                .collect(ArrayList::new, List::add, List::addAll);

        productsInStock.forEach(System.out::println);

        System.out.println("--------------- the easy way---------------------");
        productsInStock = produtos.stream()
                .filter(Produto::temEstoque)
                .collect(toList());
                // to get an unmodifiable list
                // .collect(Collectors.toUnmodifiableList());
                // or this call   .toList();
                // bellow was used the static import line 6,
                // so the .collect(Collectors.toList()); changed to .collect(toList());
                // to guarantee the result to be an ArrayList use .collect(toCollection(ArrayList::new));
                //        .collect(Collectors.toCollection(ArrayList::new));
                // or the static import
                //        .collect(toCollection(ArrayList::new));
        productsInStock.forEach(System.out::println);
    }

    private static void expensiveProduct(List<Produto> produtos) {
        produtos.stream()
                .filter(Produto::temEstoque)
                .max(Comparator.comparing(Produto::getPreco))
                .ifPresent(System.out::println);
    }

    public static void cheapestProduct(List<Produto> produtos){
        produtos.stream()
                .filter(Produto::temEstoque)
                .min(Comparator.comparing(Produto::getPreco))
                .ifPresent(System.out::println);
    }

    public static void productWithMaxStock(List<Produto> produtos){

        Optional<Integer> optionalInteger = produtos.stream()
                .map(Produto::getQuantidade)
                .reduce(Integer::max);
        if (optionalInteger.isPresent()) {
            Integer value = optionalInteger.get();
        } else {
            System.out.println("none value");
        }
        System.out.println("---------------- simplifying -----------------------");
        Integer maxStockProduct = produtos.stream()
                .map(Produto::getQuantidade)
                .reduce(Integer::max)
                .orElse(null);
        if (maxStockProduct == null){
            System.out.println("product with bigger stock: none " );
        }else {
            System.out.println("product with bigger stock: " + maxStockProduct);
        }
        System.out.println("---------------- simplifying even more -----------------------");

        OptionalInt optionalInt = produtos.stream()
                .mapToInt(Produto::getQuantidade)
                .reduce(Integer::max);

        if (optionalInt.isEmpty()){
            System.out.println("none of the product has stock");
        } else {
            System.out.println("product with bigger stock: " + maxStockProduct);
        }
        System.out.println("---------------- simplest way -----------------------");
        int maxStockProductInt = produtos.stream()
                .mapToInt(Produto::getQuantidade)
                .reduce(Integer::max)
                .orElse(0);

        System.out.println("product with the greater stock has: " + maxStockProductInt);

    }

    public static void totalAmountInStock(List<Produto> produtos){
        BigDecimal totalAmount = produtos.stream()
                //.map(produto -> produto.getPreco().multiply(new BigDecimal(produto.getQuantidade())))
                // the operation map above by default doesn't need the return key word because there are no curly brackets
                .map(produto -> {
                    // here is necessary the return key word because was opened the code block with curly brackets
                    return produto.getPreco().multiply(new BigDecimal(produto.getQuantidade()));
                })
                .reduce(BigDecimal.ZERO, (x, y) -> x.add(y));
        System.out.println("---------------------- frist way -------------------------");
        System.out.println("Total amount in stock: " + totalAmount);

        System.out.println("------------------ second way (THE BEST WAY) -----------------------------");
        totalAmount = produtos.stream()
                .map(produto -> produto.getPreco().multiply(new BigDecimal(produto.getQuantidade())))
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        System.out.println("Total amount in stock: " + totalAmount);

        System.out.println("------------------- third way --------------------------");
        totalAmount = produtos.stream()
                .reduce(BigDecimal.ZERO,
                        (subTotal, produto) -> {
                            // here is done the multiplication because it was not done a map operation of the products
                            // therefore we have a list of products not a list of BigDecimal,
                            // and it was used an overload of reduce that receives a parameter as identity, which is the accumulator
                            // the second parameter is a BiFunction, and the third one is a BinaryOperator
                            BigDecimal totalProduto = produto.getPreco().multiply(new BigDecimal(produto.getQuantidade()));
                            return subTotal.add(totalProduto);
                        },
                        BigDecimal::add);
        System.out.println("Total amount in stock: " + totalAmount);

    }

    public static void imprimir(List<Produto> produtos){
        produtos.forEach(System.out::println);
    }
}
