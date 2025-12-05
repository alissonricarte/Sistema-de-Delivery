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
            System.out.println("""
                    --- Clientes ---
                    1 - Cadastrar Cliente
                    2 - Listar Cliente
                    3 - Apagar Cliente
                    
                    0 - Voltar
                    """);
            op = InputHelper.lerInt("escolha:");

            switch (op) {
                case 1 -> cadastrar();
                case 2 -> listar();
                case 3 -> excluir();
                default -> System.out.println("Opção inválida!");
            }

        } while (op != 0);
    }

    public void cadastrar() {
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

    public void listar() {
        if (clientes.isEmpty()) {
            System.out.println("Nenhum cliente cadastrado.");
            return;
        }

        System.out.println("\n--- Lista de Clientes ---");
        clientes.forEach(System.out::println);
    }
    public void excluir() {
        String cpf = InputHelper.lerString("CPF do cliente a remover: ");
        if (excluirCliente(cpf))
            System.out.println("Cliente removido!");
        else
            System.out.println("Cliente não encontrado!");
    }

    public boolean excluirCliente(String cpf) {
        return clientes.removeIf(c -> c.getCpf().equals(cpf));
    }
}