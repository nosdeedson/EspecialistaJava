package com.br.ejs.classesAninhadas.fifthExampleClassesAnonimas.anotherExample;

public class Cliente {

    private String nome;

    public Cliente(String nome) {
        this.nome = nome;
    }

    public void printNome(){
        System.out.println(this.nome);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
