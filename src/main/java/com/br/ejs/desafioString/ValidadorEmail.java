package com.br.ejs.desafioString;

import java.util.Arrays;

public class ValidadorEmail {

    public static boolean validar(String email){
        try {
            int indexOfAroba = email.lastIndexOf('@');
            int indexOfDot = email.indexOf('.');
            boolean ok = dontContainArobaOrDot(email);
            ok = doesntHaveSpaceOrIsEmpty(email);
            ok = doesntHaveUserOrDomain(indexOfAroba, email);
            return ok;
        } catch (RuntimeException e){
            return false;
        }
    }

    private static boolean doesntHaveUserOrDomain(int indexAroba, String email){
        String user = email.substring(0, indexAroba);
        String domain = email.substring(indexAroba + 1);
        int indexDot = domain.lastIndexOf(".");
        String category = domain.substring(indexDot + 1);
        domain = domain.substring(0, domain.indexOf("."));
        boolean domainOk = doesntHaveUpperCase(domain);
        domainOk = checkDomain(domain);
        boolean sizeCategory = checkCategoryDomain(category);
        boolean userOk = isDigitOrLetter(user);
        userOk = checkUser(user);
        userOk = isDigitOrLetter(user);
        if( sizeCategory && domainOk && userOk && !user.isEmpty() && !domain.isEmpty()){
            return true;
        }
        return false;
    }

    private static boolean checkUser(String user){
        if(!user.contains("@")){
            return true;
        }
        return false;
    }

    private static boolean checkCategoryDomain(String value){
        boolean categoryHasNumber = checkCategoryDoesntHasNumberAndUpperCase(value);
        if(categoryHasNumber && ( value.length() == 2 || value.length() == 3 )){
            return true;
        }
        return false;
    }

    private static boolean checkCategoryDoesntHasNumberAndUpperCase(String value) {
        for (int i = 0; i < value.length(); i++) {
            char letter = value.charAt(i);
            if(Character.isDigit(letter)){
                return false;
            }
            if(Character.isUpperCase(letter)){
                return false;
            }
        }
        return true;
    }

    private static boolean doesntHaveUpperCase(String value){
        for (int i = 0; i < value.length(); i++) {
            char letter = value.charAt(i);
            if(Character.isUpperCase(letter)){
                return false;
            }
        }
        return true;
    }
    private static boolean isDigitOrLetter(String value){
        boolean charOk = true;
        for (int i = 0; i < value.length(); i++) {
            char letter = value.charAt(i);
            if(Character.isDigit(letter) || Character.isLetter(letter) || letter == '_' || letter == '-' || letter == '.' ){
                continue;
            }
            charOk = false;
        }
        return charOk;
    }

    private static boolean checkDomain(String value){
        boolean charOk = true;
        for (int i = 0; i < value.length(); i++) {
            char letter = value.charAt(i);
            if(!Character.isUpperCase(letter) &&
                    (Character.isDigit(letter) || Character.isLetter(letter) || letter == '_' || letter == '-' )){
                continue;
            }
            charOk = false;
        }
        return charOk;
    }


    private static boolean doesntHaveSpaceOrIsEmpty(String email){
        if(!email.isBlank() && !email.isEmpty() && !email.contains(" ")){
            return true;
        }
        throw new RuntimeException("invalido");
    }

    private static boolean dontContainArobaOrDot(String email){
        if(email.contains("@") && email.contains(".")){
            return true;
        }
        return false;
    }
}
