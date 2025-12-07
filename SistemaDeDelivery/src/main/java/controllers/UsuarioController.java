package main.java.controllers;

import main.java.models.usuarios.Cliente;
import main.java.models.usuarios.Entregador;
import main.java.utils.InputHelper;
import main.java.utils.Validacao;

import java.util.ArrayList;
import java.util.List;

public class UsuarioController {

    private List<Cliente> clientes = new ArrayList<>();
    private List<Entregador> entregadores = new ArrayList<>();

    // ======================================================
    // GETTERS NECESSÁRIOS PARA O PedidoController
    // ======================================================
    public List<Cliente> getClientes() {
        return clientes;
    }

    public List<Entregador> getEntregadores() {
        return entregadores;
    }

    // ======================================================
    // CLIENTES
    // ======================================================
    public void menu() {
        int op;
        do {
            System.out.println("""
                    --- Usuários ---
                    1 - Cadastrar Cliente
                    2 - Listar Clientes
                    3 - Excluir Cliente
                    4 - Cadastrar Entregador
                    5 - Listar Entregadores
                    6 - Excluir Entregador
                    0 - Voltar
                    """);

            op = InputHelper.lerInt("Escolha:");

            switch (op) {
                case 1 -> cadastrarCliente();
                case 2 -> listarClientes();
                case 3 -> excluirClienteMenu();
                case 4 -> cadastrarEntregador();
                case 5 -> listarEntregadores();
                case 6 -> excluirEntregadorMenu();
                case 0 -> {}
                default -> System.out.println("Opção inválida!");
            }

        } while (op != 0);
    }

    // =========================
    // CRUD CLIENTES
    // =========================
    public void cadastrarCliente() {
    try {
        String nome;
        do {
            nome = InputHelper.lerString("Nome: ");
            if (!Validacao.validarNome(nome)) {
                System.out.println("Nome inválido! Use apenas letras e espaços.");
            }
        } while (!Validacao.validarNome(nome));

        String cpf;
        do {
            cpf = InputHelper.lerString("CPF: ");
            if (!Validacao.validarCPF(cpf))
                System.out.println("CPF inválido!");
        } while (!Validacao.validarCPF(cpf));

        String telefone;
        do {
            telefone = InputHelper.lerString("Telefone: ");
            if (!Validacao.validarTelefone(telefone))
                System.out.println("Telefone inválido!");
        } while (!Validacao.validarTelefone(telefone));

        String email;
        do {
            email = InputHelper.lerString("Email: ");
            if (!Validacao.validarEmail(email))
                System.out.println("Email inválido!");
        } while (!Validacao.validarEmail(email));

        String endereco = InputHelper.lerString("Endereço: ");

        Cliente c = new Cliente(nome, cpf, telefone, email, endereco);
        clientes.add(c);

        System.out.println("Cliente cadastrado!");
    } catch (Exception e) {
        System.out.println("Erro ao cadastrar cliente: " + e.getMessage());
    }
}


    public void listarClientes() {
        if (clientes.isEmpty()) {
            System.out.println("Nenhum cliente cadastrado.");
            return;
        }

        System.out.println("\n--- Lista de Clientes ---");
        int id = 1;
        for (Cliente c : clientes) {
        System.out.println("=======================================");
        System.out.println("ID: " + id);
        System.out.println("Nome: " + c.getNome());
        System.out.println("CPF: " + c.getCpf());
        System.out.println("Telefone: " + c.getTelefone());
        System.out.println("Email: " + c.getEmail());
        System.out.println("Endereço: " + c.getEndereco());
        System.out.println("=======================================");
        id++;
        }
    }

    public Cliente buscarClientePorId(int id) {
        if (id < 1 || id > clientes.size()) return null;
        return clientes.get(id - 1);
    }

    public void excluirClienteMenu() {
        listarClientes();
        int id = InputHelper.lerInt("ID do cliente a remover: ");
        Cliente c = buscarClientePorId(id);
        if (c != null) {
            clientes.remove(c);
            System.out.println("Cliente removido!");
        } else {
            System.out.println("Cliente não encontrado!");
        }
    }

    // =========================
    // CRUD ENTREGADORES
    // =========================
    public void cadastrarEntregador() {

    // Valida nome
    String nome;
    do {
        nome = InputHelper.lerString("Nome: ");
        if (!Validacao.validarNome(nome)) {
            System.out.println("Nome inválido! Use apenas letras e espaços.");
        }
    } while (!Validacao.validarNome(nome));

    // Valida CPF
    String cpf;
    do {
        cpf = InputHelper.lerString("CPF: ");
        if (!Validacao.validarCPF(cpf))
            System.out.println("CPF inválido!");
    } while (!Validacao.validarCPF(cpf));

    // Valida telefone
    String telefone;
    do {
        telefone = InputHelper.lerString("Telefone: ");
        if (!Validacao.validarTelefone(telefone))
            System.out.println("Telefone inválido!");
    } while (!Validacao.validarTelefone(telefone));

    // Validação da placa (loop que não deixa sair até ser válida)
    String placa;
    while (true) {
        try {
            placa = InputHelper.lerString("Placa do veículo: ");
            // testa apenas o formato da placa sem criar efeitos colaterais:
            // criar um método utilitário seria ideal, mas podemos usar o construtor de teste
            Entregador teste = new Entregador(nome, "00000000000", "0000000000", placa);
            break;
        } catch (Exception e) {
            System.out.println("Placa inválida! " + e.getMessage());
        }
    }

    // cria o entregador real (com os dados válidos)
    Entregador e = new Entregador(nome, cpf, telefone, placa);
    entregadores.add(e);

    System.out.println("Entregador cadastrado!");
}

    public void listarEntregadores() {
        if (entregadores.isEmpty()) {
            System.out.println("Nenhum entregador cadastrado.");
            return;
        }

        System.out.println("\n--- Lista de Entregadores ---");
        int id = 1;
        for (Entregador e : entregadores) {
            System.out.println("=======================================");
            System.out.println("ID: " + id);
            System.out.println("Nome: " + e.getNome());
            System.out.println("Telefone: " + e.getTelefone());
            System.out.println("Placa do Veículo: " + e.getPlacaVeiculo());
            System.out.println("=======================================");
            id++;
        }
    }

    public Entregador buscarEntregadorPorId(int id) {
        if (id < 1 || id > entregadores.size()) return null;
        return entregadores.get(id - 1);
    }

    public void excluirEntregadorMenu() {
        listarEntregadores();
        int id = InputHelper.lerInt("ID do entregador a remover: ");
        Entregador e = buscarEntregadorPorId(id);
        if (e != null) {
            entregadores.remove(e);
            System.out.println("Entregador removido!");
        } else {
            System.out.println("Entregador não encontrado!");
        }
    }
}
