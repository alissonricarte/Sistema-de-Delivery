package main.java.utils;

import main.java.models.abstratos.Pessoa;
import main.java.models.abstratos.Produto;
import java.util.Scanner;

public class InputHelper {
    private static Scanner scanner = new Scanner(System.in);

    public static String lerString(String mensagem) {
        System.out.print(mensagem);
        return scanner.nextLine();
    }

    public static int lerInt(String mensagem) {
        while (true) {
            try {
                System.out.print(mensagem);
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Por favor, digite um número inteiro válido!");
            }
        }
    }

    public static double lerDouble(String mensagem) {
        while (true) {
            try {
                System.out.print(mensagem);
                return Double.parseDouble(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Por favor, digite um número decimal válido!");
            }
        }
    }

    public static void exibirDadosPessoas(Pessoa p) {
        System.out.println("Nome: " + p.getNome());
        System.out.println("CPF: " + p.getCpf());
        System.out.println("Telefone: " + p.getTelefone());
        System.out.println("Email: " + p.getEmail());
    }

    public static void exbirDadosProduto(Produto p) {
        System.out.println("Nome: " + p.getNome());
        System.out.println("Preço: R$ " + String.format("%.2f", p.getPreco()));
    }
}