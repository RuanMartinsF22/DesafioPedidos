package DesafioPedidos;

import javax.swing.JOptionPane;

public class RestauranteOnline {

    public static void main(String[] args) {
        Restaurante restaurante = new Restaurante();
        String nomeClienteOnline = "";
        do {
            nomeClienteOnline = JOptionPane.showInputDialog("Informe o nome do cliente para o pedido online: ");
            if (nomeClienteOnline == null) {
                JOptionPane.showMessageDialog(null, "Execução cancelada. O programa será encerrado.");
                System.exit(0);
            }
            if (nomeClienteOnline.trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Atenção! O campo não foi preenchido. Tente novamente.");
            }
        } while (nomeClienteOnline.trim().isEmpty());

        String enderecoCliente = "";
        do {
            enderecoCliente = JOptionPane.showInputDialog("Informe o endereço de entrega: ");
            if (enderecoCliente == null) {
                JOptionPane.showMessageDialog(null, "Execução cancelada. O programa será encerrado.");
                System.exit(0);
            }
            if (enderecoCliente.trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Atenção! O campo não foi preenchido. Tente novamente.");
            }
        } while (enderecoCliente.trim().isEmpty());

        double valorOnline = 0;
        boolean valorValido = false;
        do {
            String valorStrOnline = JOptionPane.showInputDialog("Informe o valor do pedido online: ");
            if (valorStrOnline == null) {
                JOptionPane.showMessageDialog(null, "Execução cancelada. O programa será encerrado.");
                System.exit(0);
            }
            try {
                valorOnline = Double.parseDouble(valorStrOnline);
                valorValido = true;
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Atenção! Você deve inserir um valor numérico válido. Tente novamente.");
            }
        } while (!valorValido);

        String mensagem = "Nome: " + nomeClienteOnline + "\nEndereço: " + enderecoCliente + "\nValor: R$ " + valorOnline;
        JOptionPane.showMessageDialog(null, mensagem);

        PedidoOnline pedido1 = new PedidoOnline("1", nomeClienteOnline, "pedido online", valorOnline, enderecoCliente);
        restaurante.adicionarPedido(pedido1);
        pedido1.fazer();
        pedido1.concluir();

        String idPedidoRemover = JOptionPane.showInputDialog("Informe o ID do pedido a ser removido: ");
        restaurante.removerPedido(idPedidoRemover);
    }
}

