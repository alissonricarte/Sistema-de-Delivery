package main.java.models.abstratos;

import main.java.utils.Validacao;

public abstract class Pessoa {
    private String nome;
    private String cpf;
    private String telefone;
    private String email;

    public Pessoa(String nome, String cpf, String telefone, String email){
        setNome(nome);
        setCpf(cpf);
        setTelefone(telefone);
        setEmail(email);
    }

    public String getNome() { return nome; }
    public String getCpf() { return cpf; }
    public String getTelefone() { return telefone; }
    public String getEmail() { return email; }

    public void setNome(String nome) {
        if (nome == null || nome.trim().isEmpty())
            throw new IllegalArgumentException("Nome não pode ser vazio.");
        this.nome = nome.trim();
    }
    public void setCpf(String cpf) {
        if (!Validacao.validarCPF(cpf))
            throw new IllegalArgumentException("CPF inválido.");
        this.cpf = cpf.replaceAll("[^0-9]", "");
    }
    public void setTelefone(String telefone) {
        if (!Validacao.validarTelefone(telefone))
            throw new IllegalArgumentException("Telefone inválido.");
        this.telefone = telefone;
    }
    public void setEmail(String email) {
        if (!Validacao.validarEmail(email))
            throw new IllegalArgumentException("Email inválido.");
        this.email = email;
    }

    public abstract void exibirDados();

    @Override
    public String toString() {
        return "Nome: " + nome +
                "\nCPF: " + cpf +
                "\nTelefone: " + telefone +
                "\nEmail: " + email;
    }
}
