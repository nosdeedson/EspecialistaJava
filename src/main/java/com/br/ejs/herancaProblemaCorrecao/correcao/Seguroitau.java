package com.br.ejs.herancaProblemaCorrecao.correcao;

public class Seguroitau implements Seguro{
    @Override
    public double calcularPremio(int horasUtilizadas, double valorContrato) {
        return 5d;
    }
}
