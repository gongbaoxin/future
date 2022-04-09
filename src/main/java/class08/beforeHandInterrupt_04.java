package class08;

import class03.SmallTool;

public class beforeHandInterrupt_04 {

    public static void main(String[] args) throws InterruptedException {
        Thread.currentThread().interrupt();
        SmallTool.printTimeAndThread("开始睡眠");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
          SmallTool.printTimeAndThread("发生中断");
        }


        SmallTool.printTimeAndThread("结束睡眠");

    }
}
