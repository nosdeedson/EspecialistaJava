package com.br.ejs.enumeracoes;

public class NotaFiscalDTO {

    private Integer numero;
    private   String descricao;
    private  double valor;

    public TipoNotaFiscal tipoNota;

    public NotaFiscalDTO(Integer numero, String descricao, double valor, TipoNotaFiscal tipoNota) {
        this.numero = numero;
        this.descricao = descricao;
        this.valor = valor;
        this.tipoNota = tipoNota;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public TipoNotaFiscal getTipoNota() {
        return tipoNota;
    }

    public void setTipoNota(TipoNotaFiscal tipoNota) {
        this.tipoNota = tipoNota;
    }
}
