package com.br.ejs.modulo.expressoesLambida.nativeExample;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Principal {

    public static void main(String[] args) {
        Predicate<String> stringPredicate = str -> str.startsWith("e"); // used to filter list
        boolean teste = stringPredicate.test("edson");
        System.out.println(teste);


        Function<String, LocalDate> function = str -> LocalDate.parse(str); // used to return another type of object do somenthing
        // I should try to use this function to create a new obejct but for me to do that I have to create a method maybe
        LocalDate data = function.apply("2023-03-26");
        System.out.println(data);
        System.out.println(data.getClass());

        Supplier<LocalDateTime> supplier = () -> LocalDateTime.now(); // return the object specified in the diamond brakets
        LocalDateTime dateTime = supplier.get();
        System.out.println(dateTime);

        Consumer<String> consumer = str -> System.out.println(str); // does somenthing, but don't return anything
        consumer.accept("teste");

    }
}
