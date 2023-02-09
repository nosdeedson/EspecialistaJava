package com.br.ejs.enumeracoes;

public class Principal {

    public static void main(String[] args) {
        // TODO alterar as constantes da classe nota fiscal para enums;
        TipoNotaFiscal tipo = TipoNotaFiscal.PRODUTO;
        Status status = Status.NAO_EMITIDA;
        NotaFiscalDTO dto = new NotaFiscalDTO( 123, "Macbook Pro", 18_000, tipo);
        NotaFiscal nf = tipo.instanciarNotaFiscal(dto);
        System.out.println(nf.getDescricaoCompleta());
        System.out.println("Codigo do status: " + nf.getCodigoStatus());

        nf.emitir();
        System.out.println(nf.getDescricaoCompleta());
        System.out.println("Codigo do status: " + nf.getCodigoStatus());

        nf.cancelar(); // IllegalStateException
        System.out.println(nf.getDescricaoCompleta());
    }
}
