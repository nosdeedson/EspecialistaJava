package com.br.ejs.Optional.tipoEspeciais;

import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.OptionalLong;

public class Principal {

    public static void main(String[] args) {
        System.out.println("Tests whith OptionalDouble");
        OptionalDouble optionalDouble = dividindoDoubles(10, 3);
        if (optionalDouble.isPresent()){
            System.out.println(optionalDouble.getAsDouble());
        }

        optionalDouble.ifPresent(System.out::println);

        dividindoDoubles(10, 0).ifPresent(System.out::println);

        dividindoDoubles(23, 7).orElseThrow(() -> new RuntimeException("sem DOUBLE"));
        try {
            dividindoDoubles(23, 0).orElseThrow(() -> new RuntimeException("sem DOUBLE"));
        }catch (RuntimeException e){
            System.out.println(e.getMessage());
        }

        System.lineSeparator();
        System.out.println("Tests whith OptionalLong");
        OptionalLong optionalLong = dividindoLongs(10, 3);
        if (optionalLong.isPresent()){
            System.out.println(optionalLong.getAsLong());
        }

        optionalLong.ifPresent(System.out::println);

        dividindoLongs(10, 0).ifPresent(System.out::println);

        dividindoLongs(23, 7).orElseThrow(() -> new RuntimeException("sem LONG"));
        try {
            dividindoLongs(23, 0).orElseThrow(() -> new RuntimeException("sem LONG"));
        }catch (RuntimeException e){
            System.out.println(e.getMessage());
        }

        System.lineSeparator();
        System.out.println("Tests whith OptionalInt");
        OptionalInt optionalInt = dividindoInts(10, 3);
        if (optionalInt.isPresent()){
            System.out.println(optionalInt.getAsInt());
        }

        optionalInt.ifPresent(System.out::println);

        dividindoInts(10, 0).ifPresent(System.out::println);

        dividindoInts(23, 7).orElseThrow(() -> new RuntimeException("sem INT"));
        try {
            dividindoInts(23, 0).orElseThrow(() -> new RuntimeException("sem INT"));
        }catch (RuntimeException e){
            System.out.println(e.getMessage());
        }
    }

    public static OptionalInt dividindoInts(int a, int b){
        if (b == 0) return OptionalInt.empty();
        return OptionalInt.of( a / b);
    }

    public static OptionalLong dividindoLongs(long a, long b){
        if (b == 0) return OptionalLong.empty();
        return OptionalLong.of(a / b);
    }

    public static OptionalDouble dividindoDoubles(double a, double b){
        if (b == 0 ) return OptionalDouble.empty();
        return OptionalDouble.of(a /b);
    }
}
