package class09;

import class03.SmallTool;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.stream.Collectors;

public class LinkedBlockingQueue_scenes_07 {

    public static void main(String[] args) {
        BlockingQueue<String> shaoBingQueue = new LinkedBlockingQueue<>(3);

        List<String> xiaoBaiMsg = new LinkedList<>();
        List<String> chefMsg = new LinkedList<>();
        List<String> roadPeopleAMsg = new LinkedList<>();
        List<String> roadPeopleBMsg = new LinkedList<>();

        Thread xiaoBai = new Thread(() ->{
            for(int i=0; i<5;  i++){
                String shaoBing = String.format("小白的  第%d个烧饼", i+1);
                try {
                    shaoBingQueue.put(shaoBing);
                } catch (InterruptedException e) {
                    SmallTool.printTimeAndThread("小白被中断" +e.getMessage());
                }
                xiaoBaiMsg.add(String.format("%d  小白制作了 [%s]", System.currentTimeMillis(), shaoBing));
            }
        });

        Thread chushiA = new Thread(() ->{
            for (int i=0; i<5; i++){
                String shaoBing = String.format("厨师A的  第%d 个烧饼", i+1);

                try {
                    shaoBingQueue.put(shaoBing);
                } catch (InterruptedException e) {
                    SmallTool.printTimeAndThread("厨师A 被中断" + e.getMessage());
                }
                chefMsg.add(String.format("%d 厨师A制作了[%s]", System.currentTimeMillis(), shaoBing));
            }
        });

        Thread roadPeopleA = new Thread(() ->{
            for (int i=0; i<5; i++){
                String shaoBing = null;
                try {
                    shaoBing = shaoBingQueue.take();
                } catch (InterruptedException e) {
                   SmallTool.printTimeAndThread("路人甲被中断" + e.getMessage());
                }
                roadPeopleAMsg.add(String.format("%d 路人甲  买到了[%s]", System.currentTimeMillis(), shaoBing));
            }
        });


        Thread roadPeopleB = new Thread(() ->{
            for (int i=0 ;i<5; i++){
                String shaoBing = null;
                try {
                    shaoBing = shaoBingQueue.take();
                } catch (InterruptedException e) {
                    SmallTool.printTimeAndThread("路人乙被中断" + e.getMessage());
                }
                roadPeopleBMsg.add(String.format("%d  路人乙  买到了[%s]", System.currentTimeMillis(), shaoBing));
            }
        });


        //启动线程
        xiaoBai.start();
        chushiA.start();
        roadPeopleA.start();
        roadPeopleB.start();

        try {
            xiaoBai.join();
            chushiA.join();
            roadPeopleA.join();
            roadPeopleB.join();
        } catch (InterruptedException e) {
            SmallTool.printTimeAndThread("join 产生中断" + e.getMessage());
        }

        System.out.println(xiaoBaiMsg.stream().collect(Collectors.joining("\n")));
        System.out.println(chefMsg.stream().collect(Collectors.joining("\n")));
        System.out.println("-------------------------------------------------------------");
        System.out.println(roadPeopleAMsg.stream().collect(Collectors.joining("\n")));
        System.out.println("-------------------------------------------------------------");
        System.out.println(roadPeopleBMsg.stream().collect(Collectors.joining("\n")));

    }
}
