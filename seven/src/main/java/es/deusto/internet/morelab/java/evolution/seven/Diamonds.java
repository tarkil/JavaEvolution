package es.deusto.internet.morelab.java.evolution.seven;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by david on 2/11/15.
 */
public class Diamonds {

    public static void main (String[] args) {
        List<String> listConstructedWithoutTypes = new ArrayList(); // compilation warning

        List<String> listWithTypeSpecifiedInCOnstructor = new ArrayList<String>();

        List<String> listWithDiamondOperator = new ArrayList<>(); // new in Java 7
    }
}
