package main.java.controllers;

import main.java.models.ItemPedido;
import main.java.models.Pedido;
import main.java.models.abstratos.Produto;
import main.java.utils.InputHelper;

import java.util.ArrayList;
import java.util.List;

public class PedidoController {

    private List<Pedido> pedidos = new ArrayList<>();
    private ProdutoController produtoController;

    public PedidoController(ProdutoController produtoController) {
        this.produtoController = produtoController;
    }

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

        Pedido pedido = new Pedido("Pedido criado");

        while (true) {
            System.out.println("\nDigite o ID do produto (0 para finalizar): ");

            // listar produtos corretamente
            produtoController.listarComId();

            int id = InputHelper.lerInt("ID: ");

            if (id == 0)
                break;

            Produto p = produtoController.buscarPorId(id);

            if (p == null) {
                System.out.println("Produto não encontrado!");
                continue;
            }

            int qtd = InputHelper.lerInt("Quantidade: ");

            pedido.adicionarItem(new ItemPedido(p, qtd));
            System.out.println("Adicionado!");
        }

        pedidos.add(pedido);
        System.out.println("Pedido finalizado!");
    }

    private void listar() {
        if (pedidos.isEmpty()) {
            System.out.println("Nenhum pedido cadastrado.");
            return;
        }

        pedidos.forEach(System.out::println);
    }
}
