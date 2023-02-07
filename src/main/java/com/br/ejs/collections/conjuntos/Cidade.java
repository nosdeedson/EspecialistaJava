package com.br.ejs.collections.conjuntos;

import java.util.Comparator;
import java.util.Objects;

public class Cidade { // implements Comparable<Cidade> { "this way we have to implemt the method we can create a class to do it"

    private Integer codigoIbge;
    private String nome;
    private int totalHabitantes;

    public Cidade(Integer codigoIbge, String nome, int totalHabitantes) {
        this.codigoIbge = codigoIbge;
        this.nome = nome;
        this.totalHabitantes = totalHabitantes;
    }

    public Integer getCodigoIbge() {
        return codigoIbge;
    }

    public void setCodigoIbge(Integer codigoIbge) {
        this.codigoIbge = codigoIbge;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getTotalHabitantes() {
        return totalHabitantes;
    }

    public void setTotalHabitantes(int totalHabitantes) {
        this.totalHabitantes = totalHabitantes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cidade cidade = (Cidade) o;
        return codigoIbge.equals(cidade.codigoIbge);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigoIbge);
    }

    @Override
    public String toString() {
        return "Cidade{" +
                "codigoIbge=" + codigoIbge +
                ", nome='" + nome + '\'' +
                ", totalHabitantes=" + totalHabitantes +
                '}';
    }

//    @Override
//    public int compareTo(Cidade o) {
//        return Integer.compare(this.codigoIbge, o.codigoIbge);
//    }
}
