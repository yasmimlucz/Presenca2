package com.MundoSenai.Presenca.Service;

public class CpfValidator {

    public static boolean validarCPF(String cpf) {

        cpf = NumberCleaner.cleanNumber(cpf);

        if (cpf == null || cpf.length() != 11 || !cpf.matches("\\d{11}")) {
            return false;
        }

        int[] digitos = new int[11];
        for (int i = 0; i < 11; i++) {
            digitos[i] = Integer.parseInt(cpf.substring(i, i + 1));
        }

        // Verifica o primeiro dígito verificador
        int soma = 0;
        for (int i = 0; i < 9; i++) {
            soma += digitos[i] * (10 - i);
        }
        int resto = 11 - (soma % 11);
        int primeiroDigitoVerificador = (resto == 10 || resto == 11) ? 0 : resto;
        if (primeiroDigitoVerificador != digitos[9]) {
            return false;
        }

        // Verifica o segundo dígito verificador
        soma = 0;
        for (int i = 0; i < 10; i++) {
            soma += digitos[i] * (11 - i);
        }
        resto = 11 - (soma % 11);
        int segundoDigitoVerificador = (resto == 10 || resto == 11) ? 0 : resto;
        if (segundoDigitoVerificador != digitos[10]) {
            return false;
        }

        return true;
    }

    public static void main(String[] args) {
        String cpf = "12345678909"; // Substitua aqui pelo CPF que deseja validar
        if (validarCPF(cpf)) {
            System.out.println("CPF válido.");
        } else {
            System.out.println("CPF inválido.");
        }
    }
}