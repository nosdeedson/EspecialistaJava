package com.br.ejs.loggs.slf4jwithlogback.banco.negocio;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.util.Objects;

public class ContaCorrente {

    private static final Logger logger = LoggerFactory.getLogger(ContaCorrente.class);

    private final Titular titular;
    private final int agencia;
    private final int numero;
    private BigDecimal saldo = BigDecimal.ZERO;

    public ContaCorrente(Titular titular, int agencia, int numero) {
        Objects.requireNonNull(titular);
        this.titular = titular;
        this.agencia = agencia;
        this.numero = numero;
    }

    protected void validarSandoParaSaque(BigDecimal valorSaque) throws SaldoInsuficienteException {
        if (getSaldo().compareTo(valorSaque) < 0){
            throw  new SaldoInsuficienteException("Saldo insuficiente para realizar o saque");
        }
    }

    public void sacar(BigDecimal valorSaque){
        logger.debug("Realizando saque...");
        Objects.requireNonNull(valorSaque);
        if (valorSaque.compareTo(BigDecimal.ZERO) <= 0){
            throw new IllegalArgumentException("valor do saque deve ser maior que zero");
        }

        validarSandoParaSaque(valorSaque);
        saldo = saldo.subtract(valorSaque);
        logger.info("Saque de R${} realizado na conta {}", valorSaque, getAgencia() + "/" + getNumero());

    }

    public final void depositar(BigDecimal valorDeposito){
        logger.debug("Realizando depósito...");
        Objects.requireNonNull(valorDeposito);

        if(valorDeposito.compareTo(BigDecimal.ZERO)<= 0){
            throw new IllegalArgumentException("valor de depósito tem que ser maior que zero");
        }

        saldo = saldo.add(valorDeposito);
        logger.info("Depósito de R${} realizado na conta {}", valorDeposito, getAgencia() + "/" + getNumero());
    }

    public void imprimirDemonstrativo(){
        System.out.println();
        System.out.printf("Agência: %d%n", getAgencia());
        System.out.printf("Conta: %d%n", getNumero());
        System.out.printf("titular: %s%n", getTitular());
        System.out.printf("Saldo: %.2f%n", getSaldo());

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ContaCorrente that = (ContaCorrente) o;
        return agencia == that.agencia && numero == that.numero;
    }

    @Override
    public int hashCode() {
        return Objects.hash(agencia, numero);
    }

    @Override
    public String toString() {
        return "ContaCorrente{" +
                "titular=" + titular +
                ", agencia=" + agencia +
                ", numero=" + numero +
                ", saldo=" + saldo +
                '}';
    }

    public Titular getTitular() {
        return titular;
    }

    public int getAgencia() {
        return agencia;
    }

    public int getNumero() {
        return numero;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }
}
