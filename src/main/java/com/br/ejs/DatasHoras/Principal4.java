package com.br.ejs.DatasHoras;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class Principal4 {
    public static void main(String[] args) {
        LocalDateTime agora = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss:SS");
        System.out.println(agora.format(formatter));
        System.out.println(agora.minus(3, ChronoUnit.CENTURIES).format(formatter));
        System.out.println(agora.minus(3, ChronoUnit.DAYS).format(formatter));
        System.out.println(agora.minus(3, ChronoUnit.MONTHS).format(formatter));
        ////////////plus
        System.out.println(agora.plus(13, ChronoUnit.DAYS).format(formatter));
        LocalDateTime meiaNoite = LocalDateTime.now().MAX;
        System.out.println(meiaNoite.format(formatter));

        System.out.println(LocalDateTime.MAX);
        System.out.println(LocalTime.MAX);
        System.out.println(LocalDate.MAX);

        meiaNoite = LocalDateTime.of(LocalDateTime.now().getYear(),
                LocalDateTime.now().getMonth(),
                LocalDateTime.now().getDayOfMonth(),
                LocalTime.MAX.getHour(),
                LocalTime.MAX.getHour(),
                LocalTime.MAX.getMinute(),
                LocalTime.MAX.getSecond());
        System.out.println(meiaNoite.format(formatter));

        meiaNoite = LocalDateTime.of(LocalDate.now(), LocalTime.MIDNIGHT);
        System.out.println("bom dia meia noite");
        LocalDateTime bomDia = LocalDateTime.of(LocalDate.now(), LocalTime.NOON);
        System.out.println(meiaNoite.format(formatter));
        System.out.println(bomDia.format(formatter));

    }
}
