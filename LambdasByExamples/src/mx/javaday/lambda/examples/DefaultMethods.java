package mx.javaday.lambda.examples;

/**
 *
 * @author jgmnx
 */
public class DefaultMethods {

    /**
     * Interface with a default method implementation.
     */
    static interface MyInterface {

        default void action() {
            System.out.println("This is a default implementation");
        }
    }

    /**
     * Concrete class implementing an interface with a default method. Note that
     * is not mandatory implement the interface method since it has already a
     * default implementation in the interface
     */
    static class MyClass implements MyInterface {
    }

    /**
     * Another concrete class implementing an interface with a default method.
     * Note that this class overrides the default method implementation.
     */
    static class MyOtherClass implements MyInterface {

        @Override
        public void action() {
            System.out.println("This is an implementation of action");
        }
    }

    /**
     * Example demonstrating the use the default method in interfaces.
     */
    public static void example1() {
        MyInterface impl1 = new MyClass();
        MyInterface impl2 = new MyOtherClass();
        impl1.action();
        impl2.action();
    }

    /**
     * Interface with a default method
     */
    static interface A {

        default void m() {
            System.out.println("hello from A");
        }
    }

    /**
     * Interface extending another interface with a default method and
     * overriding it.
     */
    static interface B extends A {

        @Override
        default void m() {
            System.out.println("hello from B");
        }
    }

    /**
     * Interface extending an interface with a default method.
     */
    static interface C extends A {
    }

    /**
     * Concrete class implementing an two interfaces: 1) One with an overridden
     * default method, and 2) Another interface without the same default method
     * overridden.
     */
    static class D implements B, C {
    }

    /**
     * Example showing how the default method is decided on runtime. It takes
     * the most concrete implementation.
     */
    public static void example2() {
        C c = new D();
        c.m();
    }

    public static void main(String... args) {
        example1();
        example2();
    }
}
