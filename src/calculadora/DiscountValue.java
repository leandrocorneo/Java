package calculadora;

public class DiscountValue extends Calcule{
    public double calcular(double a, double b) {
        return CalculeUtil.discountValue(a, b);
    }
}
