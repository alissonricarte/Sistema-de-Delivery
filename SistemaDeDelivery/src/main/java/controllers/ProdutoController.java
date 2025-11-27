package main.java.controllers;

import models.Produto;
import utils.InputHelper;

import java.util.ArrayList;
import java.util.List;

public class ProdutoController {

    private List<Produto> produtos = new ArrayList<>();

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
        String nome = InputHelper.lerString("Nome do produto: ");
        double preco = InputHelper.lerDouble("Preço: ");

        Produto p = new Produto(nome, preco);
        produtos.add(p);

        System.out.println("Produto cadastrado!");
    }

    private void listar() {
        if (produtos.isEmpty()) {
            System.out.println("Nenhum produto cadastrado.");
            return;
        }

        produtos.forEach(System.out::println);
    }
}