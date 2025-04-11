package calculadora;

public class DiscountAply extends Calcule{
    @Override
    public double calcular(double a, double b) {
        return a - (a * b / 100);
    }
}
