package com.br.ejs.desafioInterfaces;

public class Principal {

    public static void main(String[] args) {
        CarroParticular carro = new CarroParticular("Palio", 50000, 2005 );
        CarroParticular carro2 = new CarroParticular("Gol", 35000, 1999 );

        Caminhao caminhao = new Caminhao("1813", 15000, 1985, 3);

        ImovelResidencial imovelResidencial = new ImovelResidencial(200000, 58 );

        ServicoPropostaSegura servicoPropostaSegura = new ServicoPropostaSegura();

        System.out.println("_____________________Imprimindo_____________________");
        servicoPropostaSegura.emitir(caminhao);
        servicoPropostaSegura.emitir(carro2);
        servicoPropostaSegura.emitir(carro);
        servicoPropostaSegura.emitir(imovelResidencial);

    }
}
