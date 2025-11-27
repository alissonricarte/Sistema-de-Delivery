package main.java.controllers;
import models.Usuario;
import utils.InputHelper;
import java.util.ArrayList;
import java.util.List;

public class UsuarioController {

    private List<Usuario> usuarios = new ArrayList<>();

    public void menu() {
        int op;
        do {
            System.out.println("\n--- Usuários ---");
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
        String nome = InputHelper.lerString("Nome: ");
        String email = InputHelper.lerString("Email: ");

        Usuario u = new Usuario(nome, email);
        usuarios.add(u);

        System.out.println("Usuário cadastrado!");
    }

    private void listar() {
        if (usuarios.isEmpty()) {
            System.out.println("Nenhum usuário cadastrado.");
            return;
        }

        usuarios.forEach(System.out::println);
    }
}