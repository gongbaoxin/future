package class07;

import class03.SmallTool;
import com.sun.java.swing.plaf.windows.WindowsBorders;

import java.util.ArrayList;
import java.util.concurrent.CompletableFuture;

public class TerribleCode {

    public static void main(String[] args){

     /*   SmallTool.printTimeAndThread("小白和小伙伴们 进餐厅点菜");
        long starTime = System.currentTimeMillis();

        ArrayList<Dish> dishes = new ArrayList<>();
        //点菜
        for(int i=1; i<=10; i++){
            Dish dish = new Dish("菜" + i , 1);
            dishes.add(dish);
        }

        //做菜
        for(Dish dish : dishes){
            CompletableFuture.runAsync(() -> dish.make()).join();
        }

        SmallTool.printTimeAndThread("菜都做好了,上桌" + (System.currentTimeMillis()- starTime));*/

       SmallTool.printTimeAndThread("小白和小伙伴们 进餐厅点菜");
        long starTime = System.currentTimeMillis();

        ArrayList<Dish> dishes = new ArrayList<>();
        //点菜
        for(int i=1; i<=10; i++){
            Dish dish = new Dish("菜" + i , 1);
            dishes.add(dish);
        }


        //做菜
        //收集到一个容器中
        ArrayList<CompletableFuture> cfList = new ArrayList<>();
        for(Dish dish : dishes){
            CompletableFuture<Void> cf = CompletableFuture.runAsync(() -> dish.make());
            cfList.add(cf);
        }
        //等待所有任务执行完毕
        CompletableFuture.allOf(cfList.toArray(new CompletableFuture[cfList.size()])).join();

        SmallTool.printTimeAndThread("菜都做好了,上桌" + (System.currentTimeMillis()- starTime));

    }
}
