package calculadora;

public class DiscountAply extends Calcule {
    public double calcular(double a, double b) {
        return CalculeUtil.discountAply(a, b);
    }
}
