package designPatterns.decorator;

import java.util.function.DoubleUnaryOperator;

/**
 * @author rohankar
 */
public class AnotherDecorator {

    public static class SalaryCalculator implements DoubleUnaryOperator {

        @Override
        public double applyAsDouble(final double salary) {
            return salary / 12;
        }

    }

    public static class Taxes {

        public static double generalTax(final double salary) {
            return salary * .10;
        }

        public static double healthInsurence(final double salary) {
            return salary * .10;
        }

    }

    public static void main(final String[] args) {
        final double salaryInHand = new SalaryCalculator() //
            .andThen(Taxes::generalTax) //
            .andThen(Taxes::healthInsurence) //
            .applyAsDouble(10_000);
        System.err.println(salaryInHand);
    }
}
