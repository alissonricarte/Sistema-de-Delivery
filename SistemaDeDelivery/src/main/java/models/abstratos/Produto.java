package main.java.models.abstratos;

import main.java.Enums.CategoriaProduto;

public abstract class Produto {
    private String nome;
    private double preco;
    private CategoriaProduto categoria;

    public Produto(String nome, double preco){
        this.nome = nome;
        this.preco = preco;
    }

    public String getNome() {
        return nome;
    }
    public double getPreco() {
        return preco;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public void setPreco(double preco) {
        this.preco = preco;
    }

    public abstract void exibirDetalhes();

    public CategoriaProduto getCategoria() { return categoria; }

    public void setCategoria(CategoriaProduto categoria) { this.categoria = categoria; }
}

