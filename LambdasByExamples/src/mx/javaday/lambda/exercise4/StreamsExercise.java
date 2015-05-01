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
            .filter(h -> h.getCity().equals("Stanford"))
            .forEach(System.out::println);
    }

    /**
     * Prints all the hackers with score higher than 9.
     *
     * @param hackers Collection of hackers
     */
    private static void filter2(Collection<Hacker> hackers) {
        hackers.stream()
            .filter(h -> h.getScore() > 9)
            .forEach(System.out::println);
    }

    /**
     * Prints the 5 hackers with higher scores.
     *
     * @param hackers Collection of hackers
     */
    private static void filter3(Collection<Hacker> hackers) {
        hackers.stream()
            .sorted((h1, h2) -> Double.compare(h2.getScore(), h1.getScore()))
            .limit(5)
            .forEach(System.out::println);
    }

    /**
     * Prints name, age and score for all the hackers from Cupertino.
     *
     * @param hackers Collection of hackers
     */
    private static void consumer1(Collection<Hacker> hackers) {
        hackers.stream()
            .filter(h -> h.getCity().equals("Cupertino"))
            .forEach(h -> System.out.printf("%s|%s|%.2f\n", h.getName(), h.getAge(), h.getScore()));
    }

    /**
     * Prints name, programming language and hobbies from all hackers older than
     * 20
     *
     * @param hackers Collection of hackers
     */
    private static void consumer2(Collection<Hacker> hackers) {
        hackers.stream()
            .filter(h -> h.getAge() > 20)
            .forEach(h -> System.out.printf("%s|%s|%s\n", h.getName(), h.getLanguage(), h.getHobbie()));
    }

    /**
     * Increases the score to all Java hackers and prints them.
     *
     * @param hackers Collection of hackers
     */
    private static void consumer3(Collection<Hacker> hackers) {
        hackers.stream()
            .filter(h -> h.getLanguage().equals("Java"))
            .forEach(h -> {
                double newScore = h.getScore() + 1;
                newScore = newScore > 10 ? 10 : newScore;
                h.setScore(newScore);
                System.out.println(h);
            });
    }

    /**
     * Prints the names of all Perl hackers with scores greater than 5.
     *
     * @param hackers Collection of hackers
     */
    private static void map1(Collection<Hacker> hackers) {
        hackers.stream()
            .filter(h -> h.getLanguage().equals("Perl"))
            .filter(h -> h.getScore() > 5)
            .map(h -> h.getName())
            .forEach(System.out::println);
    }

    /**
     * Prints the cities of all Java developers.
     *
     * @param hackers Collection of hackers
     */
    private static void map2(Collection<Hacker> hackers) {
        hackers.stream()
            .filter(h -> h.getLanguage().equals("Java"))
            .map(h -> h.getCity())
            .distinct()
            .forEach(System.out::println);
    }

    /**
     * Prints the hackers that match with a given set of nicknames.
     *
     * @param hackers Collection of hackers
     */
    private static void map3(Collection<String> nickNames, Collection<Hacker> hackers) {
        nickNames.stream()
            .map(n -> {
                return hackers.stream()
                        .filter(h -> h.getNickName().equals(n))
                        .collect(Collectors.toSet()); 
                }
            )
            .forEach(System.out::println);
    }

    /**
     * Prints the average age of Java hackers.
     *
     * @param hackers Collection of hackers
     */
    private static void reduce1(Collection<Hacker> hackers) {
        hackers.stream()
            .filter(h -> h.getLanguage().equals("Java"))
            .mapToDouble(Hacker::getAge)
            .average()
            .ifPresent(d -> System.out.printf("Average score of Java hackers is: %.2f\n", d));
    }

    /**
     * Prints the highest score of the Javascript hackers.
     *
     * @param hackers Collection of hackers
     */
    private static void reduce2(Collection<Hacker> hackers) {
        hackers.stream()
            .filter(h -> h.getLanguage().equals("Javascript"))
            .mapToDouble(Hacker::getScore)
            .max()
            .ifPresent(d -> System.out.printf("Highest score of Javascript hackers is: %.2f\n", d));
    }

    /**
     * Prints the lowest score of all the hackers.
     *
     * @param hackers Collection of hackers
     */
    private static void reduce3(Collection<Hacker> hackers) {
        hackers.stream()
            .mapToDouble(Hacker::getScore)
            .min()
            .ifPresent(d -> System.out.printf("Lowest score of all hackers is: %.2f\n", d));
    }

    /**
     * Prints the number of hackers by city.
     *
     * @param hackers Collection of hackers
     */
    private static void getHackersByCity(Collection<Hacker> hackers) {
        hackers.stream()
                .collect(Collectors.groupingBy(Hacker::getCity))
                .forEach((key, hackersSet) -> System.out.printf("%20s %d\n", key, hackersSet.size()));
        
    }

    /**
     * Prints the hacker with the highest score of each programming language.
     *
     * @param hackers Collection of hackers
     */
    private static void getMaxScoredHackerByLanguage(Collection<Hacker> hackers) {
        /*
        Collector<Hacker, ?, Optional<Hacker>> maxScoreHackerCollector = Collectors.maxBy((h1, h2) -> Double.compare(h1.getScore(), h2.getScore()));
        Collector<Hacker, ?, Map<String, Optional<Hacker>>> collector = Collectors.groupingBy(Hacker::getLanguage, maxScoreHackerCollector);
        Map<String, Optional<Hacker>> maxScoreHackerByLanguage = hackers.stream().collect(collector);
        maxScoreHackerByLanguage.forEach((language, hacker) -> System.out.printf("%20s -> %s\n", language, hacker.get()));
        */
        hackers.stream()
                .collect(Collectors.groupingBy(Hacker::getLanguage,
                            Collectors.maxBy(
                                    (Hacker h1, Hacker h2) -> Double.compare(h1.getScore(), h2.getScore()))))
                .forEach((language, hacker) -> System.out.printf("%20s -> %s\n", language, hacker.get()));
        
    }

    public static void main(String... args) {
        Set<Hacker> hackers = HackersHelper.getInstance().getHackers(10);
        System.out.println("################### ORIGINAL ###################");
        hackers.forEach(System.out::println);
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
        getHackersByCity(hackers);
        getMaxScoredHackerByLanguage(hackers);
    }

}
