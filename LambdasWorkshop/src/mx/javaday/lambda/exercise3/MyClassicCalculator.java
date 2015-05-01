package mx.javaday.lambda.exercise3;

import java.util.Random;

/**
 *
 * @author jgmnx
 */
public class MyClassicCalculator implements Calculator<Integer, Double> {

    @Override
    public Printer<Double> getPrinter() {
        return new Printer<Double>() {

            @Override
            public void print(Double t) {
                System.out.printf("%.2f", t);
            }
        };
    }

    @Override
    public void add(Integer x, Integer y) {
        doOperation(new Operation<Integer, Double>() {
            @Override
            public Double apply(Integer x, Integer y) {
                return new Double(x + y);
            }
        }, x, y);
    }

    @Override
    public void substract(Integer x, Integer y) {
        doOperation(new Operation<Integer, Double>() {
            @Override
            public Double apply(Integer x, Integer y) {
                return new Double(x - y);
            }
        }, x, y);
    }

    @Override
    public void multiply(Integer x, Integer y) {
        doOperation(new Operation<Integer, Double>() {
            @Override
            public Double apply(Integer x, Integer y) {
                return new Double(x * y);
            }
        }, x, y);
    }

    @Override
    public void divide(Integer x, Integer y) {
        doOperation(new Operation<Integer, Double>() {
            @Override
            public Double apply(Integer x, Integer y) {
                return y == 0 ? Double.POSITIVE_INFINITY : new Double(x / y);
            }
        }, x, y);
    }

    private static final Random r = new Random();

    static Generator<Integer> createGenerator() {
        return new Generator<Integer>() {

            @Override
            public Integer get() {
                return r.nextInt(10);
            }
        };
    }

    static void test(Calculator<Integer, Double> calculator, Generator<Integer> generator) {
        int x, y;
        x = generator.get();
        y = generator.get();
        System.out.print("Testing add " + x + " + " + y + " = ");
        calculator.add(x, y);
        x = generator.get();
        y = generator.get();
        System.out.print("Testing substract " + x + " - " + y + " = ");
        calculator.substract(x, y);
        x = generator.get();
        y = generator.get();
        System.out.print("Testing multiply " + x + " * " + y + " = ");
        calculator.multiply(x, y);
        x = generator.get();
        y = generator.get();
        System.out.print("Testing divide " + x + " / " + y + " = ");
        calculator.divide(x, y);
    }

    public static void main(String... args) {
        Calculator<Integer, Double> classicCalculator = new MyClassicCalculator();
        MyClassicCalculator.test(classicCalculator, createGenerator());
    }

}
