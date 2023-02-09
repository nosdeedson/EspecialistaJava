package com.br.ejs.enumeracoes;

public enum Status {

    NAO_EMITIDA("Não emitida", 0){
        @Override
        public boolean naoPodeCancelar(double valor) {
            return false;
        }

        @Override
        public boolean naoPodeEmitir() {
            return false;
        }
    },
    EMITIDA("Emitida", 1){
        @Override
        public boolean naoPodeCancelar(double valor) {
            if ( valor >= 1_000){
                return true;
            }
            return false;
        }

        @Override
        public boolean naoPodeEmitir() {
            return true;
        }
    },
    CANCELADA("Cancelada", 2){
        @Override
        public boolean naoPodeCancelar(double valor) {
                return true;
        }

        @Override
        public boolean naoPodeEmitir() {
            return true;
        }
    };

    private String descricao;
    private Integer codigo;

    public String getDescricao() {
        return descricao;
    }

    public Integer getCodigo() {
        return codigo;
    }

    Status(){}

    Status(String descricao, Integer codigo){
        this.descricao = descricao;
        this.codigo = codigo;
    }

    public abstract boolean naoPodeEmitir();

    public abstract boolean naoPodeCancelar(double valor);
}
