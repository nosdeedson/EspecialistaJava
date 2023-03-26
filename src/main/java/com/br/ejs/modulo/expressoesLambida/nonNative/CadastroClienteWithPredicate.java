package com.br.ejs.modulo.expressoesLambida.nonNative;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class CadastroClienteWithPredicate {

    /**
     * a good practice is to use interfaces native from the language
     * so instead of using Filtro use Predicate that has the same method to compare
     */

    private final List<Cliente> clientes = new ArrayList<>();

    public List<Cliente> getClientes() {
        return clientes;
    }

    public void adicionar(Cliente cliente){
        clientes.add(cliente);
    }

    public List<Cliente> consultar(Predicate<Cliente> clientePredicate){
        List<Cliente> clientesFiltrados = new ArrayList<>();
        for (Cliente cliente: clientes){
            if (clientePredicate.test(cliente)){
                clientesFiltrados.add(cliente);
            }
        }

        return clientesFiltrados;
    }
}
