package main.java.models.usuarios;

import main.java.models.abstratos.Pessoa;
import main.java.utils.InputHelper;

public class Entregador extends Pessoa {

    private String palcaVeiculo;

    public Entregador(String nome, String cpf, String telefone,String email, String palcaVeiculo){
        super(nome, cpf, telefone, email);
        this.palcaVeiculo = palcaVeiculo;
    }

    public String getPalcaVeiculo() {
        return palcaVeiculo;
    }
    public void setPalcaVeiculo(String palcaVeiculo) {
        this.palcaVeiculo = palcaVeiculo;
    }

    @Override
    public void exibirDados() {
        System.out.println("===ENTREGADOR===");
        InputHelper.exibirDadosPessoas(this);
        System.out.println("Placa do veiculo : "+getPalcaVeiculo());
    }
}
