package com.br.ejs.apiStream.estoque.desafio;

import com.br.ejs.apiStream.estoque.desafio.comercial.ServicoDeVenda;
import com.br.ejs.apiStream.estoque.desafio.comercial.Venda;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

public class Principal4 {
    public static void main(String[] args) {
        var servicoDeVenda = new ServicoDeVenda();
        List<Venda> vendas = servicoDeVenda.obterTodas();
        BigDecimal totalVendas = BigDecimal.ZERO;
        for (Venda venda: vendas){
            if (venda.isFechada()){
                totalVendas = totalVendas.add(venda.getValorTotal());
            }
        }
        System.out.println(totalVendas);
        System.out.println("------------------ STREAM -------------------");
        totalVendas = vendas.stream()
                .filter(Venda::isFechada)
                .map(Venda::getValorTotal)
                .reduce((bigDecimal, bigDecimal2) -> bigDecimal.add(bigDecimal2))
                .orElse(BigDecimal.ZERO);

        System.out.println("total vendido: " + totalVendas.toString());
    }
}
