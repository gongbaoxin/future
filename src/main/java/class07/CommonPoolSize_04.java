package class07;

import java.util.concurrent.ForkJoinPool;

public class CommonPoolSize_04 {

    public static void main(String[] args){
        System.out.println(Runtime.getRuntime().availableProcessors());

        //查看 当前线程数
        System.out.println(ForkJoinPool.commonPool().getPoolSize());

        //查看 最大线程数
        System.out.println(ForkJoinPool.getCommonPoolParallelism());
    }
}
