package com.br.ejs.generics.comTipagem;

public class Principal {

    public static void main(String[] args) {
        Funcionario[] funcionarios = {
                new Funcionario("joao", 23),
                new Funcionario("jose", 23),
                new Funcionario("maria", 23),
        };
        Funcionario funcionario = null;
        try {
            funcionario = Pesquisador.pesquisar(funcionarios, "jose");
            System.out.println("resultado: " + funcionario.getNome() + " : " + funcionario.getIdade());
        } catch (RuntimeException e){
            System.out.println(e.getMessage());
        }

        Cliente[] clientes = {
                new Cliente("posto gasolina", 10000d),
                new Cliente("bar do noe", 10000d),
                new Cliente("padaria dona benta", 10000d),
        };
        Cliente cliente = null;
        try {
            cliente = Pesquisador.pesquisar(clientes, "posto1 gasolina");
            System.out.println("Resultado: " + cliente.getNome());
        } catch (RuntimeException e ){
            System.out.println(e.getMessage());
        }
    }
}
