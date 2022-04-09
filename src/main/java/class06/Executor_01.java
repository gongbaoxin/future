package class06;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Executor_01 {

    public static void main(String[] args){
        //单线程
        Executors.newSingleThreadExecutor();

        Executors.newCachedThreadPool();

        ExecutorService executor = Executors.newFixedThreadPool(3);
        //executor.submit();
    }

}
