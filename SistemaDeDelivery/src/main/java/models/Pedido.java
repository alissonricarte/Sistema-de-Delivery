package main.java.models;

import java.util.ArrayList;
import java.util.List;

public class Pedido {

    private String descricao;
    private List<String> itens = new ArrayList<>();

    public Pedido(String descricao) {
        if (descricao == null || descricao.trim().isEmpty()) {
            throw new IllegalArgumentException("A descrição do pedido não pode ser vazia.");
        }
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void adicionarItem(String item) {
        if( item == null) {
            throw new IllegalArgumentException("Item não pode ser nulo.");
        }
        itens.add(item.trim());
    }

    public List<String> getItens() {
        return itens;
    }

    @Override
    public String toString() {
        return "Pedido{" +
                "descricao='" + descricao + '\'' +
                ", itens=" + itens +
                '}';
    }
}
