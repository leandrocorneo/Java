package calculadora;

public class PercentageDelta extends Calcule{
    @Override
    public double calcular(double a, double b) {
        return ((b - a) / a) * 100;
    }
}
