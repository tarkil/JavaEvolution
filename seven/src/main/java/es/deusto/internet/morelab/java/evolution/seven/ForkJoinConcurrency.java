package es.deusto.internet.morelab.java.evolution.seven;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;
import java.util.concurrent.RecursiveTask;

/**
 * Created by david on 3/11/15.
 */
public class ForkJoinConcurrency {

    static class FibonnaciRecursiveTaskExample extends RecursiveTask<Integer> {

        final int n;
        FibonnaciRecursiveTaskExample(int n) {
            this.n = n;
        }

        @Override
        protected Integer compute() {
            if (n <= 1)
                return n;
            FibonnaciRecursiveTaskExample f1 = new FibonnaciRecursiveTaskExample(n - 1);
            f1.fork();
            FibonnaciRecursiveTaskExample f2 = new FibonnaciRecursiveTaskExample(n - 2);
            return f2.invoke() + f1.join(); // Invoke is equivalent in effect to the sequence fork(); join(); but may be more efficient.
        }
    }

    public static void main(String[] args) {
        int cores = Runtime.getRuntime().availableProcessors();
        ForkJoinPool forkJoinPool = new ForkJoinPool(cores);

        FibonnaciRecursiveTaskExample fibonnaciTask = new FibonnaciRecursiveTaskExample(12);

        forkJoinPool.execute(fibonnaciTask);

        try {
            System.out.println("Result: " + fibonnaciTask.get());
        } catch (InterruptedException | ExecutionException e) {
            System.out.println("Program has crashed: " + e.getLocalizedMessage());
        }


    }
}
