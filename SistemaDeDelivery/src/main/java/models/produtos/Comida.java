package main.java.models.produtos;

import main.java.models.abstratos.Produto;
import main.java.utils.InputHelper;

public class Comida extends Produto {
    private String tipo;

    public Comida(String nome, double preco, String tipo){
        super(nome, preco);
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public void exibirDetalhes() {
        System.out.println("===Comida===");
        InputHelper.exbirDadosProduto(this);
        System.out.println("Tipo: "+getTipo());
    }
}
