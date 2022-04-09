package class09;

import class03.SmallTool;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;


/*****
 *  我们需要3个功能
 *  1,队列需要有一个固定的容量
 *
 *   2, 如果队列是空的,自然是取不出来东西 ,需要等到有元素为止
 *
 *  3,如果队列是满的, 自然是放不进去东西,需要等到有空位为止
 *
 *
 */
public class LinkedBlockingQueue_take_05 {

    /****
     *  认错书:
     *  中断,  是为了让线程立刻  回到运行状态,可为什么  要趁机抛个 InterruptedException?
     *  错误 : 如果不抛异常,线程回不到运行状态
     *  纠正:让你知道线程  回到运行状态的原因.
     *
     */


    public static void main(String[] args) {
        BlockingQueue<String> blockingQueue = new LinkedBlockingDeque<>(3);
        try {
            //这个队列里面啥都没有,肯定是取不到元素的
            //从队列中获取元素
            blockingQueue.take();
        } catch (InterruptedException e) {
            SmallTool.printTimeAndThread("取元素被中断");
        }

    }
}
