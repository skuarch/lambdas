package mx.javaday.lambda.exercise2;

/**
 *
 * @author jgmnx
 */
public class LambdaRunnable {

    public static void main(String... args) throws InterruptedException {
        Thread t = new Thread(() -> {
            System.out.println("Hello world!!!");
        });

        t.start();
        Thread.sleep(1000);
        System.out.println("Good bye world...");
    }

}
