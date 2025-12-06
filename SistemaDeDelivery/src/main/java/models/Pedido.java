package main.java.models;

import main.java.models.usuarios.Cliente;
import main.java.models.usuarios.Entregador;

import java.util.ArrayList;
import java.util.List;

public class Pedido {

    private String descricao;
    private Cliente cliente;
    private Entregador entregador;

    private List<ItemPedido> itens = new ArrayList<>();

    public Pedido(String descricao, Cliente cliente, Entregador entregador) {

        if (descricao == null || descricao.trim().isEmpty()) {
            throw new IllegalArgumentException("A descrição do pedido não pode ser vazia.");
        }

        if (cliente == null) {
            throw new IllegalArgumentException("O pedido deve estar associado a um cliente.");
        }

        if (entregador == null) {
            throw new IllegalArgumentException("O pedido deve estar associado a um entregador.");
        }

        this.descricao = descricao.trim();
        this.cliente = cliente;
        this.entregador = entregador;
    }

    // ======================================
    // GETTERS
    // ======================================

    public String getDescricao() {
        return descricao;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Entregador getEntregador() {
        return entregador;
    }

    public List<ItemPedido> getItens() {
        return itens;
    }

    // ======================================
    // MANIPULAÇÃO DOS ITENS
    // ======================================

    public void adicionarItem(ItemPedido item) {
        if (item == null) {
            throw new IllegalArgumentException("Item não pode ser nulo.");
        }
        itens.add(item);
    }

    // ======================================
    // CÁLCULO DO TOTAL
    // ======================================

    public double getTotal() {
        return itens.stream()
                .mapToDouble(ItemPedido::getSubtotal)
                .sum();
    }

    // ======================================
    // EXIBIÇÃO
    // ======================================

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();
        sb.append("\n=== PEDIDO ===\n");
        sb.append("Descrição: ").append(descricao).append("\n");
        sb.append("Cliente: ").append(cliente.getNome()).append("\n");
        sb.append("Entregador: ").append(entregador.getNome()).append("\n");
        sb.append("Itens:\n");

        for (ItemPedido item : itens) {
            sb.append("  - ").append(item).append("\n");
        }

        sb.append("TOTAL: R$ ").append(String.format("%.2f", getTotal()));

        return sb.toString();
    }
}
