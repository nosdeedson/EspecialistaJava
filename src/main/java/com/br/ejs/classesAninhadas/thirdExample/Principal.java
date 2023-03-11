package com.br.ejs.classesAninhadas.thirdExample;

import java.math.BigDecimal;
import java.util.Arrays;

public class Principal {

    public static void main(String[] args) {
        ContaCorrente contaCorrente = new ContaCorrente(new BigDecimal("1000"));

        ContaCorrente.Transacao transacao = contaCorrente.new Transacao("mercado", new BigDecimal("100"));
        ContaCorrente.Transacao transacao1 = contaCorrente.new Transacao("academia", new BigDecimal("150"));

        System.out.println(contaCorrente.getSaldo());
        for (ContaCorrente.Transacao transacao2: contaCorrente.getTransacoes()){
            System.out.printf("%s = %s%n" , transacao2.getDescricao(), transacao2.getValor());
        }
    }
}
