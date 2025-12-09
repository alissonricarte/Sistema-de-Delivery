package main.java.controllers;

import main.java.Enums.StatusPedido;
import main.java.models.ItemPedido;
import main.java.models.Pedido;
import main.java.models.abstratos.Produto;
import main.java.models.usuarios.Cliente;
import main.java.models.usuarios.Entregador;
import main.java.utils.InputHelper;

import java.util.ArrayList;
import java.util.List;
public class PedidoController {

    public void atualizarStatus(int indice, StatusPedido novoStatus) {

        // Verifica se o índice é válido para evitar erro (IndexOutOfBoundsException)
        if (indice < 0 || indice >= pedidos.size()) {
            System.out.println("ID de pedido inválido. Não foi possível atualizar o status.");
            return;
        }

        Pedido pedido = pedidos.get(indice);

        // (Opcional) Adicione a lógica de validação de transição aqui, se necessário.

        pedido.setStatus(novoStatus);
        System.out.println("Status do pedido #" + (indice + 1) + " atualizado para: " + novoStatus.getDescricao());
    }
    // Dentro da classe PedidoController:

    private void rastrearPedido() {
        if (pedidos.isEmpty()) {
            System.out.println("Nenhum pedido para rastrear.");
            return;
        }

        System.out.println("\n=== ATUALIZAR STATUS DE PEDIDO ===");
        listarPedidosComStatus(); // Novo método para mostrar lista numerada (veja abaixo)

        int indice = InputHelper.lerInt("Digite o NÚMERO (ID) do pedido a atualizar: ") - 1;

        if (indice < 0 || indice >= pedidos.size()) {
            System.out.println("ID de pedido inválido.");
            return;
        }

        System.out.println("\nStatus disponíveis:");
        // Lista todos os valores do Enum para que o usuário possa escolher
        StatusPedido[] statusOpcoes = StatusPedido.values();
        for (int i = 0; i < statusOpcoes.length; i++) {
            System.out.println((i + 1) + " - " + statusOpcoes[i].getDescricao());
        }

        int escolhaStatus = InputHelper.lerInt("Novo Status (Escolha o número): ");

        if (escolhaStatus < 1 || escolhaStatus > statusOpcoes.length) {
            System.out.println("Opção de status inválida.");
            return;
        }

        // Chama o método que realmente faz a alteração:
        atualizarStatus(indice, statusOpcoes[escolhaStatus - 1]);
    }

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
            System.out.println("3 - Rastrear/Atualizar status"); // NOVO
            System.out.println("0 - Voltar");

            op = InputHelper.lerInt("Escolha: ");

            switch (op) {
                case 1 -> criarPedido();
                case 2 -> listar();
                case 3 -> rastrearPedido(); // NOVO
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
        pedidos.forEach(p -> System.out.println(p + " | Status: " + p.getStatus().getDescricao()));
    }

    private void listarPedidosComStatus() {
        if (pedidos.isEmpty()) return;

        System.out.println("\n--- Pedidos Atuais ---");
        for (int i = 0; i < pedidos.size(); i++) {
            Pedido p = pedidos.get(i);
            // Mostra o número na lista (ID visual), a descrição e o status:
            System.out.println((i + 1) + " - " + p.getDescricao() + " | Cliente: " + p.getCliente().getNome() + " | Status: " + p.getStatus().getDescricao());
        }
        System.out.println("----------------------");
    }
}