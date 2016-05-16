package com.corejava.concurrency.forkjoin;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

/**
 * Created by gavin on 16-5-15.
 */
public class ForkJoinDemo {
    static final int SIZE = 60000;
    static final Logger log = LoggerFactory.getLogger(ForkJoinDemo.class);



    public static void main(String...args){
        System.out.println("Start at " + new Date().toString());
        int contents [] = new int[SIZE];
        for(int i=0; i<SIZE; i++){
            contents[i] = i;
        }

        ContentTransformer transformer = new ContentTransformer(contents, 0, SIZE, "T0");
        ForkJoinPool pool = new ForkJoinPool();
        pool.invoke(transformer);

        long result = transformer.join();

        //System.out.println("Result: " + result);
        log.info("Result: " + result);
        System.out.println("Finished at "+new Date().toString());
    }

    static class ContentTransformer extends RecursiveTask<Long> {
        static int amount = 0;
        private static final long THRESHOLD = 1000;
        private int[] contents;
        private int from;
        private int to;

        private String label;

        public ContentTransformer(int[] contents, int from, int to, String label) {
            this.contents = contents;
            this.from = from;
            this.to = to;
            this.label = label;
        }

        @Override
        protected Long compute() {
            if(to - from < THRESHOLD){
                long count = 0;
                for(int i= from; i< to; i++) {
                    String output = Thread.currentThread().getName() + " -- " + contents[i] + " -- " + label;
                    //System.out.println(output);
                    log.debug(output);
                    count++;
                }

                return count;
            }else{
                int mid = (from + to) / 2;
                ContentTransformer first = new ContentTransformer(contents, from, mid, "T"+(++amount));
                ContentTransformer second = new ContentTransformer(contents, mid, to, "T"+(++amount));
                invokeAll(first, second);

                return first.join() + second.join();
            }
        }
    }
}
