package com.br.ejs.apiStream.estoque.desafio;

import com.br.ejs.apiStream.estoque.Produto;
import com.br.ejs.apiStream.estoque.desafio.comercial.Cliente;
import com.br.ejs.apiStream.estoque.desafio.comercial.ServicoDeVenda;
import com.br.ejs.apiStream.estoque.desafio.comercial.Venda;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Principal7 {
    public static void main(String[] args) {
        var servicoDeVenda = new ServicoDeVenda();
        List<Venda> vendas = servicoDeVenda.obterTodas();
        Map<String, Long> vendasRealizadasPorCliente = new HashMap<>(vendas.size());
        for (Venda venda: vendas){
            if (venda.isFechada()){
                String nomeCliente = venda.getCliente().nome();
                Long quantidadeVendas = vendasRealizadasPorCliente.get(nomeCliente);
                if (quantidadeVendas == null){
                    quantidadeVendas = 0L;
                }
                vendasRealizadasPorCliente.put(nomeCliente, quantidadeVendas + 1);
            }
        }
        System.out.println(vendasRealizadasPorCliente);
        System.out.println("------------------ STREAM -------------------");
        vendasRealizadasPorCliente = vendas.stream()
                .filter(Venda::isFechada)
                .collect(
                        Collectors.groupingBy(venda -> venda.getCliente().nome(),
                                Collectors.counting())
                );
        System.out.println(vendasRealizadasPorCliente);
    }
}
