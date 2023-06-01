package DesafioPedidos;

import java.util.HashMap;
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

}
