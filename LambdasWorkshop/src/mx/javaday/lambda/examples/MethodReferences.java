package mx.javaday.lambda.examples;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 *
 * @author jgmnx
 */
public class MethodReferences {

    private static List<Integer> getIntList() {
        return Arrays.asList(5, 3, 2, 4, 1);
    }

    /**
     * Sorts a list of Integers using an anonymous inner class.
     */
    private static void sortWithJava() {
        List<Integer> intList1 = getIntList();
        Collections.sort(intList1, new Comparator<Integer>() {
            @Override
            public int compare(Integer x, Integer y) {
                return (x < y) ? -1 : ((x == y) ? 0 : 1);
            }
        });
        System.out.println(intList1);
    }

    /**
     * Sorts a list of Integers using a lambda expression.
     */
    private static void sortWithLambdas() {
        List<Integer> intList2 = getIntList();
        Collections.sort(intList2, (x, y) -> (x < y) ? -1 : ((x == y) ? 0 : 1));
        System.out.println(intList2);
    }

    /**
     * Sorts a list of Integers using a method reference.
     */
    private static void sortWithMethodRef() {
        List<Integer> intList3 = getIntList();
        Collections.sort(intList3, Integer::compare);
        System.out.println(intList3);
    }

    public static void main(String... args) {
        sortWithJava();
        sortWithLambdas();
        sortWithMethodRef();
    }

}
