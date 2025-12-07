package main.java.utils;

public class Validacao {

    // -------------------- VALIDAR NOME --------------------
    
    public static boolean validarNome(String nome) {
    if (nome == null) return false;
        nome = nome.trim();
    
    if (nome.isEmpty()) return false;
        return nome.matches("^[\\p{L} ]+$");
    }

    // -------------------- VALIDAR CPF --------------------

    public static boolean validarCPF(String cpf) {
        if (cpf == null) return false;

        // Remove tudo que não for número
        cpf = cpf.replaceAll("\\D", "");

        // CPF deve ter 11 dígitos
        if (cpf.length() != 11) return false;

        // Evita CPFs com todos números repetidos (ex.: 11111111111)
        if (cpf.matches("(\\d)\\1{10}")) return false;

        try {
            // Primeiro dígito
            int soma = 0;
            for (int i = 0; i < 9; i++) {
                soma += Character.getNumericValue(cpf.charAt(i)) * (10 - i);
            }
            int resto = soma % 11;
            int digito1 = (resto < 2) ? 0 : (11 - resto);

            if (digito1 != Character.getNumericValue(cpf.charAt(9))) {
                return false;
            }

            // Segundo dígito
            soma = 0;
            for (int i = 0; i < 10; i++) {
                soma += Character.getNumericValue(cpf.charAt(i)) * (11 - i);
            }
            resto = soma % 11;
            int digito2 = (resto < 2) ? 0 : (11 - resto);

            return digito2 == Character.getNumericValue(cpf.charAt(10));

        } catch (Exception e) {
            return false;
        }
    }


    // -------------------- VALIDAR EMAIL --------------------

    public static boolean validarEmail(String email) {
        if (email == null) return false;

        // Expressão simples e funcional para emails comuns
        return email.matches("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$");
    }


    // -------------------- VALIDAR TELEFONE --------------------

    public static boolean validarTelefone(String telefone) {
        if (telefone == null) return false;

        telefone = telefone.replaceAll("\\D", ""); // mantém só números

        // Telefone válido no BR tem 10 (fixo) ou 11 dígitos (celular)
        return telefone.length() == 10 || telefone.length() == 11;
    }

}
