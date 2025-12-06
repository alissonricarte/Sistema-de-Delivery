package main.java.controllers;

import java.util.ArrayList;
import java.util.List;
import main.java.models.abstratos.Produto;
import main.java.models.produtos.Bebida;
import main.java.models.produtos.Comida;
import main.java.utils.InputHelper;

public class ProdutoController {

    private List<Produto> produtos = new ArrayList<>();

    public Produto buscarPorId(int id) {
        return produtos.stream()
                .filter(p -> p.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public void listarComId() {
        if (produtos.isEmpty()) {
            System.out.println("Nenhum produto cadastrado.");
            return;
        }

        System.out.println("\n--- Produtos (com ID) ---");

        for (Produto p : produtos) {
            System.out.println(
                p.getId() + " - " + p.getNome() +
                " | Preço: R$" + p.getPreco() +
                " | Estoque: " + p.getQuantidade()
            );
        }
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void menu() {
        int op;
        do {
            System.out.println("\n--- Produtos ---");
            System.out.println("1 - Cadastrar");
            System.out.println("2 - Listar");
            System.out.println("0 - Voltar");

            op = InputHelper.lerInt("Escolha: ");

            switch (op) {
                case 1 -> cadastrar();
                case 2 -> listar();
                case 0 -> {}
                default -> System.out.println("Opção inválida!");
            }

        } while (op != 0);
    }

    private void cadastrar() {

        System.out.println("\n--- Tipo de produto: ---");
        System.out.println("1 - Comida");
        System.out.println("2 - Bebida");
        int tipo = InputHelper.lerInt("Tipo: ");

        String nome = InputHelper.lerString("Nome: ");
        double preco = InputHelper.lerDouble("Preço: ");
        int quantidade = InputHelper.lerInt("Quantidade: ");

        try {

            Produto p = switch (tipo) {
                case 1 -> new Comida(nome, preco, quantidade);
                case 2 -> new Bebida(nome, preco, quantidade);
                default -> null;
            };

            if (p == null) {
                System.out.println("Tipo inválido!");
                return;
            }

            produtos.add(p);
            System.out.println("Produto cadastrado! ID: " + p.getId());

        } catch (Exception e) {
            System.out.println("Erro ao cadastrar: " + e.getMessage());
        }
    }

    private void listar() {
        if (produtos.isEmpty()) {
            System.out.println("Nenhum produto cadastrado.");
            return;
        }

        System.out.println("\n--- Lista de Produtos ---");
        produtos.forEach(System.out::println);
    }
}