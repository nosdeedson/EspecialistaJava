package com.br.ejs.desafioClassesAninhadas.vendas;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.*;

public class Pedido {

    private final Cliente cliente;
    private StatusPedido status = StatusPedido.RASCUNHO;

    BigDecimal valorTotal = BigDecimal.ZERO;

    private final List<ItemPedido> itens = new ArrayList<>();

    public Pedido(Cliente cliente) {
        this.cliente = cliente;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public StatusPedido getStatus() {
        return status;
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public List<ItemPedido> getItens() {
        return Collections.unmodifiableList(itens);
    }

    public ItemPedido adicionarItem(String descricao, int quantidade, BigDecimal valorUnitario){
        ItemPedido item = new ItemPedido(this, descricao, valorUnitario, quantidade);
        itens.add(item);
        return item;
    }

    public void emitir(){
        checarPedidoParaModificacao();
        status = StatusPedido.EMITIDO;
    }
    
    public void cancelar(){
        checarPedidoParaModificacao();
        status = StatusPedido.CANCELADO;
    }
    
    void checarPedidoParaModificacao() {
        if( !StatusPedido.RASCUNHO.equals(status)){
            throw new IllegalArgumentException(("Pedido não pode ser modificado"));
        }
    }

    public class ItemPedido {

        private Pedido pedido;
        private final String descricao;
        private BigDecimal valorUntiario;
        private  int quantidade;

        public ItemPedido(Pedido pedido, String descricao, BigDecimal valorUntiario, int quantidade) {
            Objects.requireNonNull(pedido);
            Objects.requireNonNull(descricao);
            Objects.requireNonNull(valorUntiario);

            if(valorUntiario.compareTo(BigDecimal.ZERO) < 1){
                throw new IllegalArgumentException("Valor unitário deve ser maior que zero.");
            }

            this.pedido = pedido;
            this.descricao = descricao;
            this.valorUntiario = valorUntiario;
            setQuantidade(quantidade);
        }

        public String getDescricao() {
            return descricao;
        }

        public BigDecimal getValorUntiario() {
            return valorUntiario;
        }

        public void setValorUntiario(BigDecimal valorUntiario) {
            this.valorUntiario = valorUntiario;
        }

        public int getQuantidade() {
            return quantidade;
        }

        public void setQuantidade(int quantidade) {
            pedido.checarPedidoParaModificacao();
            if (quantidade < 1){
                throw  new IllegalArgumentException("Quantidade deve ser maior que zero");
            }
            pedido.valorTotal = pedido.valorTotal.subtract(calcularValorToral(this.quantidade));
            this.quantidade = quantidade;
            pedido.valorTotal = pedido.valorTotal.add(calcularValorToral(quantidade));
        }

        public BigDecimal getValorTotal(){
            return  calcularValorToral(this.quantidade);
        }

        private BigDecimal calcularValorToral(int quantidade){
            return  valorUntiario.multiply(new BigDecimal(quantidade));
        }
    }

    public static final class Imprimi{
        private final static NumberFormat FORMATADOR_MOEDA = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));

        public static void imprimiResumo(Pedido pedido){
            for (ItemPedido item: pedido.getItens()){
                System.out.printf("%dx %s (%s) = %s%n",
                        item.getQuantidade(), item.getDescricao(),
                        FORMATADOR_MOEDA.format(item.getValorUntiario()),
                        FORMATADOR_MOEDA.format(item.getValorTotal()));
            }
        }
    }
}
