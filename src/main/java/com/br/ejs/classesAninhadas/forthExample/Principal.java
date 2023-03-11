package com.br.ejs.classesAninhadas.forthExample;

import java.math.BigDecimal;

public class Principal {

    public static void main(String[] args) {
        Conta conta = new Conta(new BigDecimal("1000"));
        System.out.println(conta);

        Transacao transacao = conta.efetuarPagamento((new BigDecimal("100")));
        Transacao transacao1 = conta.cobrarTarifa(new BigDecimal("20"));

        System.out.printf("Transação 1: R$%s%n", transacao.getValorTotal());
        System.out.printf("Transação 2: R$%s%n", transacao1.getValorTotal());
        System.out.printf("Saldo final: R$%s%n", conta.getSaldo());

        transacao.reembolsar();
        System.out.printf("Saldo final: R$%s%n", conta.getSaldo());

    }
}
