package mx.javaday.lambda.exercise2;

/**
 *
 * @author jgmnx
 */
public class LambdaRunnable {

    public static void main(String... args) throws InterruptedException {
        Thread t = null; //TODO: lambda expression for Runnable in Thread constructor
        t.start();
        Thread.sleep(1000);
        System.out.println("Good bye world...");
    }

}
