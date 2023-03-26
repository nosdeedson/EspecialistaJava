package com.br.ejs.modulo.expressoesLambida.nonNative;

import com.br.ejs.modulo.expressoesLambida.nonNative.CadastroClienteWithPredicate;
import com.br.ejs.modulo.expressoesLambida.nonNative.Cliente;

import java.util.List;

public class Principal3 {

    public static void main(String[] args) {
        var cadastroCliente = new CadastroClienteWithPredicate();
        cadastroCliente.adicionar(new Cliente("João", 30));
        cadastroCliente.adicionar(new Cliente("Maria", 90));
        cadastroCliente.adicionar(new Cliente("Sebastião", 50));
        cadastroCliente.adicionar(new Cliente("Joaquina", 45));
        cadastroCliente.adicionar(new Cliente("Josefina", 25));

        List<Cliente> clientes = cadastroCliente.consultar(cliente -> cliente.getIdade() > 40);
        clientes.forEach((cliente -> {
            System.out.printf("%s - %d%n", cliente.getNome(), cliente.getIdade());
        }));
    }
}
