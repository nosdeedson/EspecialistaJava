package com.br.ejs.collections.maps;

import java.util.Comparator;
import java.util.Objects;

public class Cidade implements Comparable<Cidade> {
    private Integer codigoIBGE;
    private String nome;
    private int totalHabitantes;

    public Cidade(Integer codigoIBGE, String nome, int totalHabitantes) {
        this.codigoIBGE = codigoIBGE;
        this.nome = nome;
        this.totalHabitantes = totalHabitantes;
    }

    public Integer getCodigoIBGE() {
        return codigoIBGE;
    }

    public void setCodigoIBGE(Integer codigoIBGE) {
        this.codigoIBGE = codigoIBGE;
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
        return codigoIBGE.equals(cidade.codigoIBGE);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigoIBGE);
    }

    @Override
    public String toString() {
        return "Cidade{" +
                "codigoIBGE=" + codigoIBGE +
                ", nome='" + nome + '\'' +
                ", totalHabitantes=" + totalHabitantes +
                '}';
    }

    @Override
    public int compareTo(Cidade o) {
        return this.getCodigoIBGE().compareTo(o.getCodigoIBGE());
    }
}
