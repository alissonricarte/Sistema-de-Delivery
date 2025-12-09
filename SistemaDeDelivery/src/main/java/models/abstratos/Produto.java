package main.java.models.abstratos;

public abstract class Produto {
    private String nome;
    private double preco;
    private int quantidade; 
    private static int cont = 1;
    private int id;

    public Produto(String nome, double preco, int quantidade){
        this.id = cont++;
        setNome(nome);
        setPreco(preco);
        setQuantidade(quantidade); 
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

    public int getQuantidade() {
        return quantidade;
    }

    public void setNome(String nome) {
    if (nome == null || nome.trim().isEmpty()) {
        throw new IllegalArgumentException("[ O nome do produto não pode ser vazio ]");
    }

    nome = nome.trim().replaceAll(" +", " ");

    if (!nome.matches("^[A-Za-zÀ-ÖØ-öø-ÿ0-9()\\-\\/ ]+$")) {
        throw new IllegalArgumentException(
            "O nome do produto deve conter apenas letras, números e caracteres simples (- / ())"
        );
    }

    this.nome = nome;
    }


    public void setPreco(double preco) {
    if (preco <= 0) {
        throw new IllegalArgumentException("[ O preço deve ser maior que zero ]");
    }
    this.preco = preco;
    }


    public void setQuantidade(int quantidade) {
    if (quantidade < 0) {
        throw new IllegalArgumentException("[ A quantidade não pode ser negativa ]");
    }
    this.quantidade = quantidade;
    }


    public void reduzirEstoque(int qtd) {
        if (qtd > quantidade)
            throw new IllegalArgumentException("[ Estoque insuficiente ]");
        this.quantidade -= qtd;
    }

    @Override
    public String toString() {
    String sep = "==============================";
    return sep +
           "\nID: " + id +
           "\nNome: " + nome +
           "\nPreço: R$ " + String.format("%.2f", preco) +
           "\nQuantidade em estoque: " + quantidade +
           "\n" + sep;
}

    public abstract void exibirDetalhes();
}