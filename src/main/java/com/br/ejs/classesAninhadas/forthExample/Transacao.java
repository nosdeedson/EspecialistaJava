package com.br.ejs.classesAninhadas.forthExample;

import java.math.BigDecimal;

public interface Transacao {

    BigDecimal getValorTotal();
    void reembolsar();
}
