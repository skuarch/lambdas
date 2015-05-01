package mx.javaday.lambda.exercise1;

/**
 *
 * @author jgmnx
 */
public class Hello {

    static void speak(SayHello sayhello) {
        System.out.println(sayhello.salute());
    }

    public static void main(String... args) {
        SayHello sayHelloInEnglish = new SayHello() {

            @Override
            public String salute() {
                return "Hello World!!!";
            }
        };
        Hello.speak(sayHelloInEnglish);

        SayHello sayHelloInSpanish = new SayHello() {

            @Override
            public String salute() {
                return "Ola k ase mundo!!!";
            }
        };
        Hello.speak(sayHelloInSpanish);

        SayHello sayHelloinFrench = new SayHello() {

            @Override
            public String salute() {
                return "Bonjour monde!!!";
            }
        };
        Hello.speak(sayHelloinFrench);

    }

}
