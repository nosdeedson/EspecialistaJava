package com.br.ejs.modulo.expressoesLambida.nonNative;

import com.br.ejs.modulo.expressoesLambida.nonNative.CadastroCliente;
import com.br.ejs.modulo.expressoesLambida.nonNative.Cliente;

import java.util.List;

public class Principal2 {

    public static void main(String[] args) {
        var cadastroCliente = new CadastroCliente();
        cadastroCliente.adicionar(new Cliente("João", 30));
        cadastroCliente.adicionar(new Cliente("Maria", 90));
        cadastroCliente.adicionar(new Cliente("Sebastião", 50));
        cadastroCliente.adicionar(new Cliente("Joaquina", 45));
        cadastroCliente.adicionar(new Cliente("Josefina", 25));

        List<Cliente> clientes = cadastroCliente.getClientes();

        /**
         * Comparing clientes without lambda
         */
//        clientes.sort(new Comparator<Cliente>() {
//            @Override
//            public int compare(Cliente cliente, Cliente t1) {
//                return Integer.compare(cliente.getIdade(), t1.getIdade());
//            }
//        });

        /**
         * Comparing with lambda expression
         */

        clientes.sort((cliente, cliente2) -> Integer.compare(cliente.getIdade(), cliente2.getIdade()));

        clientes.forEach((cliente -> {
            System.out.printf("%s - %d%n", cliente.getNome(), cliente.getIdade());
        }));

    }
}
