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
        SayHello sayHelloInEnglish = null; //TODO: lambda expression for english message
        LambdaHello.speak(sayHelloInEnglish);

        SayHello sayHelloInSpanish = null;  //TODO: lambda expression for spanish message
        LambdaHello.speak(sayHelloInSpanish);

        LambdaHello.speak(null); //TODO: lambda expression for french message

    }

}
