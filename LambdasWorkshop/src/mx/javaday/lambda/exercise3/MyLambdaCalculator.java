package mx.javaday.lambda.exercise3;

import java.util.Random;

/**
 *
 * @author jgmnx
 */
public class MyLambdaCalculator implements Calculator<Integer, Double> {

    @Override
    public Printer<Double> getPrinter() {
        return null; //TODO: print double with format with lambda expression
    }

    @Override
    public void add(Integer x, Integer y) {
        doOperation(null, x, y); //TODO: add operation with lambda expression
    }

    @Override
    public void substract(Integer x, Integer y) {
        doOperation(null, x, y); //TODO: substract operation with lambda expression
    }

    @Override
    public void multiply(Integer x, Integer y) {
        doOperation(null, x, y); //TODO: multiply operation with lambda expression
    }

    @Override
    public void divide(Integer x, Integer y) {
        doOperation(null, x, y); //TODO: divide operation with lambda expression
    }

    private static final Random r = new Random();

    static Generator<Integer> createGenerator() {
        return null; //TODO: create a generator with lambda expression
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
