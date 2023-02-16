package com.br.ejs.DatasHoras;

import java.time.Instant;

public class Principal {

    public static void main(String[] args) {
        Instant instant = Instant.now();
        System.out.println(instant);

        System.out.println(instant.getEpochSecond());
        System.out.println(instant.getNano()); // o nano serve como complemento para os segundos,
        // não é os nanos segundos desde 1970
        System.out.println(instant.toEpochMilli());


    }
}
