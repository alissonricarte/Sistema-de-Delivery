package main.java.models.produtos;

import main.java.models.abstratos.Produto;
import main.java.utils.InputHelper;

public class Bebida extends Produto {
    private String tamanho;

    public Bebida(String nome, double preco, String tamanho){
        super(nome, preco);
        this.tamanho = tamanho;
    }

    public String getTamanho() {
        return tamanho;
    }
    public void setTamanho(String tamanho) {
        this.tamanho = tamanho;
    }

    @Override
    public void exibirDetalhes() {
        System.out.println("===Bebida===");
        InputHelper.exbirDadosProduto(this);
        System.out.println("Tamanho: "+getTamanho());
    }
}
