package com.br.ejs.modulo.expressoesLambida.desafio;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Locale;
import java.util.function.*;

public class Principal {

    public static void main(String[] args) {
        var funcionarios = new ArrayList<Funcionario>();
        funcionarios.add(new Funcionario("João", new BigDecimal("19000.12"), true));
        funcionarios.add(new Funcionario("Maria", new BigDecimal("5000"), true));
        funcionarios.add(new Funcionario("Manoel", new BigDecimal("13000"), true));
        funcionarios.add(new Funcionario("Sebastião", new BigDecimal("12000"), false));

        // TODO remover funcionários inativos
//        Predicate<Funcionario> funcionarioPredicate = funcionario -> funcionario.isAtivo();
//        funcionarios.removeIf(funcionarioPredicate.negate());
        // simplificado
        funcionarios.removeIf(Funcionario::isInativo);

        // TODO ordenar funcionários pelo valor do salário
//        Function<Funcionario, BigDecimal> function = funcionario -> funcionario.getSalario();
//        funcionarios.sort(Comparator.comparing(function));
        // simplificado
        funcionarios.sort(Comparator.comparing(Funcionario::getSalario));
        // TODO iterar e imprimir funcionários usando o método estático imprimir
        funcionarios.forEach(Principal::imprimir);
    }

    private static void imprimir(Funcionario funcionario){
        // TODO implementar a impressão do nome, salário e impostos (20%)
        ToDoubleFunction<Funcionario> impostoFuncionario = funci -> funci
                .getSalario()
                .multiply(new BigDecimal("0.20"))
                .doubleValue();
        ToDoubleFunction<Funcionario> salarioFuncionario = funci -> funci
                .getSalario()
                .doubleValue();

        NumberFormat numberFormat = NumberFormat.getNumberInstance(new Locale("pt", "BR"));
        final String impostos = numberFormat.format(impostoFuncionario.applyAsDouble(funcionario));
        final String salario = numberFormat.format(salarioFuncionario.applyAsDouble(funcionario));

        Consumer<Funcionario> funcionarioConsumer = funcionario1 ->
            System.out.printf(String.format(
                    "[Nome: %s -> Salario: %s -> Impostos: %s]%n",
                    funcionario1.getNome(), salario, impostos));
        funcionarioConsumer.accept(funcionario);
    }
}
