package class09;

import class03.SmallTool;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.LinkedBlockingQueue;

public class LinkedBlockingQueue_put_06 {

    public static void main(String[] args) {
        BlockingQueue<String> blockingQueue = new LinkedBlockingQueue<>(1);

        try {
            //put 方法,可以往队列里面放元素
            blockingQueue.put("one");
            SmallTool.printTimeAndThread("one 放进去了");

            blockingQueue.put("two");
            SmallTool.printTimeAndThread("two 放进去了");

        } catch (InterruptedException e) {
            SmallTool.printTimeAndThread("取元素被中断");
        }


    }

}
