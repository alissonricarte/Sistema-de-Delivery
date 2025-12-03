package main.java.models.abstratos;

public abstract class Produto {
    private String nome;
    private double preco;

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
    if (preco > 0) {
        this.preco = preco;
    } else {
        System.out.println("Preço inválido! O valor não pode ser negativo.");
    }
}


    public abstract void exibirDetalhes();
}
