package main.java.utils;

import main.java.models.abstratos.Pessoa;
import main.java.models.abstratos.Produto;

public class InputHelper {
    public static void exibirDadosPessoas(Pessoa p){
        System.out.println("Nome: "+p.getNome());
        System.out.println("CPF: "+p.getCpf());
        System.out.println("Telefone: "+p.getCpf());
        System.out.println("Email: "+p.getEmail());
    }
    public static void exbirDadosProduto(Produto p){
        System.out.println("Nome: "+p.getNome());
        System.out.println("Preço: "+p.getPreco());
    }
}
