package main.java.models;

import java.util.ArrayList;
import java.util.List;

public class Pedido {

    private String descricao;
    private List<String> itens = new ArrayList<>();

    public Pedido() {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void adicionarItem(String item) {
        itens.add(item);
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
