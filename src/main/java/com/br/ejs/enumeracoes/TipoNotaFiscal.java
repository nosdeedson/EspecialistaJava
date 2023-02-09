package com.br.ejs.enumeracoes;

public enum TipoNotaFiscal {

    SERVICO{
        @Override
        public NotaFiscal instanciarNotaFiscal(NotaFiscalDTO dto) {
            return new NotaFiscalServico(dto.getNumero(), dto.getDescricao(), dto.getValor(), this);
        }
    },
    PRODUTO{
        @Override
        public NotaFiscal instanciarNotaFiscal(NotaFiscalDTO dto) {
            return new NotaFiscalProduto(dto.getNumero(), dto.getDescricao(), dto.getValor(), this);
        }
    };

    public abstract NotaFiscal instanciarNotaFiscal(NotaFiscalDTO dto);
}
