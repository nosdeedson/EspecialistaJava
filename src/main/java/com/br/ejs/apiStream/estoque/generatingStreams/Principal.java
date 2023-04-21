package com.br.ejs.apiStream.estoque.generatingStreams;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Principal {

    public static void main(String[] args) {
        System.out.println("------------ FROM ARRAYS ---------------------");
        fromArrays();
        System.out.println("------------ FROM SEED ---------------------");
        interatingFromSeed();
        System.out.println("------------ GENERICS ExAMPLES ---------------------");
        genericsExamples();
        System.out.println("------------ GENERATING RANDOM NUMBERS ---------------------");
        generatingRandomNumbers();
    }

    private static void generatingRandomNumbers() {
        Random random = new Random();
        // THE GENERATE METHOD CREATES AN INFINITE LOOP, WE HAVE TO STOP IT WITH A PREDICATE OR USING THE METHOD LIMIT
        // WHICH WILL LIMIT THE SIZE OF THE STREAM
        Stream.generate(() -> random.nextInt(59) + 1 )
                .distinct()
                .limit(6)
                .forEach(System.out::println);
    }

    private static void genericsExamples(){
        Stream<Integer> empty = Stream.empty();
        System.out.println(empty.toString());
        // THE STREAM BELOW DOESN'T HAVE THE SUM, COUNT AND AVERAGE METHODS
        Stream.of(1,2,3,4,5,6)
                .forEach(System.out::println);
        System.out.println();
        // LIKE THIS ONE BELOW
        int total = IntStream.of(1,2,3,4,5,6)
                .sum();
        System.out.println(total);

        IntStream intStream = IntStream.of(10);
        System.out.println(intStream.toString());
    }

    private static void interatingFromSeed(){
        Stream.iterate(Integer.valueOf(1000)
                        ,(value1) -> {
                            return value1.compareTo(Integer.valueOf(0)) >= 0;
                        },
                        (theSameValue) -> theSameValue -= Integer.valueOf(10))
                .forEach(System.out::println);
    }

    private static void fromArrays(){
        String[] names = {"John", "Sheldon", "Adele", "Michael"};
        Arrays.stream(names)
                .map(String::toUpperCase)
                .sorted()
                .forEach(System.out::println);
    }
}
