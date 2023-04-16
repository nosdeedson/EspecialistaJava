package com.br.ejs.apiStream.estoque;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.IntBinaryOperator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Principal {

    public static void main(String[] args) {
        var cadastroProduto = new CadastroProduto();

        List<Produto> produtos = cadastroProduto.obterTodos();
        imprimir(produtos);
        List<Produto> produtosEncontrados = encontrarPorNome("Refri", produtos);
        System.out.println("encontrou");
        imprimir(produtosEncontrados);

        System.out.println("\n #################### FILTRANDO #####################################");
        filtrando(produtos);

        System.out.println("\n################## FIND FIRST ###############################");
        try {
            findFirst(produtos);
        } catch (RuntimeException e){
            System.out.println(e.getMessage());
        }

        System.out.println("###################### CHECKING STOCK ##############################");
        checkingStock(produtos);

        System.out.println("###################### ODERING BY QUANTITY ##############################");
        orderingByQuantity(produtos);
        System.out.println("###################### LISTING MANUFACTURERS ##############################");
        listingManufacturer(produtos);
        System.out.println("###################### LISTING CATEGORIAS ##############################");
        listingCategorias(produtos);

        System.out.println("###################### Adding quantities of products ##############################");
        addingQuantities(produtos);

        System.out.println("########### checking quantities");
        productWithSmallerStock(produtos);
        productWithGreaterStock(produtos);
    }

    public static void productWithSmallerStock(List<Produto> produtos){
        int min = produtos.stream()
                .mapToInt(Produto::getQuantidade)
                .reduce(0, Integer::min);
        System.out.println("min: " + min );
    }

    public static void productWithGreaterStock(List<Produto> produtos){
        int max = produtos.stream()
                .mapToInt(Produto::getQuantidade)
                .reduce(0, Integer::max);
        System.out.println("max: " + max );
    }

    public static void addingQuantities(List<Produto> produtos){
        IntBinaryOperator operator = (accumulator, productQuantity) -> {
            System.out.println(accumulator + " + " + productQuantity);
            return accumulator + productQuantity;
        };
        int sum = produtos.stream()
                .filter(Produto::temEstoque)
                .mapToInt(Produto::getQuantidade)
                .reduce(0, operator);
        System.out.println("quantity of products: " + sum);

        System.out.println("----------------- best way ----------------------");
        sum = produtos.stream()
                .mapToInt(Produto::getQuantidade)
                .reduce(0, (accumulator, productQuantity) -> accumulator + productQuantity);

        System.out.println("quantity of products: " + sum);

        System.out.println("----------------- even better ----------------------");
        sum = produtos.stream()
                .mapToInt(Produto::getQuantidade)
                .reduce(0, Integer::sum);
        System.out.println("quantity of products: " + sum);
    }

    public static void listingCategorias(List<Produto> produtos){
       Stream<Stream<Categoria>> stream = produtos.stream()
                .filter(produto -> produto.temEstoque())
                .map(produto -> produto.getCategorias().stream());
//       stream.forEach(obj -> {
//           System.out.println(obj.getClass().getName());
//       });

        System.out.println("--------------- printing categorias --------------");
        stream.forEach(obj ->{
            obj.forEach(System.out::println);
        });

        System.out.println("--------------- BEST WAY TO DO THIS CODE ABOVE");
        produtos.stream()
                .filter(Produto::temEstoque)
                .flatMap(produto -> produto.getCategorias().stream())
                .distinct()
                .forEach(System.out::println);
    }

    public static  void listingManufacturer(List<Produto> produtos){
        produtos.stream()
                .filter(Produto::temEstoque)
                .map(Produto::getFabricante)
                .distinct() // for this operatin to work it is necessary that the Class manuplulated had implemented the equals methods
                .forEach(System.out::println);

        // as the Fabricante is a 'record' by default this type of atribute implements the equals methods
        // even though the equals methods doesn't appear in the file
    }

    public static  void  orderingByName(List<Produto> produtos){
        // the sorted() method will use the compareTo of the class Produto, which implements 'Comparable'
        produtos.stream()
                .filter(Produto::temEstoque)
                .sorted()
                .forEach(produto -> {
                    System.out.println("Nome: " + produto.getNome() + " qtd: " + produto.getQuantidade());
                });
    }

    public static  void  orderingByQuantity(List<Produto> produtos){
        produtos.stream()
                .filter(Produto::temEstoque)
                .sorted(Comparator.comparingInt(Produto::getQuantidade))
                .forEach(produto -> {
                    System.out.println("Nome: " + produto.getNome() + " qtd: " + produto.getQuantidade());
                });
    }

    public static void checkingStock(List<Produto> produtos){
        boolean hasStock = produtos.stream().anyMatch(Produto::temEstoque);
        if (hasStock){
            System.out.println("at least one product has stock");
        } else {
            System.out.println("none of the products have stock");
        }

        boolean allProductsHasStock = produtos.stream().allMatch(Produto::temEstoque);

        if (allProductsHasStock){
            System.out.println("all products have stock");
        } else {
            System.out.println("there are some products that don't have stock");
        }

        boolean noneProductHasStock = produtos.stream().noneMatch(Produto::temEstoque);
        if (noneProductHasStock){
            System.out.println("All the products don't have stock");
        } else {
            System.out.println("some products have stock");
        }
    }

    public static void findFirst(List<Produto> produtos){
        // the findFirst return the first object thar apply to the intermidiate operations like filter
        Produto produto = produtos.stream()
                .peek(System.out::println)
                .filter(Produto::temEstoque)
                .filter(Produto::isInativo)
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Nenhum Produto encontrado"));
        System.out.println("-------------- resultado --------------------");
        imprimiUm(produto);
    }

    public static void filtrando(List<Produto> produtos){
        /**
         * Stream has operations that configure what will be done, that are called intermeditate functionalities
         * the configurate functions are not executed until we call a terminate operation in the list
         * a terminate operation is a function that does the actions in the list accordingly to the configurations
         */
        produtos.stream()
                // peek is an intermediate operation of the stream that changes the objects manipulated
                .peek(produto -> produto.setNome(produto.getNome().toUpperCase()))
               // .peek(produto -> System.out.println("Antes de ver se tem estoque " + produto + "\n"))
                .filter(Produto::temEstoque)
                //.peek(produto -> System.out.println("Antes de ativar" + produto ))
                .peek(Produto::ativar)
                .forEach(Principal::imprimiUm);
    }

    public static List<Produto> encontrarPorNome(String nome, List<Produto> produtos){
        Stream<Produto> temProduto = produtos.stream()
                .filter(produto -> nome.equals(produto.getNome()));
        return temProduto.collect(Collectors.toList());
    }


    public static void imprimir(List<Produto> produtos){
        produtos.stream()
                .forEach(produto -> {
                    produto.inativar();
                    System.out.println(produto + "\n");
                });
    }

    public  static void imprimiUm(Produto produto){
        System.out.println(produto);
    }
}
