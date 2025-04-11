package calculadora;

public class OriginalValue extends Calcule{
    @Override
    public double calcular(double a, double b) {
        return (a * 100) / (100 - b);
    }
}
