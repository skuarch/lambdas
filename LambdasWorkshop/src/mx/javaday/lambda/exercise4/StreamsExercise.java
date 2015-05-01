package mx.javaday.lambda.exercise4;

import java.util.Arrays;
import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

/**
 *
 * @author jgmnx
 */
public class StreamsExercise {

    /**
     * Prints all hackers from Stanford.
     *
     * @param hackers Collection of hackers
     */
    private static void filter1(Collection<Hacker> hackers) {
        hackers.stream()
            .filter(null) //TODO: boolean test(T t) with lambda expression
            .forEach(null); //TODO: void accept(T t) with method reference
    }

    /**
     * Prints all the hackers with score higher than 9.
     *
     * @param hackers Collection of hackers
     */
    private static void filter2(Collection<Hacker> hackers) {
        hackers.stream()
            .filter(null) //TODO: boolean test(T t) with lambda expression
            .forEach(null); //TODO: void accept(T t) with method reference
    }

    /**
     * Prints the 5 hackers with higher scores.
     *
     * @param hackers Collection of hackers
     */
    private static void filter3(Collection<Hacker> hackers) {
        hackers.stream()
            .sorted(null) //TODO: sort with lambda expression
            .limit(5)
            .forEach(null); //TODO: void accept(T t) with method reference
    }

    /**
     * Prints name, age and score for all the hackers from Cupertino.
     *
     * @param hackers Collection of hackers
     */
    private static void consumer1(Collection<Hacker> hackers) {
        hackers.stream()
            .filter(null) //TODO: boolean test(T t) with lambda expression
            .forEach(null); //TODO: void accept(T t) with method reference
    }

    /**
     * Prints name, programming language and hobbies from all hackers older than
     * 20
     *
     * @param hackers Collection of hackers
     */
    private static void consumer2(Collection<Hacker> hackers) {
        hackers.stream()
            .filter(null) //TODO: boolean test(T t) with lambda expression
            .forEach(null); //TODO: void accept(T t) with method reference
    }

    /**
     * Increases the score to all Java hackers and prints them.
     *
     * @param hackers Collection of hackers
     */
    private static void consumer3(Collection<Hacker> hackers) {
        hackers.stream()
            .filter(null) //TODO: boolean test(T t) with lambda expression
            .forEach(null); //TODO: void accept(T t) with method reference
    }

    /**
     * Prints the names of all Perl hackers with scores greater than 5.
     *
     * @param hackers Collection of hackers
     */
    private static void map1(Collection<Hacker> hackers) {
        hackers.stream()
            .filter(null) //TODO: boolean test(T t) with lambda expression
            .filter(null) //TODO: boolean test(T t) with lambda expression
            .map(null) //TODO: R apply(T t) with lambda expression
            .forEach(null); //TODO: void accept(T t) with method reference
    }

    /**
     * Prints the cities of all Java developers.
     *
     * @param hackers Collection of hackers
     */
    private static void map2(Collection<Hacker> hackers) {
        hackers.stream()
            .filter(null) //TODO: boolean test(T t) with lambda expression
            .map(null) //TODO: R apply(T t) with lambda expression
            .distinct()
            .forEach(null); //TODO: void accept(T t) with method reference
    }

    /**
     * Prints the hackers that match with a given set of nicknames.
     *
     * @param hackers Collection of hackers
     */
    private static void map3(Collection<String> nickNames, Collection<Hacker> hackers) {
        nickNames.stream()
            .map(n -> hackers.stream()
            .filter(null) //TODO: boolean test(T t) with lambda expression 
            .collect(Collectors.<Hacker>toSet()))
            .forEach(null); //TODO: void accept(T t) with method reference
    }

    /**
     * Prints the average age of Java hackers.
     *
     * @param hackers Collection of hackers
     */
    private static void reduce1(Collection<Hacker> hackers) {
        hackers.stream()
            .filter(null) //TODO: boolean test(T t) with lambda expression
            .mapToDouble(null) //TODO: R apply(T t) with lambda expression
            .average()
            .ifPresent(null);   //TODO: void accept(T t) with method reference
    }

    /**
     * Prints the highest score of the Javascript hackers.
     *
     * @param hackers Collection of hackers
     */
    private static void reduce2(Collection<Hacker> hackers) {
        hackers.stream()
            .filter(null) //TODO: boolean test(T t) with lambda expression
            .mapToDouble(null) //TODO: R apply(T t) with lambda expression
            .max()
            .ifPresent(null); //TODO: void accept(T t) with method reference
    }

    /**
     * Prints the lowest score of all the hackers.
     *
     * @param hackers Collection of hackers
     */
    private static void reduce3(Collection<Hacker> hackers) {
        hackers.stream()
            .mapToDouble(null) //TODO: R apply(T t) with lambda expression
            .min()
            .ifPresent(null); //TODO: void accept(T t) with method reference
    }

    public static void main(String... args) {
        Set<Hacker> hackers = HackersHelper.getInstance().getHackers(10);
        System.out.println("################### ORIGINAL ###################");
        hackers.forEach(null); //TODO: print with method reference
        System.out.println("#################### REPORT ####################");

        filter1(hackers);
        filter2(hackers);
        filter3(hackers);
        consumer1(hackers);
        consumer2(hackers);
        consumer3(hackers);
        map1(hackers);
        map2(hackers);
        map3(Arrays.asList("subzero", "anonymous", "h4ck3r"), hackers);
        reduce1(hackers);
        reduce2(hackers);
        reduce3(hackers);
    }

}
