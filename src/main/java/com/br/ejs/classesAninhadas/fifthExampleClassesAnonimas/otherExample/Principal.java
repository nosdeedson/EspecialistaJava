package com.br.ejs.classesAninhadas.fifthExampleClassesAnonimas.otherExample;

public class Principal {

    public  static Pessoa retornandoClasseAnonima(String nome){
        return new Pessoa("bar do zé"){

            @Override
            void setDocumento(String documento) {
                this.documento = documento;
            }

            @Override
            void printingPessoa() {
                System.out.println(this);
            }
        };
    }

    public static void main(String[] args) {
        Pessoa p = retornandoClasseAnonima("loja do zé");
        p.setDocumento("12345678912");
        p.printingPessoa();
    }
}
