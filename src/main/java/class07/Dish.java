package class07;

import class03.SmallTool;

import java.util.concurrent.TimeUnit;

/***
 * 菜
 */
public class Dish {
    //菜名
    private String name;
    //制作时长
    private Integer productionTime;

    public Dish(String name, Integer productionTime){
        this.name = name;
        this.productionTime = productionTime;
    }

    //做菜
    public void make(){
        SmallTool.sleepMillis(TimeUnit.SECONDS.toMillis(this.productionTime));
        SmallTool.printTimeAndThread(this.name + "制作完毕,来吃我吧.");
    }

}
