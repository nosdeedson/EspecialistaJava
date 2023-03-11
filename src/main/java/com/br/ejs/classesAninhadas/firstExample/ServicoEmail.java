package com.br.ejs.classesAninhadas.firstExample;

public class ServicoEmail {

    public void enviarEmail(Mensagem mensagem){
        System.out.printf("Enviando de %s para %s: %s%n",
                mensagem.rementente, mensagem.destinatario, mensagem.texto + gerarAssinatura());
    }

    private static String gerarAssinatura(){
        return "\n--\nEdson José de Souza";
    }

    public record Mensagem(String rementente, String destinatario, String texto) {
    }
}
