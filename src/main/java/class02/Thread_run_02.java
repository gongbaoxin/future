package class02;

public class Thread_run_02 {

    /****
     *   如何把任务交给线程
     *  1, 重写  override  Thread 的run() 方法
     *  2, 实现java.lang.Runnable 的接口，再创建Thread 对象的时候传到构造函数里面去
     *  3, 使用FutureTask ， 在创建Thread对象的时候传到构造函数里面去,有返回值，可以捕获异常
     */

    public static void main(String[] args) {
        Thread thread = new Thread(){
          @Override
          public void run(){
              System.out.println("我是子线程");
          }
        };

        thread.start();
        System.out.println("main 结束");
    }

}
