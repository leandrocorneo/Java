package calculadora;

public class CalculeUtilTest {
    public static void main(String[] args) {
        testDiscountAply();
        testDiscountValue();
        testIncrementValue();
        testOriginalValue();
        testPercentageDelta();
        testRuleOfThree();
        testSamplingOne();
        testSamplingTwo();
    }

    private static void testDiscountAply() {
        try {
            System.out.println("Discount Aply: " + CalculeUtil.discountAply(100, 10)); // 90
        } catch (Exception e) {
            System.out.println("Erro em Discount Aply: " + e.getMessage());
        }
    }

    private static void testDiscountValue() {
        try {
            System.out.println("Discount Value: " + CalculeUtil.discountValue(200, 150)); // 25
        } catch (Exception e) {
            System.out.println("Erro em Discount Value: " + e.getMessage());
        }
    }

    private static void testIncrementValue() {
        try {
            System.out.println("Increment Value: " + CalculeUtil.incrementValue(100, 25)); // 125
        } catch (Exception e) {
            System.out.println("Erro em Increment Value: " + e.getMessage());
        }
    }

    private static void testOriginalValue() {
        try {
            System.out.println("Original Value: " + CalculeUtil.originalValue(80, 20)); // 100
        } catch (Exception e) {
            System.out.println("Erro em Original Value: " + e.getMessage());
        }
    }

    private static void testPercentageDelta() {
        try {
            System.out.println("Percentage Delta: " + CalculeUtil.percentageDelta(100, 120)); // 20
        } catch (Exception e) {
            System.out.println("Erro em Percentage Delta: " + e.getMessage());
        }
    }

    private static void testRuleOfThree() {
        try {
            System.out.println("Rule of Three: " + CalculeUtil.ruleOfThree(100, 50, 200)); // 100
        } catch (Exception e) {
            System.out.println("Erro em Rule of Three: " + e.getMessage());
        }
    }

    private static void testSamplingOne() {
        try {
            System.out.println("Sampling One: " + CalculeUtil.samplingOne(500, 10)); // 50
        } catch (Exception e) {
            System.out.println("Erro em Sampling One: " + e.getMessage());
        }
    }

    private static void testSamplingTwo() {
        try {
            System.out.println("Sampling Two: " + CalculeUtil.samplingTwo(50, 200)); // 25
        } catch (Exception e) {
            System.out.println("Erro em Sampling Two: " + e.getMessage());
        }
    }
}
