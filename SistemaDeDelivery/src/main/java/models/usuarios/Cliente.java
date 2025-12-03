package main.java.models.usuarios;

import main.java.models.abstratos.Pessoa;
import main.java.utils.InputHelper;

public class Cliente extends Pessoa {

    private String endereco;

    public Cliente(String nome, String cpf, String telefone,String email, String endereco){
        super(nome, cpf, telefone, email);
        setEndereco(endereco);
    }

    public String getEndereco() {
        return endereco;
    }
    public void setEndereco(String endereco) {
        if( endereco == null || endereco.trim().isEmpty())
            throw new IllegalArgumentException("Endereço não pode ser vazio.");
        this.endereco = endereco.trim();
    }

    @Override
    public void exibirDados() {
        System.out.println("===CLIENTE===");
        InputHelper.exibirDadosPessoas(this);
        System.out.println("Endereço: "+getEndereco());
    }
}
