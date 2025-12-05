package main.java.controllers;

import main.java.models.Pedido;
import main.java.utils.InputHelper;

import java.util.ArrayList;
import java.util.List;

public class PedidoController {

    private List<Pedido> pedidos = new ArrayList<>();

    public void menu() {
        int op;

        do {
            System.out.println("\n--- Pedidos ---");
            System.out.println("1 - Criar pedido");
            System.out.println("2 - Listar pedidos");
            System.out.println("0 - Voltar");

            op = InputHelper.lerInt("Escolha: ");

            switch (op) {
                case 1 -> criarPedido();
                case 2 -> listar();
                case 0 -> {}
                default -> System.out.println("Opção inválida!");
            }

        } while (op != 0);
    }

    private void criarPedido() {
        String descricao = InputHelper.lerString("Descrição: ");
        Pedido p = new Pedido(descricao);
        pedidos.add(p);

        System.out.println("Pedido criado!");
    }

    private void listar() {
        if (pedidos.isEmpty()) {
            System.out.println("Nenhum pedido cadastrado.");
            return;
        }

        System.out.println("\n--- Lista de Pedidos ---");
        pedidos.forEach(System.out::println);
    }
}