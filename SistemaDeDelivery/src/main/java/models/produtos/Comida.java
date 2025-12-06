package main.java.models.produtos;

import main.java.models.abstratos.Produto;
import main.java.utils.InputHelper;

public class Comida extends Produto {

    public Comida(String nome, double preco, int quantidade){
        super(nome, preco, quantidade);
    }

    @Override
    public void exibirDetalhes() {
        System.out.println("===Comida===");
        InputHelper.exibirDadosProduto(this);
    }
}
