package DesafioPedidos;

import javax.swing.JOptionPane;

public class RestaurantePresencial {

    public static void main(String[] args) {
        Restaurante restaurante = new Restaurante();
        String nomeClientePresencial = "";
        do {
            nomeClientePresencial = JOptionPane.showInputDialog("Informe o nome do cliente para o pedido presencial: ");
            if (nomeClientePresencial == null) {
                JOptionPane.showMessageDialog(null, "Execução cancelada. O programa será encerrado.");
                System.exit(0);
            }
            if (nomeClientePresencial.trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Atenção! O campo não foi preenchido. Tente novamente.");
            }
        } while (nomeClientePresencial.trim().isEmpty());

        String localCliente = "";
        do {
            localCliente = JOptionPane.showInputDialog("Informe o local do cliente (ex: Mesa 4): ");
            if (localCliente == null) {
                JOptionPane.showMessageDialog(null, "Execução cancelada. O programa será encerrado.");
                System.exit(0);
            }
            if (localCliente.trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Atenção! O campo não foi preenchido. Tente novamente.");
            }
        } while (localCliente.trim().isEmpty());

        double valorPresencial = 0;
        boolean valorValido = false;
        do {
            String valorStrPresencial = JOptionPane.showInputDialog("Informe o valor do pedido presencial: ");
            if (valorStrPresencial == null) {
                JOptionPane.showMessageDialog(null, "Execução cancelada. O programa será encerrado.");
                System.exit(0);
            }
            try {
                valorPresencial = Double.parseDouble(valorStrPresencial);
                valorValido = true;
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Atenção! Você deve inserir um valor numérico válido. Tente novamente.");
            }
        } while (!valorValido);

        String mensagemPresencial = "Nome: " + nomeClientePresencial + "\nLocal: " + localCliente + "\nValor: R$ " + valorPresencial;
        JOptionPane.showMessageDialog(null, mensagemPresencial);

        PedidoPresencial pedido2 = new PedidoPresencial("2", nomeClientePresencial, "pedido presencial", valorPresencial, localCliente);
        restaurante.adicionarPedido(pedido2);
        pedido2.fazer();
        pedido2.concluir();

        String idPedidoRemover = JOptionPane.showInputDialog("Informe o ID do pedido a ser removido: ");
        restaurante.removerPedido(idPedidoRemover);
    }
}


