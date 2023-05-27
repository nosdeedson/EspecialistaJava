package com.br.ejs.APIreflection;

import com.br.ejs.APIreflection.entidadesWithAnotations.Cliente;
import com.br.ejs.APIreflection.entidadesWithAnotations.Produto;
import com.br.ejs.APIreflection.geradorCSV.GeradorCSVCheckingAnotation;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Arrays;

public class Principal2 {

    public static void main(String[] args) {
        var clientes = Arrays.asList(new Cliente(1L,"João", LocalDate.parse("2005-03-10")),
                new com.br.ejs.APIreflection.entidadesWithAnotations.Cliente(2L,"Maria", LocalDate.parse("1981-09-13")),
                new Cliente(3L,"Manoel", LocalDate.parse("1986-11-30")),
                new Cliente(4L,"Ana", LocalDate.parse("1992-05-02")));
        System.out.println("############## USING GERADORCSV WITH CLIENTE ############################");
        GeradorCSVCheckingAnotation.imprimir(Cliente.class, clientes);
        System.out.println("############## USING GERADORCSV WITH PRODUTO ############################");
        var produtos = Arrays.asList(new Produto(1L, "Macbook Pro", "Macbook Pro", new BigDecimal("19500"), 25),
                new Produto(2L, "iPhone", "iPhone", new BigDecimal("12300"), 7),
                new Produto(4L, "Monitor", "Monitor", new BigDecimal("1800"), 18));

        GeradorCSVCheckingAnotation.imprimir(Produto.class, produtos);
    }
}
