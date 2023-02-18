package com.br.ejs.DatasHoras;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;

public class Principal3 {

    public static void main(String[] args) {
        LocalDateTime localDateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ISO_DATE_TIME;
        DateTimeFormatter formatter1 = DateTimeFormatter.ISO_LOCAL_DATE;
        DateTimeFormatter formatter2 = DateTimeFormatter
                .ofLocalizedDateTime(FormatStyle.LONG, FormatStyle.SHORT);
        DateTimeFormatter formatter3 = DateTimeFormatter
                .ofLocalizedDateTime(FormatStyle.SHORT, FormatStyle.SHORT);
        DateTimeFormatter formatter4 = DateTimeFormatter
                .ofLocalizedDateTime(FormatStyle.FULL, FormatStyle.SHORT)
                .withLocale(new Locale("pt", "BR"));

        Locale locale = new Locale("pt", "BR");

        DateTimeFormatter formatter5 = DateTimeFormatter
                .ofLocalizedDateTime(FormatStyle.SHORT, FormatStyle.SHORT)
                .withLocale(locale);

        DateTimeFormatter formatter6 = DateTimeFormatter.ofPattern("dd/MM/yyyy", locale);
        DateTimeFormatter formatter7 = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        DateTimeFormatter formatter8 = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss", locale);
        DateTimeFormatter formatter9 = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");


        System.out.println(localDateTime.format(formatter));
        System.out.println(localDateTime.format(formatter1));
        System.out.println(localDateTime.format(formatter2));
        System.out.println(localDateTime.format(formatter3));
        System.out.println(localDateTime.format(formatter4));
        System.out.println(localDateTime.format(formatter5));
        System.out.println(localDateTime.format(formatter6));
        System.out.println(localDateTime.format(formatter7));
        System.out.println(localDateTime.format(formatter8));
        System.out.println(localDateTime.format(formatter9));
    }
}
