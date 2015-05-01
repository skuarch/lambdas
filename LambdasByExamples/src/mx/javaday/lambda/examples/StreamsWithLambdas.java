package mx.javaday.lambda.examples;

import java.util.Collection;
import java.util.Set;
import java.util.function.Predicate;
import java.util.function.ToDoubleFunction;
import mx.javaday.lambda.exercise4.Hacker;
import mx.javaday.lambda.exercise4.HackersHelper;

/**
 *
 * @author jgmnx
 */
public class StreamsWithLambdas {

    private static final HackersHelper helper = HackersHelper.getInstance();

    /**
     * Prints the highest score of Java developers using external iteration
     *
     * @param hackers Collection of hackers
     */
    private static void exampleWithJava(Collection<Hacker> hackers) {
        double highestScore = 0.0;
        for (Hacker s : hackers) {
            if ("Java".equals(s.getLanguage())) {
                if (highestScore < s.getScore()) {
                    highestScore = s.getScore();
                }
            }
        }
        System.out.println("Highest score is " + highestScore);
    }

    /**
     * Prints the highest score of Java hackers using streams with anonymous
     * classes implementing functional interfaces
     *
     * @param hackers Collection of hackers
     */
    private static void exampleWithInnerClass(Collection<Hacker> hackers) {
        double highestScore = hackers.stream()
            .filter(new Predicate<Hacker>() {
                @Override
                public boolean test(Hacker s) {
                    return "Java".equals(s.getLanguage());
                }
            })
            .mapToDouble(new ToDoubleFunction<Hacker>() {
                @Override
                public double applyAsDouble(Hacker s) {
                    return s.getScore();
                }
            })
            .max().orElseThrow(helper.getHackerNotFoundExceptionSupplier());
        System.out.println("Highest score is " + highestScore);
    }

    /**
     * Prints the highest score of Java hackers using lambdas
     *
     * @param hackers Collection of hackers
     */
    private static void exampleWithLambdas(Collection<Hacker> hackers) {
        double highestScore = hackers.stream()
            .filter(s -> "Java".equals(s.getLanguage()))
            .mapToDouble(s -> s.getScore())
            .max().orElseThrow(helper.getHackerNotFoundExceptionSupplier());
        System.out.println("Highest score is " + highestScore);
    }

    /**
     * Prints the highest score of Java hackers using lambdas and method
     * references
     *
     * @param hackers Collection of hackers
     */
    private static void exampleWithLambdasAndMethodRef(Collection<Hacker> hackers) {
        double highestScore = hackers.stream()
            .filter(s -> "Java".equals(s.getLanguage()))
            .mapToDouble(Hacker::getScore)
            .max().orElseThrow(helper.getHackerNotFoundExceptionSupplier());
        System.out.println("Highest score is " + highestScore);
    }

    public static void main(String... args) {
        Set<Hacker> hackers = helper.getHackers(10);
        hackers.forEach(System.out::println);
        exampleWithJava(hackers);
        exampleWithInnerClass(hackers);
        exampleWithLambdas(hackers);
        exampleWithLambdasAndMethodRef(hackers);
    }
}