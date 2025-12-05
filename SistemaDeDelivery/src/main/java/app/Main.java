package main.java.app;

import main.java.controllers.PedidoController;
import main.java.controllers.ProdutoController;
import main.java.controllers.UsuarioController;
import main.java.utils.InputHelper;

public class Main {
    private static UsuarioController usuarioController = new UsuarioController();
    private static PedidoController pedidoController = new PedidoController();
    private static ProdutoController produtoController = new ProdutoController();

    public static void main(String[] args) {
        MenuPrincipal menu = new MenuPrincipal();
        menu.iniciar();
    }

    private static void iniciarSistema() {
        int opcao;

        do {
            System.out.println("\n=== SISTEMA DE DELIVERY ===");
            System.out.println("1 - Gerenciar Usuários");
            System.out.println("2 - Gerenciar Pedidos");
            System.out.println("3 - Gerenciar Produtos");
            System.out.println("4 - Calcular taxas dos produtos");
            System.out.println("0 - Sair");

            opcao = InputHelper.lerInt("Escolha uma opção: ");

            switch (opcao) {
                case 1 -> usuarioController.menu();
                case 2 -> pedidoController.menu();
                case 3 -> produtoController.menu();
                case 4 -> produtoController.calcularTaxas();
                case 0 -> System.out.println("Saindo do sistema...");
                default -> System.out.println("Opção inválida!");
            }
        } while (opcao != 0);
    }
}