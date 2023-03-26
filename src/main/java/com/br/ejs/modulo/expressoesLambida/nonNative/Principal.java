package com.br.ejs.modulo.expressoesLambida.nonNative;

import com.br.ejs.modulo.expressoesLambida.nonNative.CadastroCliente;
import com.br.ejs.modulo.expressoesLambida.nonNative.Cliente;

import java.util.List;

public class Principal {

    public static void main(String[] args) {
        var cadastroCliente = new CadastroCliente();
        cadastroCliente.adicionar(new Cliente("João", 30));
        cadastroCliente.adicionar(new Cliente("Maria", 90));
        cadastroCliente.adicionar(new Cliente("Sebastião", 50));
        cadastroCliente.adicionar(new Cliente("Joaquina", 45));
        cadastroCliente.adicionar(new Cliente("Josefina", 25));

        // Filtro recebe uma classe anonima
//        Filtro filtro = new Filtro<Cliente>() {
//            @Override
//            public boolean avaliar(Cliente cliente) {
//                return cliente.getIdade() > 40;
//            }
//        };

        /**
         * using lambda function, first example
         * just work with functional interfaces which has just one abstract method
         * the functional interface can have default methods
         * note: the functinal interfaces can override the methods of the Object Class,
         * this will make the interface to have more than one abstract method
         * but this won't mischaracterze the interface, which still could be used with lambda expressions
         */

//        Filtro<Cliente> filtro = (Cliente cliente) ->{
//            return cliente.getIdade() > 40;
//        };
//        List<Cliente> clientes = cadastroCliente.consultar(filtro);

        /**
         * passing the lambda function to the method, second example
         * just work with functional interfaces which has just one abstract method
         * the functional interface can have default methods
         */
//        List<Cliente> clientes = cadastroCliente.consultar((Cliente c) -> {return c.getIdade() > 40;});

        /**
         * passing the lambda function to the method, third example
         * simplified lambda function
         * in the example bellow the return is implicit
         * when using lambda fuction a good practice is that the lambida function has just one line
         * but it could have the maximum of three lines
         */
//        List<Cliente> clientes = cadastroCliente.consultar((Cliente c) -> c.getIdade() > 40);

        /**
         * other good practice is to omit the type of the parameter, because the compiler will infer it
         * another one is to omit the parentheses
         * this is good because the code is more simple
         */
        List<Cliente> clientes = cadastroCliente.consultar(cliente -> cliente.getIdade() > 40);
        clientes.forEach((cliente -> {
            System.out.printf("%s - %d%n", cliente.getNome(), cliente.getIdade());
        }));
    }
}
