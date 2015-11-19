package es.deusto.internet.morelab.java.evolution.miscellaneous;

/**
 * Created by david on 19/11/15.
 */
public class NaNComparison {

    public static void main (String[] args) {
        double a = Double.NaN;


        if (a == Double.NaN) {
            System.out.println("A is a  Double.NaN"); // Expected result
        } else {
            System.out.println("A is a number "); // What really happens
        }

        double b = Double.NaN;

        if (a == b) {
            System.out.println("A is equal to b"); // Expected result
        } else {
            System.out.println("A is not equal to b"); // What really happens

        }

        //How to avoid it

        if (Double.isNaN(a)) {
            System.out.println("A is a  Double.NaN"); // Expected result
        } else {
            System.out.println("A is a number ");
        }


        if (Double.compare(b, a) == 0) {
            System.out.println("A is equal to b"); // Expected result
        } else {
            System.out.println("A is not equal to b");

        }

    }

}
