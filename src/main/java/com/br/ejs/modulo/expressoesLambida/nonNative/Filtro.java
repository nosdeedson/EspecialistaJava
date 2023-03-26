package com.br.ejs.modulo.expressoesLambida.nonNative;


@FunctionalInterface
public interface Filtro<T>{

    /**
     * Functional interface can have just one abstract method, which allows with it with lambda expressions
     * the benefit of the anotation is that the compiler will indicate that is not allowed to add another abstract method
     * @param Object
     * @return
     */
    boolean avaliar(T Object);
}
