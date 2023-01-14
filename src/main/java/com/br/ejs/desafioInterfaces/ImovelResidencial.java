package com.br.ejs.desafioInterfaces;

public class ImovelResidencial implements BemSeguravel{

    private double valorMercado;
    private int areaConstruida;

    public ImovelResidencial(){}

    public ImovelResidencial(double valorMercado, int areaConstruida) {
        this.valorMercado = valorMercado;
        this.areaConstruida = areaConstruida;
    }

    public double getValorMercado() {
        return valorMercado;
    }

    public void setValorMercado(double valorMercado) {
        this.valorMercado = valorMercado;
    }

    public int getAreaConstruida() {
        return areaConstruida;
    }

    public void setAreaConstruida(int areaConstruida) {
        this.areaConstruida = areaConstruida;
    }

    @Override
    public double calcularValorPremio() {
        double valorPremio = this.valorMercado * 0.01;
        valorPremio += this.areaConstruida * 0.3;
        return valorPremio;
    }

    @Override
    public String descrever() {
        String descricao =
                String.format("Valor de mercado: %f.2; Área construída: %d", this.valorMercado, this.areaConstruida);
        return descricao;
    }
}
