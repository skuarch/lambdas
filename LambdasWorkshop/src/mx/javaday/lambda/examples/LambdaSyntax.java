package mx.javaday.lambda.examples;

import java.util.Arrays;
import java.util.Comparator;

/**
 *
 * @author jgmnx
 */
public class LambdaSyntax {

    /**
     * Shows how to use a lambda expression to create a Thread.
     */
    private static void syntaxExample1() {
        Runnable r = () -> System.out.println("Hello Lambda World!!!");
        new Thread(r).start();
    }

    /**
     * Shows how to use a lambda expression to sort an Integer array.
     */
    private static void syntaxExample2() {
        Integer[] myIntArray = new Integer[]{5, 3, 2, 4, 1};
        Arrays.sort(myIntArray,
            (Integer x, Integer y) -> {
                return (x < y) ? -1 : ((x == y) ? 0 : 1);
            }
            );
        System.out.println(Arrays.toString(myIntArray));
    }

    /**
     * Shows how to use a lambda expression to sort an Integer array, omitting
     * the parenthesis in the block of the lambda expression.
     */
    private static void syntaxExample3() {
        Integer[] myIntArray = new Integer[]{5, 3, 2, 4, 1};
        Arrays.sort(myIntArray,
            (Integer x, Integer y)
            -> (x < y) ? -1 : ((x == y) ? 0 : 1)
            );
        System.out.println(Arrays.toString(myIntArray));
    }

    /**
     * Shows how to use a lambda expression to sort an Integer array, omitting
     * the type parameters.
     */
    private static void syntaxExample4() {
        Integer[] myIntArray = new Integer[]{5, 3, 2, 4, 1};
        Arrays.sort(myIntArray, (x, y) -> (x < y) ? -1 : ((x == y) ? 0 : 1));
        System.out.println(Arrays.toString(myIntArray));
    }

    /**
     * Shows how to use a lambda expression to sort a String array based on the
     * length of the strings.
     */
    private static void syntaxExample5() {
        String[] myStrArray = new String[]{"1", "111", "1111", "11", "11111"};
        Comparator<String> c = (s1, s2) -> Integer.compare(s1.length(), s2.length());
        Arrays.sort(myStrArray, c);
        System.out.println(Arrays.toString(myStrArray));
    }

    public static void main(String... args) {
        syntaxExample1();
        syntaxExample2();
        syntaxExample3();
        syntaxExample4();
        syntaxExample5();
    }

}
