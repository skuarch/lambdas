package mx.javaday.lambda.exercise3;

import java.util.Random;

/**
 *
 * @author jgmnx
 */
public class MyLambdaCalculator implements Calculator<Integer, Double> {

    @Override
    public Printer<Double> getPrinter() {
        return (r) -> System.out.printf("%.2f\n", r);
    }

    @Override
    public void add(Integer x, Integer y) {
        doOperation((x1, y1) -> (double) x1 + y1, x, y);
    }

    @Override
    public void substract(Integer x, Integer y) {
        doOperation((x1, y1) -> (double) x1 - y1, x, y);
    }

    @Override
    public void multiply(Integer x, Integer y) {
        doOperation((x1, y1) -> (double) x1 * y1, x, y);
    }

    @Override
    public void divide(Integer x, Integer y) {
        doOperation((x1, y1) -> y1 == 0 ? Double.POSITIVE_INFINITY : new Double(x1 / y1), x, y);
    }

    private static final Random r = new Random();

    static Generator<Integer> createGenerator() {
        return () -> r.nextInt(10);
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
        Calculator<Integer, Double> classicCalculator = new MyLambdaCalculator();
        MyLambdaCalculator.test(classicCalculator, createGenerator());
    }

}
