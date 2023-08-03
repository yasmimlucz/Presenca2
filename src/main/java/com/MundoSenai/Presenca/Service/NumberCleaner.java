package com.MundoSenai.Presenca.Service;

public class NumberCleaner {
    public static String cleanNumber(String num) {
        //remove caracteres apenas os digitos serão mantidos
        return num.replaceAll("[^0-9]", "");
    }

}
