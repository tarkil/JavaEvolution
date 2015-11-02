package es.deusto.internet.morelab.java.evolution.seven;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.Buffer;

/**
 * Created by david on 2/11/15.
 */
public class TryWithResources {
        public static void main (String[] args) {
            try (final BufferedReader bufferedReader1 = new BufferedReader(
                    new InputStreamReader(TryWithResources.class.getClassLoader().getResourceAsStream("TryWithResourcesFile1.txt")));
                 final BufferedReader bufferedReader2 = new BufferedReader(
                         new InputStreamReader(TryWithResources.class.getClassLoader().getResourceAsStream("TryWithResourcesFile2.txt")))) {
                String line1 = bufferedReader1.readLine();
                String line2 = bufferedReader2.readLine() ;
                while ( line1   != null || line2 != null ) {
                    System.out.println(line1 != null ? line1 : "");
                    System.out.println(line2 != null ? line2 : "") ;
                    line1 = bufferedReader1.readLine();
                    line2 = bufferedReader2.readLine() ;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
}
