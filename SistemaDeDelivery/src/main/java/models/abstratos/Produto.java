package main.java.models.abstratos;

public abstract class Produto {
    private String nome;
    private double preco;

    public Produto(String nome, double preco){
        setNome(nome);
        setPreco(preco);
    }

    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setNome(String nome) {
        if (nome == null || nome.trim().isEmpty())
            throw new IllegalArgumentException("Nome do produto não pode ser vazio.");
        this.nome = nome.trim();
    }

    
    public void setPreco(double preco) {
        if (preco <= 0)
            throw new IllegalArgumentException("Preço deve ser maior que zero.");
        this.preco = preco;
    }

    public abstract void exibirDetalhes();
}
