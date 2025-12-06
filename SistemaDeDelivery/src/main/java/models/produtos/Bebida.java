package main.java.models.produtos;

import main.java.models.abstratos.Produto;
import main.java.utils.InputHelper;

public class Bebida extends Produto {

    public Bebida(String nome, double preco){
        super(nome, preco);
    }

    @Override
    public void exibirDetalhes() {
        System.out.println("===Bebida===");
        InputHelper.exibirDadosProduto(this);
    }
}
