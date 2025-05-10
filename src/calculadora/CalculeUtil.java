package calculadora;

public class CalculeUtil {

    private static final double LIMITE_MAXIMO = 1e6;

    public static double discountAply(double valor, double percentual) {
        if (valor <= 0 || percentual < 0 || percentual > 100) {
            throw new IllegalArgumentException("Valor e percentual devem ser positivos, e o percentual não pode ser maior que 100.");
        }
        if (Math.abs(valor) > LIMITE_MAXIMO) {
            throw new IllegalArgumentException("O valor é muito grande para o cálculo.");
        }
        return valor - (valor * percentual / 100);
    }

    public static double discountValue(double a, double b) {
        if (a == 0) {
            throw new IllegalArgumentException("O valor 'a' não pode ser zero.");
        }
        if (Math.abs(a) > LIMITE_MAXIMO || Math.abs(b) > LIMITE_MAXIMO) {
            throw new IllegalArgumentException("Os valores são muito grandes para o cálculo.");
        }
        if (b < 0) {
            throw new IllegalArgumentException("O valor 'b' não pode ser negativo.");
        }
        return ((a - b) / a) * 100;
    }

    public static double incrementValue(double valor, double percentual) {
        if (valor <= 0 || percentual < 0 || percentual > 100) {
            throw new IllegalArgumentException("Valor e percentual devem ser positivos, e o percentual não pode ser maior que 100.");
        }
        if (Math.abs(valor) > LIMITE_MAXIMO) {
            throw new IllegalArgumentException("O valor é muito grande para o cálculo.");
        }
        return valor + (valor * percentual / 100);
    }

    public static double originalValue(double valorComDesconto, double percentualDesconto) {
        if (valorComDesconto <= 0 || percentualDesconto < 0 || percentualDesconto >= 100) {
            throw new IllegalArgumentException("Valor com desconto e percentual devem ser positivos, e o percentual não pode ser 100 ou maior.");
        }
        return (valorComDesconto * 100) / (100 - percentualDesconto);
    }

    public static double percentageDelta(double valorInicial, double valorFinal) {
        if (valorInicial == 0) {
            throw new IllegalArgumentException("O valor inicial não pode ser zero.");
        }
        if (Math.abs(valorInicial) > LIMITE_MAXIMO || Math.abs(valorFinal) > LIMITE_MAXIMO) {
            throw new IllegalArgumentException("Os valores são muito grandes para o cálculo.");
        }
        return ((valorFinal - valorInicial) / valorInicial) * 100;
    }

    public static double ruleOfThree(double a, double b, double c) {
        if (a == 0) {
            throw new IllegalArgumentException("O valor de 'a' não pode ser zero.");
        }
        if (Math.abs(a) > LIMITE_MAXIMO || Math.abs(b) > LIMITE_MAXIMO) {
            throw new IllegalArgumentException("Os valores são muito grandes para o cálculo.");
        }
        return (b * c) / a;
    }

    public static double samplingOne(double total, double percentual) {
        if (total <= 0 || percentual < 0 || percentual > 100) {
            throw new IllegalArgumentException("Total e percentual devem ser positivos, e o percentual não pode ser maior que 100.");
        }
        if (Math.abs(total) > LIMITE_MAXIMO || Math.abs(percentual) > LIMITE_MAXIMO) {
            throw new IllegalArgumentException("Os valores são muito grandes para o cálculo.");
        }
        return (total * percentual) / 100;
    }

    public static double samplingTwo(double parte, double total) {
        if (total == 0) {
            throw new IllegalArgumentException("O total não pode ser zero.");
        }
        if (Math.abs(parte) > LIMITE_MAXIMO || Math.abs(total) > LIMITE_MAXIMO) {
            throw new IllegalArgumentException("Os valores são muito grandes para o cálculo.");
        }
        if (parte < 0) {
            throw new IllegalArgumentException("A parte não pode ser negativa.");
        }
        return (parte / total) * 100;
    }
}
