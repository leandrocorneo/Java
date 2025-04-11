package calculadora;

public class RuleOfThree extends Calcule{
    @Override
    public double calcular(double a, double b, double c) {
        return (b * c) / a;
    }
}
