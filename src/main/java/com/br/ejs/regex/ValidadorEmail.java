package com.br.ejs.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidadorEmail {

    public static boolean validar(String email){
        String regex = "[a-zA-Z0-9-_\\.]+@[a-z^0-9\\.-]+\\.[a-z]{2,3}";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    public static boolean validarAnotherWay(String email){
        String regex = "[a-zA-Z0-9-_\\.]+@[a-z^0-9\\.-]+\\.[a-z]{2,3}";
        return email.matches(regex);
    }
}
