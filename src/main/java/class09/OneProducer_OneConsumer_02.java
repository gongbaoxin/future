package class09;

import class03.SmallTool;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class OneProducer_OneConsumer_02 {

    public static void main(String[] args) {
        final int count = 12;
        Queue<String> shaobingQueue = new LinkedList<>();

        List<String> xiaoBaiMsg = new LinkedList<>();
        List<String> roadPeopleAMsg = new LinkedList<>();
        List<String> roadPeopleBMsg = new LinkedList<>();

        Thread xiaoBai = new Thread(() ->{
            for(int i=0; i<count; i++){
                String tmp = String.format("第%d个烧饼", i+1);
                shaobingQueue.add(tmp);
                xiaoBaiMsg.add(String.format("%d 小白制作了[%s]", System.currentTimeMillis(), tmp));
            }
        });

        Thread roadPeopleA = new Thread(() ->{
            for(int i=0; i<count; i++){
                roadPeopleAMsg.add(String.format("%d 路人甲 买到了[%s]", System.currentTimeMillis(), shaobingQueue.poll()));
            }
        });

        Thread roadPeopleB = new Thread(() ->{
            for(int i=0;i<count; i++){
                roadPeopleBMsg.add(String.format("%d  路人乙  买到了[%s]", System.currentTimeMillis(), shaobingQueue.poll()));
            }
        });

        xiaoBai.start();
        roadPeopleA.start();
        roadPeopleB.start();

        try {
            xiaoBai.join();
            roadPeopleA.join();
            roadPeopleB.join();
        } catch (InterruptedException e) {
            SmallTool.printTimeAndThread("join 产生中断" + e.getMessage());
        }

        List<String> xiaobaiMsgSub = xiaoBaiMsg.subList(xiaoBaiMsg.size() -1, xiaoBaiMsg.size());
        System.out.println(xiaobaiMsgSub.stream().collect(Collectors.joining("\n")));
        System.out.println("--------------------------aa--------------------------------");

        Predicate<String> notContainsNull = str ->!str.contains("null");
        System.out.println(roadPeopleAMsg.stream().filter(notContainsNull).collect(Collectors.joining("\n")));
        System.out.println("----------------------------bb------------------------------");
        //List<String> roadPeopleAMsgSub = roadPeopleMsg.subList(roadPeopleMsg.size()-5, roadPeopleMsg.size());
        System.out.println(roadPeopleBMsg.stream().filter(notContainsNull).collect(Collectors.joining("\n")));
    }


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
}
