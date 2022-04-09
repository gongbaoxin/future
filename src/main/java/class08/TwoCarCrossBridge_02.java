package class08;

import class03.SmallTool;

import java.util.Random;

public class TwoCarCrossBridge_02 {

    public static void main(String[] args){
        Thread cardTwo = new Thread(() -> {
            SmallTool.printTimeAndThread("卡丁2号，准备过桥");
            SmallTool.printTimeAndThread("发现卡丁1号在过，开始等待");
            try {
                Thread.sleep(3000);
                //SmallTool.printTimeAndThread(Thread.);
            } catch (InterruptedException e) {
                SmallTool.printTimeAndThread("卡丁2号，开始过桥");
            }
            SmallTool.printTimeAndThread("卡丁2号，过桥完毕");

        });

        Thread cardOne = new Thread(() ->{
            SmallTool.printTimeAndThread("卡丁1号，开始过桥");
            int timeSpend = new Random().nextInt(500)*1000;
            SmallTool.sleepMillis(timeSpend);
            SmallTool.printTimeAndThread("卡丁1号，过桥完毕，耗时：" + timeSpend);
            //线程中断
            cardTwo.interrupt();
        });

        //启动这2个线程
        cardOne.start();
        cardTwo.start();

        /****
         * 1,线程在sleep的时候，是什么状态
         *  TIMED_WAITING
         *
         * 2,在那些情况下会抛出现 InterruptedException ?
         *  当线程正在等待，休眠或以其他方式被占用，并且线程在活动之前或期间被告中断时抛出。
         *  sleep, wait,即 blocked, waiting, timed_waiting
         *  并且线程在活动之前或期间被告中断时抛出。不在runnable状态，排除Runnable
         *
         * 3,如果线程没有睡眠，调用它的 interrupt 会怎样？
         *   public boolean isInterrupted()
         *   只是查看灯有没有开着
         *   public static boolean interrupted()
         *  不仅会查看有没有开灯,还会把灯关掉
         */


    }
}
