package com.br.ejs.apiStream.estoque.desafio;

import com.br.ejs.apiStream.estoque.desafio.comercial.Cliente;
import com.br.ejs.apiStream.estoque.desafio.comercial.ServicoDeVenda;
import com.br.ejs.apiStream.estoque.desafio.comercial.Venda;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Principal2 {
    public static void main(String[] args) {
        var servicoDeVenda = new ServicoDeVenda();
        List<Venda> vendas = servicoDeVenda.obterTodas();
        List<Cliente> clientes = new ArrayList<>();
        for (Venda venda: vendas){
            if (venda.isFechada() && !clientes.contains(venda.getCliente())){
                clientes.add(venda.getCliente());
            }
        }
        clientes.sort(Comparator.comparing(Cliente::nome));
        for (Cliente cliente: clientes){
            System.out.println(cliente);
        }
        System.out.println("------------------ STREAM -------------------");
        // TODO USE STREAM API
        vendas.stream()
                .filter(Venda::isFechada)
                .map(Venda::getCliente)
                .sorted(Comparator.comparing(Cliente::nome))
                .forEach(System.out::println);
    }
}
