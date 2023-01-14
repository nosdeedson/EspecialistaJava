package com.br.ejs.herancaProblemaCorrecao.correcao;

public class SeguroSantander implements Seguro{

    @Override
    public double calcularPremio(int horasUtilizadas, double valorContrato) {
        return (horasUtilizadas * 0.5) + (valorContrato * 0.01);
    }
}
