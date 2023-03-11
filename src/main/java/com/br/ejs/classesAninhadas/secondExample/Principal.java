package com.br.ejs.classesAninhadas.secondExample;

import java.util.ArrayList;
import java.util.List;

public class Principal {

    public static void main(String[] args) {
        List<Cliente> clientes = new ArrayList<Cliente>();

        clientes.add(new Cliente("João", 41));
        clientes.add(new Cliente("Maria", 37));

        clientes.add(new Cliente("Sebastião", 27));
        Cliente.ordenarPorIdade(clientes);

        System.out.println(clientes);

        clientes.forEach( cliente -> {
            cliente.setStatus(Cliente.Status.BLOQUEADO);
        });

        System.out.println(clientes);
    }

}
