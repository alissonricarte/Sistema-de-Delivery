package main.java.controllers;

import models.Produto;
import utils.InputHelper;

import java.util.ArrayList;
import java.util.List;

import main.java.models.interfaces.ITaxavel;
import main.java.models.Comida;
import main.java.models.Bebida;

public class ProdutoController {

    private List<Produto> produtos = new ArrayList<>();

    public void menu() {
        int op;
        do {
            System.out.println("\n--- Produtos ---");
            System.out.println("1 - Cadastrar");
            System.out.println("2 - Listar");
            System.out.println("3 - Calcular taxas");
            System.out.println("0 - Voltar");

            op = InputHelper.lerInt("Escolha: ");

            switch (op) {
                case 1 -> cadastrar();
                case 2 -> listar();
                case 3 -> calcularTaxas();
                case 0 -> {}
                default -> System.out.println("Opção inválida!");
            }

        } while (op != 0);
    }

    private void cadastrar() {
    System.out.println("1 - Comida");
    System.out.println("2 - Bebida");
    int tipo = InputHelper.lerInt("Tipo: ");

    String nome = InputHelper.lerString("Nome do produto: ");
    double preco = InputHelper.lerDouble("Preço: ");

    Produto p = null;

    if (tipo == 1) {
        String tipoComida = InputHelper.lerString("Tipo da comida: ");
        p = new Comida(nome, preco, tipoComida);

    } else if (tipo == 2) {
        String tamanho = InputHelper.lerString("Tamanho da bebida: ");
        p = new Bebida(nome, preco, tamanho);

    } else {
        System.out.println("Tipo inválido!");
        return;
    }

    produtos.add(p);
    System.out.println("Produto cadastrado com sucesso!");
    }


    private void listar() {
        if (produtos.isEmpty()) {
            System.out.println("Nenhum produto cadastrado.");
            return;
        }

        produtos.forEach(System.out::println);
    }

    public void calcularTaxas() {
    System.out.println("=== Taxas dos Produtos ===");

    boolean encontrou = false;

    for (Produto p : produtos) {
        if (p instanceof ITaxavel) {
            ITaxavel taxavel = (ITaxavel) p;
            System.out.println(p.getNome() + " - Taxa: R$ " + taxavel.calcularTaxa());
            encontrou = true;
        }
    }

    if (!encontrou) {
        System.out.println("Nenhum produto possui taxa.");
    }
}

}

