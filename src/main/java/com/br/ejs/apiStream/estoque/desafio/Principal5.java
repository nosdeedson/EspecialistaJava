package com.br.ejs.apiStream.estoque.desafio;

import com.br.ejs.apiStream.estoque.desafio.comercial.ServicoDeVenda;
import com.br.ejs.apiStream.estoque.desafio.comercial.Venda;

import java.util.List;

public class Principal5 {
    public static void main(String[] args) {
        var servicoDeVenda = new ServicoDeVenda();
        List<Venda> vendas = servicoDeVenda.obterTodas();
        int quantidadeItensVendidos  = 0;
        for (Venda venda: vendas){
            if (venda.isFechada()){
                for (Venda.Item item: venda.getItens()){
                    quantidadeItensVendidos += item.quantidade();
                }
            }
        }
        System.out.println(quantidadeItensVendidos);
        System.out.println("------------------ STREAM -------------------");
        // TODO USE STREAM API
        int total = vendas.stream()
                .filter(Venda::isFechada)
                .flatMap(venda -> venda.getItens().stream())
                .mapToInt(Venda.Item::quantidade)
                .sum();
        System.out.println("total de itens: " + total);
    }
}
