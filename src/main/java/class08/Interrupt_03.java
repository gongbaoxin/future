package class08;

import class03.SmallTool;

public class Interrupt_03 {

    public static void main(String[] args){
        Thread carOne = new Thread(() ->{
            long startMills = System.currentTimeMillis();
            while(System.currentTimeMillis() -startMills <3){
                //if(Thread.currentThread().isInterrupted()){
                if(Thread.interrupted()){
                    SmallTool.printTimeAndThread("向左开1米");
                }else{
                    SmallTool.printTimeAndThread("往前开1米");
                }
            }
        });

        //启动线程
        carOne.start();

        //1秒后对卡丁1号发起中断
        SmallTool.sleepMillis(1);
        carOne.interrupt();

        /*
         * 3,如果线程没有睡眠，调用它的 interrupt 会怎样？
         *   public boolean isInterrupted()
         *   只是查看灯有没有开着
         *   public static boolean interrupted()
         *  不仅会查看有没有开灯,还会把灯关掉
         */

    }
}
