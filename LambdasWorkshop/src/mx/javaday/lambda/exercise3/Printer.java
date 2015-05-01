package mx.javaday.lambda.exercise3;

/**
 *
 * @author jgmnx
 */
@FunctionalInterface
public interface Printer<T> {

    void print(T t);

}
