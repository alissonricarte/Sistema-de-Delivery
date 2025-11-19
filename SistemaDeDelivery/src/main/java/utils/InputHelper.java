package main.java.utils;

import main.java.models.abstratos.Pessoa;

public class InputHelper {
    public static void exibirDadosUlt(Pessoa p){
        System.out.println("Nome: "+p.getNome());
        System.out.println("CPF: "+p.getCpf());
        System.out.println("Telefone: "+p.getCpf());
        System.out.println("Email: "+p.getEmail());
    }
}
