package main.java.models.usuarios;

import main.java.models.abstratos.Pessoa;
import main.java.utils.InputHelper;

public class Entregador extends Pessoa {

    private String placaVeiculo;

    public Entregador(String nome, String cpf, String telefone, String email, String placaVeiculo) {
        super(nome, cpf, telefone, email);
        setPlacaVeiculo(placaVeiculo);
    }

    public String getPlacaVeiculo() {
        return placaVeiculo;
    }

    public void setPlacaVeiculo(String placaVeiculo) {

        // Verifica se está vazia
        if (placaVeiculo == null || placaVeiculo.trim().isEmpty()) {
            throw new IllegalArgumentException("A placa do veículo não pode ser vazia!");
        }

        // Valida formatos de placa (padrão antigo e Mercosul)
        boolean placaAntiga = placaVeiculo.matches("[A-Z]{3}-?\\d{4}");
        boolean placaMercosul = placaVeiculo.matches("[A-Z]{3}\\d[A-Z]\\d{2}");

        if (!placaAntiga && !placaMercosul) {
            throw new IllegalArgumentException("Placa de veículo inválida!");
        }

        this.placaVeiculo = placaVeiculo.toUpperCase().trim();
    }

    @Override
    public void exibirDados() {
        System.out.println("=== ENTREGADOR ===");
        InputHelper.exibirDadosPessoas(this);
        System.out.println("Placa do Veículo: " + placaVeiculo);
    }
}
