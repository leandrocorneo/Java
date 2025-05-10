package calculadora;

public class SamplingOne extends Calcule{
    public double calcular(double a, double b) {
        return CalculeUtil.samplingOne(b, a);
    }
}
