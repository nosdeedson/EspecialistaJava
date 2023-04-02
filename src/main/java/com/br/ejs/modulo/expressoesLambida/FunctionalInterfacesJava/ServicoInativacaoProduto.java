package com.br.ejs.modulo.expressoesLambida.FunctionalInterfacesJava;

public class ServicoInativacaoProduto {

    public void processar(Produto produto) {
        System.out.println("Inativando " + produto.getNome());
        produto.inativar();
    }

    public static void processarStaticamente(Produto produto){
        System.out.println("Ativando " + produto.getNome());
        produto.ativar();
    }
}
