package main.java.controllers;

import main.java.models.ItemPedido;
import main.java.models.Pedido;
import main.java.models.abstratos.Produto;
import main.java.models.usuarios.Cliente;
import main.java.models.usuarios.Entregador;
import main.java.utils.InputHelper;

import java.util.ArrayList;
import java.util.List;

public class PedidoController {

    private List<Pedido> pedidos = new ArrayList<>();
    private ProdutoController produtoController;
    private UsuarioController usuarioController;

    public PedidoController(ProdutoController produtoController, UsuarioController usuarioController) {
        this.produtoController = produtoController;
        this.usuarioController = usuarioController;
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

        // ================================
        // SELEÇÃO DO CLIENTE
        // ================================
        if (usuarioController.getClientes().isEmpty()) {
            System.out.println("Nenhum cliente cadastrado. Cadastre antes de criar pedidos.");
            return;
        }

        System.out.println("\n=== SELECIONE O CLIENTE ===");
        usuarioController.listarClientes();
        Cliente cliente = usuarioController.buscarClientePorId(InputHelper.lerInt("ID do cliente: "));

        if (cliente == null) {
            System.out.println("Cliente inválido! Cancelando pedido.");
            return;
        }

        // ================================
        // SELEÇÃO DO ENTREGADOR
        // ================================
        if (usuarioController.getEntregadores().isEmpty()) {
            System.out.println("Nenhum entregador cadastrado. Cadastre antes de criar pedidos.");
            return;
        }

        System.out.println("\n=== SELECIONE O ENTREGADOR ===");
        usuarioController.listarEntregadores();
        Entregador entregador = usuarioController.buscarEntregadorPorId(InputHelper.lerInt("ID do entregador: "));

        if (entregador == null) {
            System.out.println("Entregador inválido! Cancelando pedido.");
            return;
        }

        // Cria descrição automática
        String descricao = "Pedido #" + (pedidos.size() + 1);

        Pedido pedido = new Pedido(descricao, cliente, entregador);

        // ================================
        // ADIÇÃO DE ITENS COM ESTOQUE
        // ================================
        while (true) {

            if (produtoController.getProdutos().isEmpty()) {
                System.out.println("Nenhum produto cadastrado. Não é possível criar pedidos.");
                return;
            }

            System.out.println("\nProdutos disponíveis:");
            produtoController.listar();

            int id = InputHelper.lerInt("ID do produto (0 para finalizar): ");
            if (id == 0) break;

            Produto p = produtoController.buscarPorId(id);

            if (p == null) {
                System.out.println("Produto não encontrado!");
                continue;
            }

            int qtd = InputHelper.lerInt("Quantidade: ");
            if (qtd <= 0) {
                System.out.println("Quantidade inválida!");
                continue;
            }

            if (qtd > p.getQuantidade()) {
                System.out.println("Estoque insuficiente! Disponível: " + p.getQuantidade());
                continue;
            }

            pedido.adicionarItem(new ItemPedido(p, qtd));

            p.setQuantidade(p.getQuantidade() - qtd);

            System.out.println("Item adicionado! Estoque restante: " + p.getQuantidade());

            if (p.getQuantidade() == 0) {
                System.out.println("⚠ Produto esgotado!");
            }
        }

        if (pedido.getItens().isEmpty()) {
            System.out.println("Pedido cancelado (nenhum item adicionado).");
            return;
        }

        pedidos.add(pedido);

        System.out.println("\nPedido finalizado com sucesso!");
        System.out.println(pedido);
    }

    private void listar() {
        if (pedidos.isEmpty()) {
            System.out.println("Nenhum pedido cadastrado.");
            return;
        }

        pedidos.forEach(System.out::println);
    }
}