package com.br.ejs.classesAninhadas.firstExample;

public class Principal {

    public static void main(String[] args) {
        ServicoEmail servicoEmail = new ServicoEmail();

        ServicoEmail.Mensagem mensagem =
                new ServicoEmail.Mensagem("nosdejs32@gmail.com", "josemariazumira@gmail.com", "Olá tudo bem?");

        servicoEmail.enviarEmail(mensagem);
    }
}
