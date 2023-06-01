package DesafioPedidos;

public class PedidoPresencial extends Pedido {

    private String mesa;

    public PedidoPresencial(String id, String nomeCliente, String descricao, double valor, String mesa) {
        super(id, nomeCliente, descricao, valor);
        this.mesa = mesa;
    }
}