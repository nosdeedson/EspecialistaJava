package com.br.ejs.varargs;

public class CalculaMedia {

    public double calculaMedia(double operando1, double operando2, double... outrosValores){
        double media = 0;
        if(outrosValores.length > 0){
            for (int i = 0; i < outrosValores.length; i++) {
                media += outrosValores[i];
            }
            media += operando1;
            media += operando2;
            media = media / (outrosValores.length + 2);
        }else {
            media = (operando1 + operando2) / 2;
        }
        return media;
    }

    public double calculaMedia(double operando1, double operando2, Valor... outrosValores){
        double media = 0;
        if(outrosValores.length > 0){
            for (int i = 0; i < outrosValores.length; i++) {
                media += outrosValores[i].getValor();
            }
            media += operando1;
            media += operando2;
            media = media / (outrosValores.length + 2);
        }else {
            media = (operando1 + operando2) / 2;
        }
        return media;
    }
}
