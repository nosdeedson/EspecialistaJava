package com.br.ejs.Optional.ciaaerea;

import java.util.List;
import java.util.stream.Collectors;

public class Principal {

    public static void main(String[] args) {

        var servicoDeReserva = new ServicoDeReserva();
        var servicoDeBagagem = new ServicoDeBagagem(servicoDeReserva);
        var voo = new Voo("G31333", "UDI", "GRU");

        servicoDeReserva.adicionar(new Reserva("28A888", voo, "João da Silva"));
        servicoDeReserva.adicionar(new Reserva("28B111", voo, "Maria da Silva"));
        servicoDeReserva.adicionar(new Reserva("74F877", voo, "Sebastião Coelho"));

        servicoDeReserva.adicionar(new Reserva("28C222", voo, "Maria da Souza"));
        servicoDeReserva.adicionar(new Reserva("74F866", voo, "Sebastião Ribeiro"));

        servicoDeBagagem.contratar("28A888", 2);
        adicionarBagagensTest("74F877", servicoDeReserva);
        adicionarBagagensTest("28Baaa", servicoDeReserva);

        try {
            Reserva reserva = pegarReserva("28A888", servicoDeReserva);
            System.out.println(reserva);
            System.lineSeparator();
        } catch (ReservaNaoEncontradaException e){
            System.out.println(e.getMessage());
        }

        try {
            pegarReserva("28ssss", servicoDeReserva);
        } catch (ReservaNaoEncontradaException e){
            System.out.println(e.getMessage());
        }

        Passageiro passageiro = pegarPassageiroReserva("74F877", servicoDeReserva);
        System.out.println(passageiro);
        System.lineSeparator();

        pegarCodigoReservasComBagagens(servicoDeReserva).forEach(codigo -> {
            Reserva reserva = servicoDeReserva.buscar(codigo)
                    .orElseThrow(RuntimeException::new);
            System.out.println(reserva);
        });
        System.out.println("Antes de imprimir --------------------");
        imprimirReservas(servicoDeReserva);

    }

    public static List<String> pegarCodigoReservasComBagagens(ServicoDeReserva servicoDeReserva){
        return servicoDeReserva.getReservas().stream()
                .filter(reserva -> reserva.getQuantidadeBagagens() > 0)
                .map(Reserva::getCodigo)
                .collect(Collectors.toList());
    }

    // map receive a Function (FunctionalInterface), which receive a value and return an object
    public static Passageiro pegarPassageiroReserva(String codigo, ServicoDeReserva servicoDeReserva){
        return servicoDeReserva.buscar(codigo)
                .map(Reserva::getPassageiro)
                .orElseThrow();
    }


    public static Reserva pegarReserva(String codigo, ServicoDeReserva servicoDeReserva){
        return servicoDeReserva.buscar(codigo)
                .filter(reserva -> reserva.getQuantidadeBagagens() > 0)
                .orElseThrow(() -> new ReservaNaoEncontradaException("Reserva não encontrada"));
    }

    public static  void adicionarBagagensTest(String codigo, ServicoDeReserva servicoDeReserva){
        servicoDeReserva.buscar(codigo)
                .ifPresent(reserva -> reserva.adicionarBagagens(10));
    }
    public static void imprimirReservas(ServicoDeReserva servicoDeReserva){
        servicoDeReserva.getReservas().forEach(System.out::println);
    }
}
