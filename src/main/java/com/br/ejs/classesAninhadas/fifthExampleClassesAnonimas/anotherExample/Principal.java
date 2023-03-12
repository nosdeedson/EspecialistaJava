package com.br.ejs.classesAninhadas.fifthExampleClassesAnonimas.anotherExample;

public class Principal {

    public static Cliente retornandoClasseAnonima(String nome){
        return new Cliente(nome) {
            @Override
            public void printNome() {
                this.setNome("João souza mostrando qual método foi usado.");
                super.printNome();
            }
        };
    }

    public static void main(String[] args) {
        Cliente c = retornandoClasseAnonima("Edson Jose de Souza");
        c.printNome();
    }
}
