package com.br.ejs.loggs.slf4jwithlogback.banco.negocio;

public class SaldoInsuficienteException extends RuntimeException {
    public SaldoInsuficienteException(String message) {
        super(message);
    }
}
