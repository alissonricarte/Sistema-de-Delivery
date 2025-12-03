package main.java.models.produtos;

import main.java.models.abstratos.Produto;
import main.java.utils.InputHelper;

public class Comida extends Produto {
    private String tipo;

    public Comida(String nome, double preco, String tipo){
        super(nome, preco);
        setTipo(tipo);
    }

    public String getTipo() {
        return tipo;
    }
    public void setTipo(String tipo) {
        if (tipo == null || tipo.trim().isEmpty())
            throw new IllegalArgumentException("Tipo não pode ser vazio.");
        this.tipo = tipo.trim();
    }

    @Override
    public void exibirDetalhes() {
        System.out.println("===Comida===");
        InputHelper.exibirDadosProduto(this);
        System.out.println("Tipo: "+getTipo());
    }
}
