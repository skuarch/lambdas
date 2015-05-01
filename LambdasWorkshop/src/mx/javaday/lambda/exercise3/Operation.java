package mx.javaday.lambda.exercise3;

/**
 *
 * @author jgmnx
 */
@FunctionalInterface
public interface Operation<T, R> {

    R apply(T x, T y);

}
