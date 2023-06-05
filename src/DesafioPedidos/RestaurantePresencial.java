package DesafioPedidos;

import javax.swing.JOptionPane;
import java.util.Map;
import java.util.Scanner;

public class RestaurantePresencial {

    public static void main(String[] args) {
        Restaurante restaurante = new Restaurante();
        String option = "";

        while (!option.equals("5")) {
            option = JOptionPane.showInputDialog("Selecione uma opção: \n1. Adicionar pedido\n2. Atualizar pedido\n3. Remover pedido\n4. Ver todos os pedidos\n5. Sair");
            if (option == null || option.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Saindo do programa...");
                System.exit(0);
            }

            switch (option) {
                case "1":
                    adicionarPedido(restaurante);
                    break;
                case "2":
                    atualizarPedido(restaurante);
                    break;
                case "3":
                    removerPedido(restaurante);
                    break;
                case "4":
                    verTodosPedidos(restaurante);
                    break;
                case "5":
                    JOptionPane.showMessageDialog(null, "Saindo do programa...");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opção inválida. Tente novamente.");
                    break;
            }
        }
        System.exit(0);
    }

    private static void adicionarPedido(Restaurante restaurante) {
        mesaCliente(); // Chama o método para o cliente escolher a mesa

        String nomeClientePresencial = solicitaInformacao("Informe o nome do cliente para o pedido presencial: ");
        nomeClientePresencial = corrigirNome(nomeClientePresencial); // Corrigir o nome para que a primeira letra seja maiúscula
        while (nomeClientePresencial.matches(".*\\d.*")) {
            JOptionPane.showMessageDialog(null, "Erro: o nome não pode conter números. Tente novamente.");
            nomeClientePresencial = solicitaInformacao("Informe o nome do cliente para o pedido presencial: ");
            nomeClientePresencial = corrigirNome(nomeClientePresencial);
        }

        String localCliente = "Mesa " + mesaEscolhida; // Utiliza a mesa escolhida pelo cliente
        String tipoComida = solicitaInformacaoTipoComida("Informe o tipo de comida desejada: "); // Utiliza um novo método para solicitar o tipo de comida
        double valorPresencial = solicitaValor("Informe o valor do pedido presencial: ");
        String idPedido = solicitaInformacao("Informe o ID do pedido: ");

        PedidoPresencial pedido = new PedidoPresencial(idPedido, nomeClientePresencial, "pedido presencial", valorPresencial, localCliente);
        pedido.setTipoComida(tipoComida); // Define o tipo de comida no pedido
        restaurante.adicionarPedido(pedido);
        pedido.fazer();
        pedido.concluir();

        String mensagemPresencial = "Pedido adicionado com sucesso! \nNome: " + nomeClientePresencial + "\nLocal: " + localCliente + "\nTipo de Comida: " + tipoComida + "\nValor: R$ " + valorPresencial;
        JOptionPane.showMessageDialog(null, mensagemPresencial);
    }

    private static int mesaEscolhida; // Variável para armazenar a mesa escolhida pelo cliente
    private static boolean[] mesasOcupadas = new boolean[5]; // Adicione este campo à sua classe

    public static void mesaCliente() {
        String[] opcoesMesa = { "1", "2", "3", "4", "5" };

        int escolha2 = JOptionPane.showOptionDialog(null, "Escolha sua mesa", "Mesa do Cliente", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, opcoesMesa, opcoesMesa[0]);

        if (escolha2 != JOptionPane.CLOSED_OPTION) {
            if (mesasOcupadas[escolha2]) { // Se a mesa já está ocupada
                JOptionPane.showMessageDialog(null, "Desculpe, mas a mesa " + (escolha2 + 1) + " já está ocupada. Escolha uma mesa diferente.");
                mesaCliente(); // Permitir que o cliente escolha novamente
                return;
            }

            mesaEscolhida = escolha2 + 1; // Atualiza a mesa escolhida
            mesasOcupadas[escolha2] = true; // Marca a mesa como ocupada
            JOptionPane.showMessageDialog(null, "Muito bem, você será atendido pela " + atendenteMesa(mesaEscolhida) + ". Qualquer coisa, só chamar! ;D");
        } else {
            JOptionPane.showMessageDialog(null, "Saindo do programa...");
            System.exit(0);
        }
    }

    private static String atendenteMesa(int mesa) {
        switch (mesa) {
            case 1:
                return "Ana";
            case 2:
                return "Gabi";
            case 3:
                return "Daniel";
            case 4:
                return "Felipe";
            case 5:
                return "Maria";
            default:
                return "";
        }
    }

    private static String solicitaInformacaoTipoComida(String mensagem) {
        String tipoComida = "";
        do {
            tipoComida = JOptionPane.showInputDialog(mensagem);
            if (tipoComida == null) {
                JOptionPane.showMessageDialog(null, "Execução cancelada. O programa será encerrado.");
                System.exit(0);
            }
            if (tipoComida.trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Atenção! O campo não foi preenchido. Tente novamente.");
            } else if (tipoComida.matches(".*\\d.*")) {
                JOptionPane.showMessageDialog(null, "Erro: o tipo de comida não pode conter números. Tente novamente.");
            }
        } while (tipoComida.trim().isEmpty() || tipoComida.matches(".*\\d.*"));
        return tipoComida;
    }

    private static String corrigirNome(String nome) {
        String[] partesNome = nome.trim().split(" ");
        StringBuilder nomeCorrigido = new StringBuilder();

        for (String parte : partesNome) {
            if (!parte.isEmpty()) {
                parte = parte.substring(0, 1).toUpperCase() + parte.substring(1).toLowerCase();
                nomeCorrigido.append(parte).append(" ");
            }
        }

        return nomeCorrigido.toString().trim();
    }

    private static void atualizarPedido(Restaurante restaurante) {
        String idPedido = solicitaInformacao("Informe o ID do pedido a ser atualizado: ");
        Pedido pedido = restaurante.getPedido(idPedido);

        if (pedido != null) {
            String novoNomeCliente = solicitaInformacao("Informe o novo nome do cliente: ");
            double novoValor = solicitaValor("Informe o novo valor do pedido: ");
            pedido.atualizar(novoNomeCliente, novoValor);
        } else {
            JOptionPane.showMessageDialog(null, "Pedido não encontrado.");
        }
    }

    private static void removerPedido(Restaurante restaurante) {
        String idPedido = solicitaInformacao("Informe o ID do pedido a ser removido: ");
        Pedido pedido = restaurante.getPedido(idPedido);
        if (pedido != null) {
            if (pedido instanceof PedidoPresencial) {
                int mesa = ((PedidoPresencial) pedido).getMesa() - 1;
                mesasOcupadas[mesa] = false; // Marca a mesa como livre novamente
            }
            restaurante.removerPedido(idPedido);
        }
    }

    private static void verTodosPedidos(Restaurante restaurante) {
        Map<String, Pedido> pedidos = restaurante.getPedidos();
        StringBuilder pedidosStr = new StringBuilder();

        for (Map.Entry<String, Pedido> entry : pedidos.entrySet()) {
            Pedido pedido = entry.getValue();
            pedidosStr.append("\nID: ").append(pedido.getId())
                    .append("\nNome do Cliente: ").append(pedido.getNomeCliente())
                    .append("\nValor: ").append(pedido.getValor())
                    .append("\n\n");
        }

        JOptionPane.showMessageDialog(null, pedidosStr.toString());
    }

    private static String solicitaInformacao(String mensagem) {
        String informacao = "";
        do {
            informacao = JOptionPane.showInputDialog(mensagem);
            if (informacao == null) {
                JOptionPane.showMessageDialog(null, "Execução cancelada. O programa será encerrado.");
                System.exit(0);
            }
            if (informacao.trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Atenção! O campo não foi preenchido. Tente novamente.");
            }
        } while (informacao.trim().isEmpty());
        return informacao;
    }

    private static double solicitaValor(String mensagem) {
        double valor = 0;
        boolean valorValido = false;
        do {
            String valorStr = JOptionPane.showInputDialog(mensagem);
            if (valorStr == null) {
                JOptionPane.showMessageDialog(null, "Execução cancelada. O programa será encerrado.");
                System.exit(0);
            }
            try {
                valor = Double.parseDouble(valorStr);
                valorValido = true;
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Atenção! Você deve inserir um valor numérico válido. Tente novamente.");
            }
        } while (!valorValido);
        return valor;
    }
}

