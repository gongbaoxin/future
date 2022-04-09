package class02;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/****
 *   如何把任务交给线程
 *  1, 重写  override  Thread 的run() 方法
 *  2, 实现java.lang.Runnable 的接口，再创建Thread 对象的时候传到构造函数里面去
 *  3, 使用FutureTask ， 在创建Thread对象的时候传到构造函数里面去,有返回值，可以捕获异常
 */
public class Thread_FutureTask_04 {

    public static void main(String[] args) {

        Callable<String> callable = () ->{
            System.out.println("我是子任务");
            return "sub task done";
        };
        FutureTask<String> task = new FutureTask(callable);
        Thread thread = new Thread(task);
        thread.start();
        System.out.println("子线程启动");


        try {
            //线程的返回值  get() 方法
            //一旦调用了get() 方法， 主线程就开始不停的询问子线程的情况
            String subResult = task.get();
            System.out.println("子线程的返回值是: " + subResult);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            Throwable cause = e.getCause();
            e.printStackTrace();
        }

        System.out.println("main 结束");
    }

}
