package com.br.ejs.Optional.desafio;

import java.util.Arrays;
import java.util.Objects;
import java.util.Optional;

public class Principal {

    public static void main(String[] args) {
        var endereco1 = new Endereco("Av Rondon Pacheco", "2000", "Santa Maria");
        var endereco2 = new Endereco("Av Afonso Pena", "3000", "Centro", new Cidade("Uberlândia"));
        var endereco3 = new Endereco("Av João Naves", "1000", "Santa Mônica", new Cidade("Uberlândia"));
        endereco3.setResidenciaPropria(true);

        var cliente1 = new Cliente("João da Silva");
        var cliente2 = new Cliente("Sebastião Coelho", endereco1);
        var cliente3 = new Cliente("Manoel Filho", endereco2);
        var cliente4 = new Cliente("Maria da Silva", endereco3);

        var clientes = Arrays.asList(cliente1, cliente2, cliente3, cliente4);
        clientes.forEach( cliente -> {
            try {
                System.out.println(obterNomeCidadeResidenciaPropria(cliente));
            } catch (TipoDeResidenciaInvalidaException e){
                System.out.println(e.getMessage());
            }
        });

//        System.out.println(obterNomeCidadeResidenciaPropria(cliente1));
//        System.out.println(obterNomeCidadeResidenciaPropria(cliente2));
//        System.out.println(obterNomeCidadeResidenciaPropria(cliente3));
//        System.out.println(obterNomeCidadeResidenciaPropria(cliente4));
    }


    private static String obterNomeCidadeResidenciaPropria(Cliente cliente) {
        // TODO melhorar este método usando Optional
//        Objects.requireNonNull(cliente);
//
//        Endereco endereco = cliente.getEndereco();
//        Cidade cidade = null;
//
//        if (endereco != null && endereco.isResidenciaPropria()) {
//            cidade = endereco.getCidade();
//        }
//
//        if (cidade != null) {
//            return cidade.nome();
//        }
//
//        throw new TipoDeResidenciaInvalidaException();

        return Optional.ofNullable(cliente)
                .flatMap(Cliente::getEndereco)
                .filter(Endereco::isResidenciaPropria)
                .flatMap(Endereco::getCidade)
                .map(Cidade::nome)
                .orElseThrow(() -> new TipoDeResidenciaInvalidaException("sem residencia própria"));
    }
}
