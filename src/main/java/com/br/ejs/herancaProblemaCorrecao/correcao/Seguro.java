package com.br.ejs.herancaProblemaCorrecao.correcao;

public interface Seguro {
    /**
     * Esta interface tem o papel de estipular o contrato de inserção
     * de seguro no aluguel dos notebooks, quando requerido
     */

    double calcularPremio(int horasUtilizadas, double valorContrato);
}
