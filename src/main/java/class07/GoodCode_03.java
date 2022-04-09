package class07;

import class03.SmallTool;

import java.util.concurrent.CompletableFuture;
import java.util.stream.IntStream;

public class GoodCode_03 {

    public static void main(String[] args){
        SmallTool.printTimeAndThread("小白和小伙伴们 进餐厅点菜");
        System.setProperty("java.util.concurrent.ForkJoinPool.common.parallelism", "12");

        long startTime = System.currentTimeMillis();

        CompletableFuture[] dishes = IntStream.rangeClosed(1,7)
                .mapToObj(i -> new Dish("菜" +i , 1))
                .map(dish ->CompletableFuture.runAsync(dish::make))
                .toArray(size -> new CompletableFuture[size]);

        CompletableFuture.allOf(dishes).join();

        SmallTool.printTimeAndThread("菜做好了,上桌" + (System.currentTimeMillis() - startTime));

    }
}
