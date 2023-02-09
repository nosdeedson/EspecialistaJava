package com.br.ejs.enumeracoes;

public abstract class NotaFiscal {

    private Status status;

    private final Integer numero;
    private final String descricao;
    private final  double valor;

    private final TipoNotaFiscal tipoNota;

    public NotaFiscal(Integer numero, String descricao, double valor,TipoNotaFiscal tipo) {
        this.numero = numero;
        this.descricao = descricao;
        this.valor = valor;
        this.status = Status.NAO_EMITIDA;
        this.tipoNota = tipo;
    }

    public NotaFiscal(NotaFiscalDTO dto){
        this(dto.getNumero(), dto.getDescricao(), dto.getValor(), dto.getTipoNota());
    }

    public Integer getNumero() {
        return numero;
    }

    public String getDescricao() {
        return descricao;
    }

    public double getValor() {
        return valor;
    }

    public Status getStatus() {
        return status;
    }

    public TipoNotaFiscal getTipoNota() {
        return tipoNota;
    }

    public void cancelar(){
        if( this.status.naoPodeCancelar(this.valor)){
            throw  new IllegalStateException("não foi possível cancelar a nota fiscal");
        }
        status = Status.CANCELADA;
    }

    public void emitir() {
        if (this.status.naoPodeEmitir()) {
            throw new IllegalStateException("Não foi possível emitir a nota fiscal");
        }
        status = Status.EMITIDA;
    }

    public String getDescricaoCompleta() {
        String descricaoStatus = this.status.getDescricao();

        return String.format("Nota fiscal #%d [do tipo: %s], descrição  (%s) no valor de R$%.2f está %s",
                getNumero(), getTipoNota(), getDescricao(), getValor(), descricaoStatus);
    }

    public Integer getCodigoStatus(){
        return this.status.getCodigo();
    }
}
