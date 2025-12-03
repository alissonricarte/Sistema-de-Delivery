package main.java.utils;

public class Validacao {
    
    public static boolean validarCPF(String cpf) {
        if (cpf == null) {
            return false;
        }

        // Remove caracteres não numéricos
        cpf = cpf.replaceAll("[^0-9]", "");

        // Verifica se tem 11 dígitos
        if (cpf.length() != 11) {
            return false;
        }

        // Verifica se todos os dígitos são iguais (ex: 111.111.111-11)
        if (cpf.matches("(\\d)\\1{10}")) {
            return false;
        }

        try {
            // Calcula o primeiro dígito verificador
            int soma = 0;
            for (int i = 0; i < 9; i++) {
                int digito = Character.getNumericValue(cpf.charAt(i));
                soma += digito * (10 - i);
            }

            int resto = soma % 11;
            int digito1 = (resto < 2) ? 0 : 11 - resto;

            if (digito1 != Character.getNumericValue(cpf.charAt(9))) {
                return false;
            }
            soma = 0;
            for (int i = 0; i < 10; i++) {
                int digito = Character.getNumericValue(cpf.charAt(i));
                soma += digito * (11 - i);
            }
            resto = soma % 11;
            int digito2 = (resto < 2) ? 0 : 11 - resto;

            return digito2 == Character.getNumericValue(cpf.charAt(10));

        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static boolean validarEmail(String email) {
        return email != null && email.matches("^[\\w\\.-]+@[\\w\\.-]+\\.[a-zA-Z]{2,}$");
    }

    public static boolean validarTelefone(String telefone) {
        if (telefone == null) return false;

        telefone = telefone.replaceAll("[^0-9]", "");

        return telefone.length() >= 10 && telefone.length() <= 11;
    }

}
