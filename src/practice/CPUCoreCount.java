package practice;

import java.util.concurrent.ForkJoinPool;

public class CPUCoreCount {
    public static void main(String[] args) {
        int cores = Runtime.getRuntime().availableProcessors();
        System.out.println(cores);

        //ForkJoinPool.commonPool();
        System.out.println(ForkJoinPool.commonPool().getParallelism());
    }
}
