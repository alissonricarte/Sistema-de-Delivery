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

        this.placaVeiculo = placaVeiculo.toUpperCase().trim();
    }

    @Override
    public void exibirDados() {
        System.out.println("=== ENTREGADOR ===");
        InputHelper.exibirDadosPessoas(this);
        System.out.println("Placa do Veículo: " + placaVeiculo);
    }

    @Override
    public String toString() {
        return "Entregador {" +
                "nome='" + getNome() + '\'' +
                ", cpf='" + getCpf() + '\'' +
                ", telefone='" + getTelefone() + '\'' +
                ", email='" + getEmail() + '\'' +
                ", placaVeiculo='" + placaVeiculo + '\'' +
                '}';
    }
}
