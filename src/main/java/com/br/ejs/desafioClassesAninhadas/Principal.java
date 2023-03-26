package com.br.ejs.desafioClassesAninhadas;

import com.br.ejs.desafioClassesAninhadas.vendas.Cliente;
import com.br.ejs.desafioClassesAninhadas.vendas.Pedido;

import java.math.BigDecimal;

public class Principal {

    public static void main(String[] args) {
        Cliente cliente = new Cliente("João");
        Pedido pedido = new Pedido(cliente);

        Pedido.ItemPedido itemPedido = pedido.adicionarItem("iphpne 14", 3, new BigDecimal("12000"));
        Pedido.ItemPedido itemPedido1 = pedido.adicionarItem("iwatch", 3, new BigDecimal("5900"));

        Pedido.Imprimi.imprimiResumo(pedido);

        pedido.emitir();
//        item1.setQuantidade(20);

    }
}
