package mx.javaday.lambda.exercise3;

/**
 *
 * @author jgmnx
 */
public interface Calculator<T, R> {

    default R doOperation(Operation<T, R> operator, T x, T y) {
        R result = operator.apply(x, y);
        Printer<R> printer = getPrinter();
        if (printer != null) {
            printer.print(result);
        }
        return result;
    }
    
    Printer<R> getPrinter();

    void add(T x, T y);

    void substract(T x, T y);

    void multiply(T x, T y);

    void divide(T x, T y);

}
