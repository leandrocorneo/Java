package calculadora;

public class DiscountValue extends Calcule{
    @Override
    public double calcular(double a, double b) {
        return ((a - b) / a) * 100;
    }
}
