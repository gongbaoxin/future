package class04;

import class03.SmallTool;

import java.util.concurrent.CompletableFuture;

public class ThenApply_01 {

    public static void main(String[] args){
        SmallTool.printTimeAndThread("小白吃好了");
        SmallTool.printTimeAndThread("小白 结账，要求开发票");

        /*CompletableFuture<String> invoice = CompletableFuture.supplyAsync(() ->{
            SmallTool.printTimeAndThread("服务员收款500元");
            SmallTool.sleepMillis(100);

            CompletableFuture<String> waiter = CompletableFuture.supplyAsync(() ->{
                SmallTool.printTimeAndThread("服务员开发票 面额500元");
                SmallTool.sleepMillis(200);
                return "500元发票";
            });

            return waiter.join();

        });*/

        CompletableFuture<String> invoice = CompletableFuture.supplyAsync(() ->{
            SmallTool.printTimeAndThread("服务员收款500元");
            SmallTool.sleepMillis(100);
            return "500";
        }).thenApplyAsync(money ->{
            SmallTool.printTimeAndThread(String.format("服务员开发票，面额%s元", money));
            SmallTool.sleepMillis(200);
            return String.format("%s元发票", money);
        });

        SmallTool.printTimeAndThread("小白 接到服务电话，想一起打游戏");

        SmallTool.printTimeAndThread(String.format("小白拿到%s,准备回家", invoice.join()));
    }
}
