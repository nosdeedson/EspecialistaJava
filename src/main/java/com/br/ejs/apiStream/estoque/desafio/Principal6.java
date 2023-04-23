package com.br.ejs.apiStream.estoque.desafio;

import com.br.ejs.apiStream.estoque.desafio.comercial.Cliente;
import com.br.ejs.apiStream.estoque.desafio.comercial.ServicoDeVenda;
import com.br.ejs.apiStream.estoque.desafio.comercial.Venda;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Principal6 {
    public static void main(String[] args) {
        var servicoDeVenda = new ServicoDeVenda();
        List<Venda> vendas = servicoDeVenda.obterTodas();
        List<String> clientes = new ArrayList<>(vendas.size());
        for (Venda venda: vendas){
            if (venda.isFechada()){
                if (!clientes.contains(venda.getCliente())){
                    clientes.add(venda.getCliente().nome());
                }
            }
        }
        Collections.sort(clientes);
        System.out.println(clientes);
        System.out.println("------------------ STREAM -------------------");

        vendas.stream()
                .filter(Venda::isFechada)
                .map(Venda::getCliente)
                .sorted(Comparator.comparing(Cliente::nome))
                .map(Cliente::nome)
                .forEach(System.out::println);
    }
}
