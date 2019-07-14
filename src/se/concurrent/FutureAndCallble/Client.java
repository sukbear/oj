package se.concurrent.FutureAndCallble;

import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

/**
 * @author sukbear
 * @create 2018-12-13 9:38
 */
public class Client {
    public static void main(String[] args) throws Exception {

        FutureTask<Integer> task = new FutureTask<>(()->{
            TimeUnit.SECONDS.sleep(1);
            System.out.println("我在忙");
            return 12;
        });

        Thread thread = new Thread(task);
        thread.start();
        System.out.println("================");
        Integer integer = task.get();
        System.out.println("得到的结果："+integer);
    }
}
