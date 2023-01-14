package com.br.ejs.herancaProblemaCorrecao.problema;

import com.br.ejs.herancaProblemaCorrecao.NoteBook;

public abstract class Locacao {

     public Locacao(NoteBook noteBook) {
          this.noteBook = noteBook;
     }

     private NoteBook noteBook;

     public abstract double calcularValorDevido(int horasUtilizadas);

     public NoteBook getNoteBook() {
          return noteBook;
     }
}
