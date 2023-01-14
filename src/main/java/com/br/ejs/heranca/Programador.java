package com.br.ejs.heranca;

public class Programador extends Funcionario {

    private double valorBonus;
    public Programador(String nome, double valorHora) {
        super(nome, valorHora);
    }

    public double getValorBonus() {
        return valorBonus;
    }

    public void setValorBonus(double valorBonus) {
        this.valorBonus = valorBonus;
    }

    @Override
    protected double calcularSalario(int horasTrabalhadas) {
        double valorSalario = super.calcularSalario(horasTrabalhadas);
        valorSalario += this.valorBonus;
        return valorSalario;
    }

    @Override
    public Holerite gerarHolerite(int horasTrabalhadas, String mesAno) {
        return super.gerarHolerite( horasTrabalhadas, mesAno);
    }

    @Override
    public String toString() {
        return "Programador{" +
                super.toString() +
                "valorBonus=" + valorBonus +
                '}';
    }
}
