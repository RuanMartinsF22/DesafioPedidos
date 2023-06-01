package DesafioPedidos;

public class PedidoOnline extends Pedido {
    private String endereco;

    public PedidoOnline(String id, String nomeCliente, String descricao, double valor, String endereco) {
        super(id, nomeCliente, descricao, valor);
        this.endereco = endereco;
    }

    // Adiciona um método para obter o endereço
    public String getEndereco() {
        return endereco;
    }

    // Adiciona um método para definir o endereço
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    // Sobrescreve o método fazer() para incluir a entrega
    @Override
    public void fazer() {
        super.fazer();
        System.out.println("O pedido será entregue no endereço: " + endereco);
    }
}
