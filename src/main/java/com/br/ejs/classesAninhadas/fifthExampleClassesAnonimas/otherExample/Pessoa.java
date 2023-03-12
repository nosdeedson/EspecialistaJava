package com.br.ejs.classesAninhadas.fifthExampleClassesAnonimas.otherExample;

public abstract class Pessoa {

    private String nome;
    protected String documento;

    public Pessoa(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDocumento() {
        return documento;
    }

    abstract void setDocumento(String documento);

    abstract void printingPessoa();

    @Override
    public String toString() {
        return "Pessoa{" +
                "nome='" + nome + '\'' +
                ", documento='" + documento + '\'' +
                '}';
    }
}
