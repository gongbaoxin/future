package class09;

import java.util.LinkedList;
import java.util.Queue;

public class QueueDemo_01 {
//队 列是一种先进先出 的结构
    public static void main(String[] args) {
        Queue<String> queue = new LinkedList<>();
        queue.offer("one");
        queue.offer("two");
        queue.offer("three");

        System.out.println("----------开始打印----------");
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println("----------结束打印----------");
    }
}
