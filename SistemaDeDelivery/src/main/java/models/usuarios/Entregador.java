package main.java.models.usuarios;

import main.java.models.abstratos.Pessoa;
import main.java.utils.InputHelper;

/**
 * Classe que representa um entregador do sistema.
 * Um entregador é uma Pessoa que possui uma placa de veículo cadastrada.
 */
public class Entregador extends Pessoa {

    private String placaVeiculo;

    /**
     * Construtor da classe Entregador.
     *
     * @param nome Nome completo do entregador
     * @param cpf CPF do entregador
     * @param telefone Telefone do entregador
     * @param email Email do entregador
     * @param placaVeiculo Placa do veículo utilizado pelo entregador
     */
    public Entregador(String nome, String cpf, String telefone, String email, String placaVeiculo) {
        super(nome, cpf, telefone, email);
        setPlacaVeiculo(placaVeiculo);
    }

    public String getPlacaVeiculo() {
        return placaVeiculo;
    }

    /**
     * Define a placa do veículo, aplicando validação simples.
     */
    public void setPlacaVeiculo(String placaVeiculo) {
        if (placaVeiculo == null || placaVeiculo.trim().isEmpty()) {
            throw new IllegalArgumentException("A placa do veículo não pode ser vazia!");
        }

        if(!placaVeiculo.matches("[A-Z]{3}-?\\d{4}") && !placaVeiculo.matches("[A-Z]{3}\\d[A-Z]\\d{2}")) {
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
