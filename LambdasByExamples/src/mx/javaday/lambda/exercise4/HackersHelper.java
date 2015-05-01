package mx.javaday.lambda.exercise4;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.function.Supplier;

/**
 *
 * @author jgmnx
 */
public final class HackersHelper {

    private final Random random = new Random();
    private final NumberFormat scoreFormatter = new DecimalFormat("#.00");

    private final String[] firstNames = new String[]{"James", "Chris", "Robert", "Andy", "John", "Albert", "Sam", "Barry", "Mark", "Alan"};
    private final String[] lastNames = new String[]{"Smith", "Johnson", "Williams", "Jones", "Brown", "Wilson", "Taylor", "Miller", "White", "Lee"};
    private final String[] cities = new String[]{"San Francisco", "Sunnyvale", "Stanford", "Palo Alto", "Cupertino", "Milpitas", "Mountain View", "San Carlos", "Belmont", "Menlo Park"};
    private final String[] hobbies = new String[]{"Watching TV", "Hunting", "Scripting", "Hicking", "Swimming", "Running", "Painting", "Camping", "Relaxing", "Sleeping"};
    private final String[] languages = new String[]{"Java", "Python", "Perl", "Javascript", "Scala", "Jython", "Ruby", "Groovy", "Lisp", "Objective-C"};
    private final String[] nickNames = new String[]{"neo", "codex", "hex", "subzero", "anonymous", "mafiaboy", "geohotz", "dextro", "h4ck3r", "c0mrade"};

    private <T> T getRandomElementOf(T[] elements) {
        return elements[random.nextInt(elements.length)];
    }

    private final Supplier<String> namesGenerator = () -> getRandomElementOf(firstNames) + " " + getRandomElementOf(lastNames);
    private final Supplier<String> citiesGenerator = () -> getRandomElementOf(cities);
    private final Supplier<String> hobbiesGenerator = () -> getRandomElementOf(hobbies);
    private final Supplier<String> languagesGenerator = () -> getRandomElementOf(languages);
    private final Supplier<String> nickNamesGenerator = () -> getRandomElementOf(nickNames);
    private final Supplier<Integer> agesGenerator = () -> 15 + random.nextInt(30);
    private final Supplier<Double> scoresGenerator = () -> Double.valueOf(scoreFormatter.format(10 * random.nextDouble()));

    private final Supplier<Hacker> hackerGenerator = ()
        -> new Hacker(namesGenerator.get(), citiesGenerator.get(),
        agesGenerator.get(), hobbiesGenerator.get(), languagesGenerator.get(),
        scoresGenerator.get(), nickNamesGenerator.get());

    private final Supplier<RuntimeException> hackerNotFoundExceptionGenerator = () -> {
        throw new RuntimeException("Java hacker not found");
    };

    private static final HackersHelper instance = new HackersHelper();

    private HackersHelper() {
        // No-op
    }

    public static HackersHelper getInstance() {
        return instance;
    }

    /**
     * Generates a set of n hackers.
     *
     * @param n Number of hackers to be generated
     * @return a Set of n hackers
     */
    public Set<Hacker> getHackers(int n) {
        Set<Hacker> hackers = new HashSet<>();
        for (int i = 0; i < n; i++) {
            hackers.add(instance.hackerGenerator.get());
        }
        return hackers;
    }

    /**
     * Returns a runtime exception when a hackers is not found over a stream
     *
     * @return a Runtime exception when a hackers is not found over a stream
     */
    public Supplier<RuntimeException> getHackerNotFoundExceptionSupplier() {
        return instance.hackerNotFoundExceptionGenerator;
    }

}