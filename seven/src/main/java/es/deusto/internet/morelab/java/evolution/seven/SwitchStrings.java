package es.deusto.internet.morelab.java.evolution.seven;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by david on 2/11/15.
 */
public class SwitchStrings {

    public static void main (String[] args) {

        try (BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in))) {
            
            System.out.println("First number: ");
            String temp = bufferRead.readLine();
            final float firstNumber = Float.parseFloat(temp);

            System.out.println("Second number: ");
            temp = bufferRead.readLine();
            final float secondNumber =Float.parseFloat(temp);

            System.out.println("Operation option: ");
            String operation = bufferRead.readLine();

            switch (operation) {
                case "+": System.out.println("Result: " + (firstNumber + secondNumber));
                    break;
                case "-": System.out.println("Result: " + (firstNumber - secondNumber) );
                    break;
                case "*": System.out.println("Result: " + (firstNumber * secondNumber));
                    break;
                case "/": System.out.println("Result: " + (firstNumber / secondNumber));
                    break;
                default: System.out.println("Operation \""+  operation + "\" is not supported");

            }


        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
