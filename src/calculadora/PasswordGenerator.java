package calculadora;

import java.util.Random;

public class PasswordGenerator {

    private boolean usarMaiusculas;
    private boolean usarMinusculas;
    private boolean usarNumeros;
    private boolean usarSimbolos;

    public PasswordGenerator(boolean usarMaiusculas, boolean usarMinusculas, boolean usarNumeros, boolean usarSimbolos) {
        this.usarMaiusculas = usarMaiusculas;
        this.usarMinusculas = usarMinusculas;
        this.usarNumeros = usarNumeros;
        this.usarSimbolos = usarSimbolos;
    }

    public String gerar(int tamanho) {
        StringBuilder caracteres = new StringBuilder();

        if (usarMaiusculas) caracteres.append("ABCDEFGHIJKLMNOPQRSTUVWXYZ");
        if (usarMinusculas) caracteres.append("abcdefghijklmnopqrstuvwxyz");
        if (usarNumeros) caracteres.append("0123456789");
        if (usarSimbolos) caracteres.append("!@#$%&*()-_=+[]{};:,.<>?/");

        if (caracteres.length() == 0) {
            throw new IllegalArgumentException("É necessário selecionar ao menos um tipo de caractere.");
        }

        Random random = new Random();
        StringBuilder senha = new StringBuilder();

        for (int i = 0; i < tamanho; i++) {
            int index = random.nextInt(caracteres.length());
            senha.append(caracteres.charAt(index));
        }

        return senha.toString();
    }
}
