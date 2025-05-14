package calculadora;

import java.math.BigDecimal;
import java.math.RoundingMode;

public final class CalculeUtil {

    private static final double LIMITE_MAXIMO = 1_000_000_000;
    private static final double DIVISOR_MINIMO = 1e-6;

    private CalculeUtil() {}

    private static void validar(double... valores) {
        for (double valor : valores) {
            if (Double.isNaN(valor) || Double.isInfinite(valor)) {
                throw new IllegalArgumentException("Valores inválidos: NaN ou infinito não são permitidos.");
            }
        }
    }

    public static double discountAply(double valor, double percentual) {
        validar(valor, percentual);
        if (valor <= 0 || percentual < 0 || percentual > 100) {
            throw new IllegalArgumentException("Valor e percentual devem ser positivos, e o percentual não pode ser maior que 100.");
        }
        if (Math.abs(valor) > LIMITE_MAXIMO) {
            throw new IllegalArgumentException("O valor é muito grande para o cálculo.");
        }
        return (valor - (valor * percentual / 100));
    }

    public static double discountValue(double a, double b) {
        validar(a, b);
        if (a == 0) {
            throw new IllegalArgumentException("O valor 'a' não pode ser zero.");
        }
        if (Math.abs(a) < DIVISOR_MINIMO) {
            throw new IllegalArgumentException("O valor inicial é muito pequeno, o que pode gerar um resultado impreciso.");
        }
        if (Math.abs(a) > LIMITE_MAXIMO || Math.abs(b) > LIMITE_MAXIMO) {
            throw new IllegalArgumentException("Os valores são muito grandes para o cálculo.");
        }
        if (b < 0) {
            throw new IllegalArgumentException("O valor 'b' não pode ser negativo.");
        }
        return (((a - b) / a) * 100);
    }

    public static double incrementValue(double valor, double percentual) {
        validar(valor, percentual);
        if (valor <= 0 || percentual < 0 || percentual > 100) {
            throw new IllegalArgumentException("Valor e percentual devem ser positivos, e o percentual não pode ser maior que 100.");
        }
        if (Math.abs(valor) > LIMITE_MAXIMO) {
            throw new IllegalArgumentException("O valor é muito grande para o cálculo.");
        }
        return (valor + (valor * percentual / 100));
    }

    public static double originalValue(double valorComDesconto, double percentualDesconto) {
        validar(valorComDesconto, percentualDesconto);
        if (valorComDesconto <= 0 || percentualDesconto < 0 || percentualDesconto >= 100) {
            throw new IllegalArgumentException("Valor com desconto e percentual devem ser positivos, e o percentual não pode ser 100 ou maior.");
        }
        double divisor = 100 - percentualDesconto;
        if (divisor < DIVISOR_MINIMO) {
            throw new IllegalArgumentException("O desconto é muito próximo de 100%, o que tornaria o valor original excessivo.");
        }
        return ((valorComDesconto * 100) / divisor);
    }

    public static double percentageDelta(double valorInicial, double valorFinal) {
        validar(valorInicial, valorFinal);
        if (valorInicial == 0) {
            throw new IllegalArgumentException("O valor inicial não pode ser zero.");
        }
        if (Math.abs(valorInicial) < DIVISOR_MINIMO) {
            throw new IllegalArgumentException("O valor inicial é muito pequeno, o que pode gerar um resultado impreciso.");
        }
        if (Math.abs(valorInicial) > LIMITE_MAXIMO || Math.abs(valorFinal) > LIMITE_MAXIMO) {
            throw new IllegalArgumentException("Os valores são muito grandes para o cálculo.");
        }
        return (((valorFinal - valorInicial) / valorInicial) * 100);
    }

    public static double ruleOfThree(double a, double b, double c) {
        validar(a, b, c);
        if (a == 0) {
            throw new IllegalArgumentException("O valor de 'a' não pode ser zero.");
        }
        if (Math.abs(a) < DIVISOR_MINIMO) {
            throw new IllegalArgumentException("O valor de 'a' é muito pequeno, o que pode gerar um resultado impreciso.");
        }
        if (Math.abs(a) > LIMITE_MAXIMO || Math.abs(b) > LIMITE_MAXIMO || Math.abs(c) > LIMITE_MAXIMO) {
            throw new IllegalArgumentException("Os valores são muito grandes para o cálculo.");
        }
        return ((b * c) / a);
    }

    public static double samplingOne(double total, double percentual) {
        validar(total, percentual);
        if (total <= 0 || percentual < 0 || percentual > 100) {
            throw new IllegalArgumentException("Total e percentual devem ser positivos, e o percentual não pode ser maior que 100.");
        }
        if (Math.abs(total) > LIMITE_MAXIMO || Math.abs(percentual) > LIMITE_MAXIMO) {
            throw new IllegalArgumentException("Os valores são muito grandes para o cálculo.");
        }
        return ((total * percentual) / 100);
    }

    public static double samplingTwo(double parte, double total) {
        validar(parte, total);
        if (total == 0) {
            throw new IllegalArgumentException("O total não pode ser zero.");
        }
        if (Math.abs(total) < DIVISOR_MINIMO) {
            throw new IllegalArgumentException("O total é muito pequeno, o que pode gerar um resultado impreciso.");
        }
        if (Math.abs(parte) > LIMITE_MAXIMO || Math.abs(total) > LIMITE_MAXIMO) {
            throw new IllegalArgumentException("Os valores são muito grandes para o cálculo.");
        }
        if (parte < 0) {
            throw new IllegalArgumentException("A parte não pode ser negativa.");
        }
        return ((parte / total) * 100);
    }
}
