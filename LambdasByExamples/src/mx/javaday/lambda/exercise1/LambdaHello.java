package mx.javaday.lambda.exercise1;

/**
 *
 * @author jgmnx
 */
public class LambdaHello {

    static void speak(SayHello sayhello) {
        System.out.println(sayhello.salute());
    }

    public static void main(String... args) {
        SayHello sayHelloInEnglish = () -> "Hello World!!!";
        LambdaHello.speak(sayHelloInEnglish);

        SayHello sayHelloInSpanish = () -> "Ola k ase mundo!!!";
        LambdaHello.speak(sayHelloInSpanish);

        LambdaHello.speak(() -> "Bonjour monde!!!");

    }

}
