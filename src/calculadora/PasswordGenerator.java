package calculadora;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class PasswordGenerator {

    private boolean usarMaiusculas;
    private boolean usarMinusculas;
    private boolean usarNumeros;
    private boolean usarSimbolos;
    private static final int TAMANHO_MAXIMO = 30;

    public PasswordGenerator(boolean usarMaiusculas, boolean usarMinusculas, boolean usarNumeros, boolean usarSimbolos) {
        this.usarMaiusculas = usarMaiusculas;
        this.usarMinusculas = usarMinusculas;
        this.usarNumeros = usarNumeros;
        this.usarSimbolos = usarSimbolos;
    }

    public String gerar(int tamanho) {
        List<String> tiposAtivos = new ArrayList<>();
        List<Character> senha = new ArrayList<>();

        if (usarMaiusculas) tiposAtivos.add("ABCDEFGHIJKLMNOPQRSTUVWXYZ");
        if (usarMinusculas) tiposAtivos.add("abcdefghijklmnopqrstuvwxyz");
        if (usarNumeros) tiposAtivos.add("0123456789");
        if (usarSimbolos) tiposAtivos.add("!@#$%&*()-_=+[]{};:,.<>?/");

        if (tiposAtivos.isEmpty()) {
            throw new IllegalArgumentException("É necessário selecionar ao menos um tipo de caractere.");
        }
        if (tamanho < tiposAtivos.size()) {
            throw new IllegalArgumentException("Tamanho não pode ser menor que a quantidade de tipos.");
        } 
        if (tamanho > TAMANHO_MAXIMO) {
            throw new IllegalArgumentException("Tamanho muito grande. Escolha no máximo " + TAMANHO_MAXIMO + " caracteres.");
        }
        
        Random random = new Random();

        for (String tipo : tiposAtivos) {
            senha.add(tipo.charAt(random.nextInt(tipo.length())));
        }

        String todosOsCaracteres = String.join("", tiposAtivos);
        while (senha.size() < tamanho) {
            senha.add(todosOsCaracteres.charAt(random.nextInt(todosOsCaracteres.length())));
        }

        Collections.shuffle(senha);

        StringBuilder sb = new StringBuilder();
        for (char c : senha) {
            sb.append(c);
        }

        return sb.toString();
    }
}
