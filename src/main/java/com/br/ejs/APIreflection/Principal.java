package com.br.ejs.APIreflection;

import com.br.ejs.APIreflection.entidadesWithoutAnotations.Cliente;
import com.br.ejs.APIreflection.entidadesWithoutAnotations.Produto;
import com.br.ejs.APIreflection.geradorCSV.GeradorCSV;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Arrays;

public class Principal {

    public static void main(String[] args) {

        var clientes = Arrays.asList(new Cliente(1L,"João", LocalDate.parse("2005-03-10")),
                new Cliente(2L,"Maria", LocalDate.parse("1981-09-13")),
                new Cliente(3L,"Manoel", LocalDate.parse("1986-11-30")),
                new Cliente(4L,"Ana", LocalDate.parse("1992-05-02")));
        System.out.println("############## USING GERADORCSV WITH CLIENTE ############################");
        GeradorCSV.imprimir(Cliente.class, clientes);
        System.out.println("############## USING GERADORCSV WITH PRODUTO ############################");
        var produtos = Arrays.asList(new Produto(1L, "Macbook Pro", new BigDecimal("19500"), 25),
                new Produto(2L, "iPhone", new BigDecimal("12300"), 7),
                new Produto(4L, "Monitor", new BigDecimal("1800"), 18));

        GeradorCSV.imprimir(Produto.class, produtos);
    }
}
