package com.br.ejs.heranca;

public class Funcionario {
    private String nome;
    private double valorHora;

    public Funcionario(String nome, double valorHora) {
        this.nome = nome;
        this.valorHora = valorHora;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getValorHora() {
        return valorHora;
    }

    public void setValorHora(double valorHora) {
        this.valorHora = valorHora;
    }

    protected double calcularSalario(int horasTrabalhadas){
        double valorSalario = horasTrabalhadas * valorHora;
        return  valorSalario;
    }

    public Holerite gerarHolerite( int horasTrabalhadas, String mesAno){
        Holerite holerite = new Holerite(this.nome, mesAno, calcularSalario(horasTrabalhadas));
        return holerite;
    }

    @Override
    public String toString() {
        return "Funcionario{" +
                "nome='" + nome + '\'' +
                ", valorHora=" + valorHora +
                '}';
    }
}
