package com.br.ejs.classesAninhadas.thirdExample;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class ContaCorrente {

    private BigDecimal saldo;
    private List<Transacao> transacoes = new ArrayList<>();

    public ContaCorrente(BigDecimal saldo) {
        this.saldo = saldo;
    }

    public List<Transacao> getTransacoes() {
        return transacoes;
    }

    public void setTransacoes(List<Transacao> transacoes) {
        this.transacoes = transacoes;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }

    public class Transacao{
        private String descricao;
        private BigDecimal valor;

        public Transacao(String descricao, BigDecimal valor) {
            this.descricao = descricao;
            this.valor = valor;
//            saldo = saldo.subtract(valor);
//            transacoes.add(this);
            ContaCorrente.this.saldo = ContaCorrente.this.saldo.subtract(valor); // should use this way if threre is attributes with the same name
            ContaCorrente.this.transacoes.add(this); // 'this' does reference to transacao
        }

        public String getDescricao() {
            return descricao;
        }

        public void setDescricao(String descricao) {
            this.descricao = descricao;
        }

        public BigDecimal getValor() {
            return valor;
        }

        public void setValor(BigDecimal valor) {
            this.valor = valor;
        }
    }
}
