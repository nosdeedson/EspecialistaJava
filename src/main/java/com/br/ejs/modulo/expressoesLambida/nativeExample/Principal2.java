package com.br.ejs.modulo.expressoesLambida.nativeExample;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.function.*;

public class Principal2 {

    public static void main(String[] args) {
        IntPredicate intPredicate = num -> num > 10; // used to filter a list objects
        System.out.println(intPredicate.test(20));

        // will retrun a string becaude we specified it in <String>
        // so the function will do something with the passed int and return a string
        IntFunction<String> stringIntFunction = num -> "Numero passado " + num;
        System.out.println(stringIntFunction.apply(10));

        // just return 10, that case the lambda function will do something and return a int
        // we don't pass anything to the method getAsInt
        IntSupplier intSupplier = () -> 5 * 5;
        System.out.println(intSupplier.getAsInt());

        // 'accept' will use the parameter to do something, but won't return anything
        IntConsumer intConsumer = (num) -> System.out.println(num * num);
        intConsumer.accept(10);
    }
}
