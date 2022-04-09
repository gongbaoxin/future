package class02;

import java.util.concurrent.TimeUnit;

public class ThreadState_01 {

    /***
     * 线程对象最常见的三种状态
     * 1- NEW
     * 2- RUNNABLE
     * 3- TERMINATED
     *
     */

    public static void main(String[] args) throws InterruptedException {
        // new 状态
        Thread thread = new Thread();
        System.out.println("1- " + thread.getState());

        //start  线程对象中有一个特殊的方法，这个方法的名字是start()
        //Runnable  状态
        thread.start();
        System.out.println("2- " + thread.getState());

        //TERMINATED 状态
        TimeUnit.SECONDS.sleep(1);
        System.out.println("3- " + thread.getState());
    }
}
