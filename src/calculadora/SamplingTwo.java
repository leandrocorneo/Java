package calculadora;

public class SamplingTwo extends Calcule {
    @Override
    public double calcular(double a, double b) {
        return (b * 100) / a;
    }
}
