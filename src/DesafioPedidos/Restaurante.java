package DesafioPedidos;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Restaurante {

    private Map<String, Pedido> pedidos;

    public Restaurante() {
        this.pedidos = new HashMap<>();
    }

    public void adicionarPedido(Pedido pedido) {
        if(pedido != null && pedido.getId() != null) {
            pedidos.put(pedido.getId(), pedido);
            System.out.println("Pedido " + pedido.getId() + " adicionado.");
        } else {
            System.out.println("Não foi possível adicionar o pedido. Verifique se o pedido e o ID do pedido são válidos.");
        }
    }

    public void removerPedido(String id) {
        if(pedidos.containsKey(id)) {
            pedidos.remove(id);
            System.out.println("Pedido " + id + " removido.");
        } else {
            System.out.println("Não foi possível remover o pedido. O pedido com o ID " + id + " não existe.");
        }
    }

    public Pedido getPedido(String id) {
        if(pedidos.containsKey(id)) {
            return pedidos.get(id);
        } else {
            System.out.println("Pedido com o ID " + id + " não encontrado.");
            return null;
        }
    }

    public Map<String, Pedido> getPedidos() {
        return pedidos;
    }

    public List<Pedido> listarTodosPedidos() {
        return new ArrayList<>(pedidos.values());
    }

    public void registrarPagamento(String id) {
        Pedido pedido = getPedido(id);
        if (pedido != null) {
            pedido.registrarPagamento();
        } else {
            System.out.println("Pedido não encontrado.");
        }
    }

    public void concluirPedido(String id) {
        Pedido pedido = getPedido(id);
        if (pedido != null) {
            pedido.concluir();
        } else {
            System.out.println("Pedido não encontrado.");
        }
    }

    public void fazerPedido(String id) {
        Pedido pedido = getPedido(id);
        if (pedido != null) {
            pedido.fazer();
        } else {
            System.out.println("Pedido não encontrado.");
        }
    }

    public void cancelarPedido(String id) {
        Pedido pedido = getPedido(id);
        if (pedido != null) {
            pedido.cancelar();
        } else {
            System.out.println("Pedido não encontrado.");
        }
    }

    public void realizarEntrega(String id) {
        PedidoOnline pedido = (PedidoOnline) getPedido(id);
        if (pedido != null) {
            System.out.println("Entrega do pedido " + pedido.getId() + " realizada para o endereço: " + pedido.getEndereco());
        } else {
            System.out.println("Pedido não encontrado ou não é um pedido online.");
        }
    }

    public void realizarRetirada(String id) {
        PedidoPresencial pedido = (PedidoPresencial) getPedido(id);
        if (pedido != null) {
            System.out.println("Pedido " + pedido.getId() + " retirado no restaurante.");
        } else {
            System.out.println("Pedido não encontrado ou não é um pedido presencial.");
        }
    }
}
