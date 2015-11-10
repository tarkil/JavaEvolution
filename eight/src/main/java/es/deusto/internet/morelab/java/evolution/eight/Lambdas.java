package es.deusto.internet.morelab.java.evolution.eight;

import com.sun.deploy.util.ArrayUtil;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * Created by david on 9/11/15.
 */
public class Lambdas {



    public static void main (String[] args) {

        Predicate<Integer> isPositive = (i) -> i > 0;
        Consumer<Integer> printNumber = (i) -> System.out.println(i);
        Function<Integer, Double> circlePerimeter  = (i) -> 2 * Math.PI * i;

        try (BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in))) {

            System.out.println("Radius in meters: ");
            String temp = bufferRead.readLine();
            Integer radius = Integer.parseInt(temp.trim());

            if (isPositive.test(radius)) {

                final Double perimeter = circlePerimeter.apply(radius);
                System.out.println("The perimeter is " + perimeter);

            } else {
                System.out.print("The number is not positive ");
                printNumber.accept(radius);
            }

        } catch (IOException | NumberFormatException e) {
            System.out.println("The radius must be a valid integer");
        }


    }
}
