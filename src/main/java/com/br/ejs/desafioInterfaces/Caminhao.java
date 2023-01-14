package com.br.ejs.desafioInterfaces;

import com.br.ejs.desafioInterfaces.VeiculoAutomotor;

public class Caminhao extends VeiculoAutomotor {

    private int quantidadeEixos;

    public Caminhao(String modelo, double valorMercado, int anoFabricacao, int quantidadeEixos) {
        super(modelo, valorMercado, anoFabricacao);
        this.quantidadeEixos = quantidadeEixos;
    }

    @Override
    public double calcularValorPremio() {
        double valorPremio = this.getValorMercado() * 0.02;
        valorPremio += this.quantidadeEixos * 50;
        return valorPremio;
    }

    @Override
    public String descrever() {

        String descricao = "Ano fabricacao: " + this.getAnoFabricacao() + " Modelo: " + this.getModelo()
                + " Valor mercado: " + this.getValorMercado();
        return descricao;
    }

    public int getQuantidadeEixos() {
        return quantidadeEixos;
    }

    public void setQuantidadeEixos(int quantidadeEixos) {
        this.quantidadeEixos = quantidadeEixos;
    }
}
