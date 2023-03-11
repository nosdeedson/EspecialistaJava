package com.br.ejs.classesAninhadas.secondExample;

import java.util.Comparator;
import java.util.List;

public class Cliente {

    // Status is static by default
    public enum Status{
        ATIVO, BLOQUEADO
    }
    private final String nome;
    private final int idade;

    private Status status;

    public Cliente(String nome, int idade) {
        this.nome = nome;
        this.idade = idade;
        this.status = Status.ATIVO;
    }

    public String getNome() {
        return nome;
    }

    public int getIdade() {
        return idade;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "nome='" + nome + '\'' +
                ", idade=" + idade +
                ", status=" + status +
                '}';
    }

    public static void ordenarPorIdade(List<Cliente> clientes){
        clientes.sort(new IdadeComparator());
    }

    private static class IdadeComparator implements Comparator<Cliente>{

        @Override
        public int compare(Cliente o1, Cliente o2) {
            return Integer.compare(o1.getIdade(), o2.idade);
        }
    }
}
