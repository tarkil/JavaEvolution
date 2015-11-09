package es.deusto.internet.morelab.java.evolution.eight.functionalInterfaces;

import java.lang.*;

/**
 * Created by david on 9/11/15.
 */

@java.lang.FunctionalInterface
public interface FunctionalInterfaceWithDefaultMethods {

    int add(int x, int y);

    default boolean isNegative(int x) {
        return x < 0;
    }
}
