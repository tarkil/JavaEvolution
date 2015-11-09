package es.deusto.internet.morelab.java.evolution.eight.functionalInterfaces;

/**
 * Created by david on 9/11/15.
 */
public class FunctionalInterfaceExample {

    static class TraditionalAddMethod implements FunctionalInterface {

        public int add(int x, int c) {
            return x + c;
        }
    }


    private static void addNumberWithFunctionalInterface(FunctionalInterface functionalInterface) {

        System.out.println(functionalInterface.add(1, 2));
    }

    private static void addNumberWithFunctionalInterfaceWithDefaultMethods(FunctionalInterfaceWithDefaultMethods functionalInterface) {

        System.out.println(functionalInterface.add(1, 2));
    }

    public static void main (String[] args) {

        addNumberWithFunctionalInterface(new TraditionalAddMethod());

        addNumberWithFunctionalInterface((a, b) -> a + b );

        addNumberWithFunctionalInterfaceWithDefaultMethods((a, b) -> a + b );

    }
}
