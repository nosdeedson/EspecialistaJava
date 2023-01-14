package com.br.ejs.herancaProblemaCorrecao.correcao;

import com.br.ejs.herancaProblemaCorrecao.NoteBook;

import java.util.Optional;

public class Locacao {

    private NoteBook noteBook;

    private Precificacao precificacao;

    private Seguro seguro;

    public Locacao(NoteBook noteBook, Precificacao precificacao, Seguro seguro) {
        this.noteBook = noteBook;
        this.precificacao = precificacao;
        this.seguro = seguro;
    }

    public Locacao(NoteBook noteBook, Precificacao precificacao) {
        this.noteBook = noteBook;
        this.precificacao = precificacao;
    }

    public double calcularValorDevido(int horasUtilizadas){
        double valorDevido = this.precificacao.calcularValorTotal(this.noteBook, horasUtilizadas);
        if(temSeguro()){
            valorDevido += this.seguro.calcularPremio(horasUtilizadas, valorDevido);
        }
        return valorDevido;
    }

    private boolean temSeguro(){
        if(Optional.ofNullable(this.getSeguro()).isPresent()){
            return true;
        }
        return false;
    }

    public Seguro getSeguro() {
        return seguro;
    }

    public NoteBook getNoteBook() {
        return noteBook;
    }
}
