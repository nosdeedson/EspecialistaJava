package com.br.ejs.heranca;

public class Principal {
    public static void main(String[] args) {
        Funcionario f = new Funcionario("jose", 15);
        System.out.println(f.calcularSalario(160));
        System.out.println(f.toString());
        Holerite holerite = f.gerarHolerite(160, "122022");
        holerite.imprimir();

        System.out.println("######################");

        Programador p = new Programador("joão", 25);
        p.setValorBonus(45.0);
        System.out.println(p.calcularSalario(160));
        System.out.println(p.toString());
        Holerite h = p.gerarHolerite(160, "122022");
        h.imprimir();
    }
}
