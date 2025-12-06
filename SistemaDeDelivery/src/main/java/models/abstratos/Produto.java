package main.java.models.abstratos;

public abstract class Produto {
    private String nome;
    private double preco;
    private static int cont = 1;
    private int id;

    public Produto(String nome, double preco){
        this.id = cont++;
        setNome(nome);
        setPreco(preco);
    }

    public int getId() {
        return id;
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

    @Override
    public String toString() {
        return "ID: " + id + "\nNome: " + nome + "\nPreço: R$ " + String.format("%.2f", preco);
    }


    public abstract void exibirDetalhes();
}
