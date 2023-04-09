package com.br.ejs.Optional.ciaaerea;

import com.br.ejs.Optional.ciaaerea.Reserva;

import java.util.*;

public class ServicoDeReserva {

    private final Set<Reserva> reservas = new HashSet<>();

    public Collection<Reserva> getReservas() {
        return Collections.unmodifiableCollection(reservas);
    }

    public void adicionar(Reserva reserva) {
        boolean reservaAdicionada = reservas.add(reserva);

        if (!reservaAdicionada) {
            throw new RuntimeException(
                    String.format("Reserva %s já existe ", reserva.getCodigo())
            );
        }
    }

    public Optional<Reserva> buscar(String codigo) {
        for( Reserva reserva: reservas){
            if (reserva.getCodigo().equals(codigo)){
                return Optional.of(reserva);
            }
        }
        return Optional.empty();
    }

}
