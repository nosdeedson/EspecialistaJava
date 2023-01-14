package com.br.ejs.varargs;

public class Principal {

    public static void main(String[] args) {
        CalculaMedia calculaMedia = new CalculaMedia();
        double media = calculaMedia.calculaMedia(2, 2, 3 );
        System.out.println("media: " + media);

        System.out.println("###################################");
        Valor v1 = new Valor();
        v1.setValor(3);
        Valor v2 = new Valor();
        v2.setValor(3);
        media = calculaMedia.calculaMedia(3,3, v1, v2);

        System.out.println("media: " + media);
    }
}
