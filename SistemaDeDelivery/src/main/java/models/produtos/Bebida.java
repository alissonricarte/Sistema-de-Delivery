package main.java.models.produtos;

import main.java.models.abstratos.Produto;
import main.java.utils.InputHelper;

public class Bebida extends Produto {
    private String tamanho;

    public Bebida(String nome, double preco, String tamanho){
        super(nome, preco);
        setTamanho(tamanho);
    }

    public String getTamanho() {
        return tamanho;
    }
    public void setTamanho(String tamanho) {
        if (tamanho == null || tamanho.trim().isEmpty())
            throw new IllegalArgumentException("Tamanho não pode ser vazio.");
        this.tamanho = tamanho.trim();
    }


    @Override
    public void exibirDetalhes() {
        System.out.println("===Bebida===");
        InputHelper.exibirDadosProduto(this);
        System.out.println("Tamanho: "+getTamanho());
    }
}
