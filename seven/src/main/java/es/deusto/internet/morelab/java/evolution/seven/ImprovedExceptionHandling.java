package es.deusto.internet.morelab.java.evolution.seven;

import java.io.*;
import java.sql.SQLDataException;
import java.sql.SQLException;
import java.util.Random;

/**
 * Created by david on 2/11/15.
 */
public class ImprovedExceptionHandling {

    public static void throwExceptionMethod() throws IOException, SQLDataException {
        Random rnd = new Random();
        if (rnd.nextBoolean()) {
            throw new IOException("IOException test");
        } else {
            throw new SQLDataException("SQLDataException test");
        }
    }

    public static void reThrowExceptionMethod() throws IOException, SQLDataException {
        try {
            throwExceptionMethod();
        } catch (Exception e) {
            System.out.println("GENERAL FAILURE:  " + e.getLocalizedMessage());
            throw e;
        }
    }

    public static void main (String[] args) {
        try {
            throwExceptionMethod();
        } catch (IOException  | SQLDataException e) {
            System.out.println("GENERAL FAILURE:  " + e.getLocalizedMessage());
        }

        try {
            reThrowExceptionMethod();
        } catch (IOException  | SQLDataException e) {
            System.out.println("GENERAL FAILURE:  " + e.getLocalizedMessage());
        }

    }
}
