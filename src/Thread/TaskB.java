package Thread;

import java.util.concurrent.Callable;

/***
 *@ClassName TaskB
 *@Description
 * @author sukbear
 * @create 2019-06-02 16:27
 */
public class TaskB implements Callable {
    static Boolean stat = false;

    @Override
    public Object call() {
        try {
            Thread.sleep(1000);
            System.out.println("do B");
            stat = true;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return stat;
    }
}
