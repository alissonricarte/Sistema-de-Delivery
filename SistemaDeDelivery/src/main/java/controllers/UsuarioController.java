package main.java.controllers;

import main.java.models.usuarios.Cliente;
import main.java.utils.InputHelper;
import main.java.utils.Validacao;

import java.util.ArrayList;
import java.util.List;

public class UsuarioController {

    private List<Cliente> clientes = new ArrayList<>();

    public void menu() {
        int op;
        do {
            System.out.println("\n--- Clientes ---");
            System.out.println("1 - Cadastrar Cliente");
            System.out.println("2 - Listar Clientes");
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
        try {
            String nome = InputHelper.lerString("Nome: ");
            String cpf;

            do {
                cpf = InputHelper.lerString("CPF: ");
                if (!Validacao.validarCPF(cpf))
                    System.out.println("CPF inválido. Tente novamente.");
            } while (!Validacao.validarCPF(cpf));

            String telefone;
            do {
                telefone = InputHelper.lerString("Telefone: ");
                if (!Validacao.validarTelefone(telefone))
                    System.out.println("Telefone inválido. Tente novamente.");
            } while (!Validacao.validarTelefone(telefone));

            String email;
            do {
                email = InputHelper.lerString("Email: ");
                if (!Validacao.validarEmail(email))
                    System.out.println("Email inválido. Tente novamente.");
            } while (!Validacao.validarEmail(email));
            String endereco = InputHelper.lerString("Endereço: ");

            Cliente c = new Cliente(nome, cpf, telefone, email, endereco);
            clientes.add(c);

            System.out.println("Cliente cadastrado!");
        } catch (Exception e) {
            System.out.println("Erro ao cadastrar cliente: " + e.getMessage());
        }
    }

    private void listar() {
        if (clientes.isEmpty()) {
            System.out.println("Nenhum cliente cadastrado.");
            return;
        }

        System.out.println("\n--- Lista de Clientes ---");
        clientes.forEach(System.out::println);
    }
}