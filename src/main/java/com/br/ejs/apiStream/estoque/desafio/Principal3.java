package com.br.ejs.apiStream.estoque.desafio;

import com.br.ejs.apiStream.estoque.desafio.comercial.ServicoDeVenda;
import com.br.ejs.apiStream.estoque.desafio.comercial.Venda;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Principal3 {
    public static void main(String[] args) {
        var servicoDeVenda = new ServicoDeVenda();
        List<Venda> vendas = servicoDeVenda.obterTodas();
        List<String> descricoes = new ArrayList<>(vendas.size());
        for (Venda venda: vendas){
            if (venda.isFechada()){
                for (Venda.Item item: venda.getItens()){
                    if (!descricoes.contains(item.descricao())){
                        descricoes.add(item.descricao());
                    }
                }
            }
        }
        Collections.sort(descricoes);
        for (String descricao: descricoes){
            System.out.println(descricao);
        }

        System.out.println("------------------ STREAM -------------------");
        // TODO USE STREAM API
         vendas.stream()
                .filter(Venda::isFechada)
                .flatMap(venda -> venda.getItens().stream())
                 .map(Venda.Item::descricao)
                 .distinct()
                 .forEach(System.out::println);

    }
}
