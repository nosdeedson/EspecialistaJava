package com.br.ejs.APIreflection.geradorCSV;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class GeradorCSV {

    public static <T> void imprimir(Class<T> clazz, List<T> list){
        Field[] fields = clazz.getDeclaredFields();

        System.out.println(Arrays.stream(fields)
                .map(Field::getName)
                .collect(Collectors.toList()));

        list.forEach(GeradorCSV::imprimir);
    }

    private static void imprimir(Object obj){
        Field[] fields = obj.getClass().getDeclaredFields();
        List<String> valoresDosAtributos = new ArrayList<>(obj.getClass().getFields().length);
        try {
            for (Field field: fields){
                field.setAccessible(true);
                Object result = field.get(obj);
                valoresDosAtributos.add(result == null ? "" : result.toString());
            }
            System.out.println(String.join(";", valoresDosAtributos));
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
}
