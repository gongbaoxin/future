package class04;

import class03.SmallTool;

import java.util.concurrent.CompletableFuture;

public class ApplyToEither_02 {
    public static void main(String[] args){
        SmallTool.printTimeAndThread("张三走出餐厅，来到公交站");
        SmallTool.printTimeAndThread("等待 700 路 或者 800路，公交到来");

        CompletableFuture<String> bus = CompletableFuture.supplyAsync(() ->{
            SmallTool.printTimeAndThread("700 路公交正在赶来");
             SmallTool.sleepMillis(100);
             return "700路公交到了";
        }).applyToEither(CompletableFuture.supplyAsync(() ->{
            SmallTool.printTimeAndThread("800路公交正在赶来");
             SmallTool.sleepMillis(200);
             return "800路公交到了";
        }), firstComeBus -> {
            SmallTool.printTimeAndThread(firstComeBus);
            if(firstComeBus.startsWith("700")){
                throw new RuntimeException("撞树了。。。。");
            }
            return firstComeBus;
        }).exceptionally(e ->{
            SmallTool.printTimeAndThread(e.getMessage());
            SmallTool.printTimeAndThread("小白叫出租车");
            return "出租车叫到了";
        });
        SmallTool.printTimeAndThread(String.format("%s, 小白坐车回家", bus.join()));
    }
}