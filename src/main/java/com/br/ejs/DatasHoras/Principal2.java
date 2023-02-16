package com.br.ejs.DatasHoras;

import java.time.Instant;
import java.util.Calendar;
import java.util.Date;

public class Principal2 {

    public static void main(String[] args) {
        Instant instant = Instant.now();
        Date data = Date.from(instant);
        System.out.println(data);
        System.out.println(instant);

        System.out.println("another way around");

        Date date = new Date();
        Instant instant1 = date.toInstant();
        System.out.println(date);
        System.out.println(instant1);

        System.out.println("using Calendar");
        Calendar calendar = Calendar.getInstance();
        Instant instant2 = calendar.toInstant();

        System.out.println(calendar.getTime());
        System.out.println(instant2);
    }
}
