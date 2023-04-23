package com.br.ejs.apiStream.estoque.desafio;

import com.br.ejs.apiStream.estoque.desafio.comercial.ServicoDeVenda;
import com.br.ejs.apiStream.estoque.desafio.comercial.Venda;

import java.util.List;

public class Principal1 {
    public static void main(String[] args) {
        var servicoDeVenda = new ServicoDeVenda();
        List<Venda> vendas = servicoDeVenda.obterTodas();
        for (Venda venda: vendas){
            if (venda.isFechada()){
                System.out.println(venda);
            }
        }
        System.out.println("------------------ STREAM -------------------");
        // TODO TO USE STREAM API
        vendas.stream()
                .filter(Venda::isFechada)
                .forEach(System.out::println);
    }
}
