package es.deusto.internet.morelab.java.evolution.eight;

import java.util.stream.IntStream;

/**
 * Created by david on 22/11/15.
 */
public class ParallelStreams {

    public static void main (String[] args) {
        IntStream.range(0,100).parallel().forEach(i -> System.out.println(i));
        
    }
}
