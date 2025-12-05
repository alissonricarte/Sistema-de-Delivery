package main.java.app;

import main.java.controllers.UsuarioController;
import main.java.controllers.ProdutoController;
import main.java.controllers.PedidoController;
import main.java.utils.InputHelper;

public class MenuPrincipal {

    private UsuarioController usuarioController;
    private ProdutoController produtoController;
    private PedidoController pedidoController;

    public MenuPrincipal() {
        this.usuarioController = new UsuarioController();
        this.produtoController = new ProdutoController();
        this.pedidoController = new PedidoController();
    }

    public void iniciar() {
        int opcao;

        do {
            System.out.println("\n========= MENU PRINCIPAL =========");
            System.out.println("1. Gerenciar Usuários");
            System.out.println("2. Gerenciar Produtos");
            System.out.println("3. Gerenciar Pedidos");
            System.out.println("4. Sair");
            System.out.println("==================================");

            opcao = InputHelper.lerInt("Escolha uma opção: ");

            switch (opcao) {
                case 1:
                    menuUsuarios();
                    break;

                case 2:
                    menuProdutos();
                    break;

                case 3:
                    menuPedidos();
                    break;

                case 4:
                    System.out.println("Encerrando sistema...");
                    break;

                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }

        } while (opcao != 4);
    }

    private void menuUsuarios() {
        int opcao;

        do {
            System.out.println("\n====== MENU DE USUÁRIOS ======");
            System.out.println("1. Cadastrar Usuário");
            System.out.println("2. Listar Usuários");
            System.out.println("3. Remover Usuário");
            System.out.println("4. Voltar");
            System.out.println("===============================");

            opcao = InputHelper.lerInt("Escolha: ");

            switch (opcao) {
                case 1:
                    usuarioController.cadastrarUsuario();
                    break;

                case 2:
                    usuarioController.listarUsuarios();
                    break;

                case 3:
                    usuarioController.removerUsuario();
                    break;

                case 4:
                    return;

                default:
                    System.out.println("Opção inválida!");
            }

        } while (true);
    }


    private void menuProdutos() {
        int opcao;

        do {
            System.out.println("\n======== MENU DE PRODUTOS ========");
            System.out.println("1. Cadastrar Produto");
            System.out.println("2. Listar Produtos");
            System.out.println("3. Remover Produto");
            System.out.println("4. Voltar");
            System.out.println("===================================");

            opcao = InputHelper.lerInt("Escolha: ");

            switch (opcao) {
                case 1:
                    produtoController.cadastrarProduto();
                    break;

                case 2:
                    produtoController.listarProdutos();
                    break;

                case 3:
                    produtoController.removerProduto();
                    break;

                case 4:
                    return;

                default:
                    System.out.println("Opção inválida!");
            }

        } while (true);
    }

    private void menuPedidos() {
        int opcao;

        do {
            System.out.println("\n======== MENU DE PEDIDOS ========");
            System.out.println("1. Criar Pedido");
            System.out.println("2. Listar Pedidos");
            System.out.println("3. Alterar Status");
            System.out.println("4. Cancelar Pedido");
            System.out.println("5. Voltar");
            System.out.println("===================================");

            opcao = InputHelper.lerInt("Escolha: ");

            switch (opcao) {
                case 1:
                    pedidoController.criarPedido();
                    break;

                case 2:
                    pedidoController.listarPedidos();
                    break;

                case 3:
                    pedidoController.alterarStatus();
                    break;

                case 4:
                    pedidoController.cancelarPedido();
                    break;

                case 5:
                    return;

                default:
                    System.out.println("Opção inválida!");
            }

        } while (true);
    }
}