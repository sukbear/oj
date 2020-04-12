package se.Thread;

import java.util.concurrent.Callable;

/***
 *@ClassName TaskA
 *@Description
 * @author sukbear
 * @create 2019-06-02 16:03
 */
public class TaskA implements Callable {
    static Boolean stat = false;
    @Override
    public Object call() {
        try {
            Thread.sleep(10000);
            System.out.println("do A");
            stat = true;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return stat;
    }
}
