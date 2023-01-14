package com.br.ejs.desafioInterfaces;

public class CarroParticular extends VeiculoAutomotor{

    public CarroParticular(String modelo, double valorMercado, int anoFabricacao) {
        super(modelo, valorMercado, anoFabricacao);
    }

    @Override
    public double calcularValorPremio() {
        double valorPremio = this.getValorMercado() * 0.04;
        if(this.getAnoFabricacao() < 2000){
            valorPremio += this.getValorMercado() * 0.05;
        }
        return valorPremio;
    }

    @Override
    public String descrever() {
        String descricao = String.format("Ano fabricacao: %d, Modelo: %s, valor mercado: %f.2",
            this.getAnoFabricacao(), this.getModelo(), this.getValorMercado());
        return descricao;
    }
}
