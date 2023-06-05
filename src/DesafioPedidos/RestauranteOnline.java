package DesafioPedidos;

import javax.swing.JOptionPane;

public class RestauranteOnline {

    public static void main(String[] args) {
        Restaurante restaurante = new Restaurante();

        while (true) {
            String[] opcoes = {"Novo Pedido", "Atualizar Pedido", "Cancelar Pedido", "Listar Todos Os Pedidos",
                    "Remover Pedido", "Registrar Pagamento", "Concluir Pedido", "Delivery", "Retirada", "Sair"};
            String opcao = (String) JOptionPane.showInputDialog(null, "Selecione a opção:", "Menu", JOptionPane.QUESTION_MESSAGE, null, opcoes, opcoes[0]);

            switch (opcao) {
                case "Novo Pedido":
                    fazerPedidoOnline(restaurante);
                    break;

                case "Atualizar Pedido":
                    atualizarPedidoOnline(restaurante);
                    break;

                case "Cancelar Pedido":
                    cancelarPedidoOnline(restaurante);
                    break;

                case "Listar Todos Os Pedidos":
                    listarPedidos(restaurante);
                    break;

                case "Remover Pedido":
                    removerPedido(restaurante);
                    break;

                case "Registrar Pagamento":
                    registrarPagamento(restaurante);
                    break;

                case "Concluir Pedido":
                    concluirPedido(restaurante);
                    break;

                case "Delivery":
                    fazerEntrega(restaurante);
                    break;

                case "Retirada":
                    retirarPedido(restaurante);
                    break;

                case "Sair":
                    System.exit(0);
                    break;

                default:
                    break;
            }
        }
    }

    private static void fazerPedidoOnline(Restaurante restaurante) {
        String idPedido = JOptionPane.showInputDialog("Informe o ID do pedido: ");
        String nomeCliente = JOptionPane.showInputDialog("Informe o nome do cliente: ");
        String descricao = JOptionPane.showInputDialog("Informe a descrição do pedido: ");
        double valor = Double.parseDouble(JOptionPane.showInputDialog("Informe o valor do pedido: "));
        PedidoOnline pedidoOnline = new PedidoOnline(idPedido, nomeCliente, descricao, valor);
        restaurante.adicionarPedido(pedidoOnline);
    }

    private static void atualizarPedidoOnline(Restaurante restaurante) {
        String idPedido = JOptionPane.showInputDialog("Informe o ID do pedido que deseja atualizar: ");
        String nomeCliente = JOptionPane.showInputDialog("Informe o novo nome do cliente: ");
        double valor = Double.parseDouble(JOptionPane.showInputDialog("Informe o novo valor do pedido: "));
        Pedido pedido = restaurante.getPedido(idPedido);
        if (pedido instanceof PedidoOnline pedidoOnline) {
            pedidoOnline.atualizar(nomeCliente, valor);
        } else {
            JOptionPane.showMessageDialog(null, "Pedido não encontrado ou não é um Pedido Online.");
        }
    }

    private static void cancelarPedidoOnline(Restaurante restaurante) {
        String idPedido = JOptionPane.showInputDialog("Informe o ID do pedido que deseja cancelar: ");
        Pedido pedido = restaurante.getPedido(idPedido);
        if (pedido instanceof PedidoOnline) {
            PedidoOnline pedidoOnline = (PedidoOnline) pedido;
            pedidoOnline.cancelar();
        } else {
            JOptionPane.showMessageDialog(null, "Pedido não encontrado ou não é um Pedido Online.");
        }
    }

    private static void listarPedidos(Restaurante restaurante) {
        for (Pedido pedido : restaurante.getPedidos().values()) {
            System.out.println("ID do pedido: " + pedido.getId());
            System.out.println("Nome do cliente: " + pedido.getNomeCliente());
            System.out.println("Descrição: " + pedido.getDescricao());
            System.out.println("Valor: " + pedido.getValor());
            System.out.println("Pago: " + (pedido.isPago() ? "Sim" : "Não"));
            System.out.println("Concluído: " + (pedido.isConcluido() ? "Sim" : "Não"));
            System.out.println("-----------------------------------");
        }
    }

    private static void removerPedido(Restaurante restaurante) {
        String idPedido = JOptionPane.showInputDialog("Informe o ID do pedido que deseja remover: ");
        restaurante.removerPedido(idPedido);
    }

    private static void registrarPagamento(Restaurante restaurante) {
        String idPedido = JOptionPane.showInputDialog("Informe o ID do pedido que deseja registrar o pagamento: ");
        Pedido pedido = restaurante.getPedido(idPedido);
        if (pedido instanceof PedidoOnline pedidoOnline) {
            pedidoOnline.registrarPagamento();
        } else {
            JOptionPane.showMessageDialog(null, "Pedido não encontrado ou não é um Pedido Online.");
        }
    }

    private static void concluirPedido(Restaurante restaurante) {
        String idPedido = JOptionPane.showInputDialog("Informe o ID do pedido que deseja concluir: ");
        Pedido pedido = restaurante.getPedido(idPedido);
        if (pedido instanceof PedidoOnline pedidoOnline) {
            pedidoOnline.concluir();
        } else {
            JOptionPane.showMessageDialog(null, "Pedido não encontrado ou não é um Pedido Online.");
        }
    }

    private static void fazerEntrega(Restaurante restaurante) {
        String idPedido = JOptionPane.showInputDialog("Informe o ID do pedido que deseja solicitar delivery: ");
        Pedido pedido = restaurante.getPedido(idPedido);
        if (pedido instanceof PedidoOnline pedidoOnline) {
            pedidoOnline.fazer();
        } else {
            JOptionPane.showMessageDialog(null, "Pedido não encontrado ou não é um Pedido Online.");
        }
    }

    private static void retirarPedido(Restaurante restaurante) {
        String idPedido = JOptionPane.showInputDialog("Informe o ID do pedido que será retirado: ");
        Pedido pedido = restaurante.getPedido(idPedido);
        if (pedido instanceof PedidoOnline pedidoOnline) {
            pedidoOnline.retirar();
        } else {
            JOptionPane.showMessageDialog(null, "Pedido não encontrado ou não é um Pedido Online.");
        }
    }
}
