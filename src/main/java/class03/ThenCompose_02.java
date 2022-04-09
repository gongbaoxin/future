package class03;

import java.util.concurrent.CompletableFuture;

public class ThenCompose_02 {

    public static void main(String[] args){
        SmallTool.printTimeAndThread("小白进入餐厅");
        SmallTool.printTimeAndThread("小白点了番茄炒蛋白+ 米饭");

        CompletableFuture<String> future = CompletableFuture.supplyAsync(()->{
            SmallTool.printTimeAndThread("厨师炒菜");
            SmallTool.sleepMillis(200);
            return "番茄炒蛋";
        }).thenCompose(dish ->CompletableFuture.supplyAsync(() ->{
            SmallTool.printTimeAndThread("服务员打饭");
            SmallTool.sleepMillis(100);
            return dish + "+ 米饭 做好了";
        }));



        SmallTool.printTimeAndThread("小白在打王者");
        SmallTool.printTimeAndThread(String.format("%s ，小白开吃", future.join()));
    }

}
