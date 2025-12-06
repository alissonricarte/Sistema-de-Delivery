package main.java.models;

import java.util.ArrayList;
import java.util.List;

public class Pedido {

    private String descricao;
    private List<ItemPedido> itens = new ArrayList<>();

    public Pedido(String descricao) {
        if (descricao == null || descricao.trim().isEmpty()) {
            throw new IllegalArgumentException("A descrição do pedido não pode ser vazia.");
        }
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void adicionarItem(ItemPedido item) {
        if( item == null) {
            throw new IllegalArgumentException("Item não pode ser nulo.");
        }
        itens.add(item);
    }

    public List<ItemPedido> getItens() {
        return itens;
    }

    public double getTotal() {
        return itens.stream().mapToDouble(ItemPedido::getSubtotal).sum();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n=== ").append(descricao).append(" ===\n");

        for (ItemPedido item : itens) {
            sb.append(item).append("\n");
        }

        sb.append("Total: R$ ").append(String.format("%.2f", getTotal()));

        return sb.toString();
    }
}
