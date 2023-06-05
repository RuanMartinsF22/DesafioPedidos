package DesafioPedidos;

public class PedidoPresencial extends Pedido {
    private  int mesa;

    public PedidoPresencial(String id, String nomeCliente, String descricao, double valor, String localCliente) {
        super(id, nomeCliente, descricao, valor);
        this.mesa = extrairNumeroMesa(localCliente); // Extrai o número da mesa do localCliente
    }

    private int extrairNumeroMesa(String localCliente) {
        // Assume que o formato de localCliente é "Mesa X", onde X é o número da mesa
        try {
            return Integer.parseInt(localCliente.split(" ")[1]);
        } catch (Exception e) {
            return -1; // Retornar um valor inválido se algo der errado
        }
    }

    public int getMesa() {
        return mesa;
    }
    //.

    private String tipoComida;

    public String getTipoComida() {
        return tipoComida;
    }

    public void setTipoComida(String tipoComida) {
        this.tipoComida = tipoComida;
    }
}