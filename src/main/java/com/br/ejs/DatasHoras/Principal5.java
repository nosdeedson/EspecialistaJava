package com.br.ejs.DatasHoras;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;

public class Principal5 {
    public static void main(String[] args) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss:SS");
        LocalDateTime dia1 = LocalDateTime.parse("30/06/1980 10:10:10:10", formatter);
        LocalDateTime dia2 = LocalDateTime.parse("17/02/2023 21:14:15:14", formatter);

        Period period = Period.between(dia1.toLocalDate(), dia2.toLocalDate());
        Period period1 = dia1.toLocalDate().until(dia2.toLocalDate());
        long anos = dia1.until(dia2, ChronoUnit.YEARS);
        long dias = dia1.until(dia2, ChronoUnit.DAYS);
        long meses = dia1.until(dia2, ChronoUnit.MONTHS);

        System.out.println(dia1.format(formatter));
        System.out.println(dia2);
        System.out.println("anos " + period.getYears());
        System.out.println("dias " + period.getDays());
        System.out.println("anos " + period.getYears());
        System.out.println("anos " + period.getChronology());
        System.out.println("anos " + period1.getYears());
        System.out.println("anos " + anos);
        System.out.println("dia " + dias);
        System.out.println("meses " + meses);

    }
}
