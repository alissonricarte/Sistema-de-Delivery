package main.java.app;

import main.java.controllers.UsuarioController;
import main.java.controllers.ProdutoController;
import main.java.controllers.PedidoController;
import main.java.utils.InputHelper;

public class MenuPrincipal {

    UsuarioController usuarioController = new UsuarioController();
    ProdutoController produtoController = new ProdutoController();
    PedidoController pedidoController = new PedidoController(produtoController, usuarioController);

    public void iniciar() {
        int opcao;
        do {
            System.out.println("""
                    ========= Sistema de Delivery =========
                    1. Gerenciar Usuários
                    2. Gerenciar Produtos
                    3. Gerenciar Pedidos
                    0. Sair
                    """);

            opcao = InputHelper.lerInt("Escolha uma opção: ");
            System.out.println("==================================");

            switch (opcao) {
                case 1 -> usuarioController.menu();
                case 2 -> produtoController.menu();
                case 3 -> pedidoController.menu();
                case 0 -> System.out.println("Encerrando sistema...");
                default -> System.out.println("Opção inválida! Tente novamente.");
            }

        } while (opcao != 0);
    }
}
