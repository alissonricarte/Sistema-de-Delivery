package main.java.models.usuarios;

import main.java.models.abstratos.Pessoa;
import main.java.utils.InputHelper;

public class Entregador extends Pessoa {

    private String placaVeiculo;

    public Entregador(String nome, String cpf, String telefone, String placaVeiculo) {
        super(nome, cpf, telefone, "entregador@local.com"); // Email padrão para entregadores
        setPlacaVeiculo(placaVeiculo);
    }
    public static void validarPlaca(String placa) throws IllegalArgumentException {
        // Regex para 3 letras (A-Z), hífen, 4 dígitos (0-9)
        String regex = "[A-Z]{3}-\\d{4}";
        if (!placa.matches(regex)) {
            throw new IllegalArgumentException("O formato deve ser ABC-1234 e as letras devem ser maiúsculas.");
        }
    }

    public String getPlacaVeiculo() {
        return placaVeiculo;
    }

    public void setPlacaVeiculo(String placaVeiculo) {

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
