package main.java.app;

import java.util.Scanner;
import main.java.controllers.PedidoController;
import main.java.controllers.ProdutoController;
import main.java.controllers.UsuarioController;

public class Main {

    private static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        UsuarioController usuarioController = new UsuarioController();
        ProdutoController produtoController = new ProdutoController();
        PedidoController pedidoController = new PedidoController();

        iniciarSistema(usuarioController, produtoController, pedidoController);
    }

    private static void iniciarSistema(
            UsuarioController usuarioController,
            ProdutoController produtoController,
            PedidoController pedidoController) {

        int opcao = -1;

        while (opcao != 0) {
            System.out.println("\n===== SISTEMA DE DELIVERY =====");
            System.out.println("1 - Gerenciar Usuários");
            System.out.println("2 - Gerenciar Produtos");
            System.out.println("3 - Gerenciar Pedidos");
            System.out.println("0 - Sair");
            System.out.print("Escolha: ");

            try {
                opcao = Integer.parseInt(input.nextLine());
            } catch (NumberFormatException e) {
                opcao = -1;
            }

            switch (opcao) {
                case 1 -> usuarioController.menu();
                case 2 -> produtoController.menu();
                case 3 -> pedidoController.menu();
                case 0 -> System.out.println("Saindo do sistema...");
                default -> System.out.println("Opção inválida! Tente novamente.");
            }
        }
    }
}