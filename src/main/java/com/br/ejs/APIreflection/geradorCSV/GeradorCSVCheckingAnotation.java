package com.br.ejs.APIreflection.geradorCSV;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class GeradorCSVCheckingAnotation {

    public static <T> void imprimir(Class<T> clazz, List<T> list){
        Field[] fields = clazz.getDeclaredFields();

        System.out.println(Arrays.stream(fields)
                .filter(f -> f.isAnnotationPresent(Campo.class))
                .map(Field::getName)
                .collect(Collectors.toList()));

        list.forEach(GeradorCSVCheckingAnotation::imprimir);
    }

    private static void imprimir(Object obj){
        Field[] fields = obj.getClass().getDeclaredFields();
        List<String> valoresDosAtributos = new ArrayList<>(obj.getClass().getFields().length);
        try {
            for (Field field: fields){
                if (field.isAnnotationPresent(Campo.class)){
                    Campo campo = field.getAnnotation(Campo.class);
                    field.setAccessible(true);
                    Object result = field.get(obj);
                    if(field.isAnnotationPresent(Campo.class) && campo.maiusculo()){
                        valoresDosAtributos.add(result == null ? "" : result.toString().toUpperCase());
                    }else if( field.isAnnotationPresent(Campo.class)){
                        valoresDosAtributos.add(result == null ? "" : result.toString());
                    }
                }
            }
            System.out.println(String.join(";", valoresDosAtributos));
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
}
