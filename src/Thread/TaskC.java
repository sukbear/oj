package Thread;

import java.util.concurrent.Callable;

/***
 *@ClassName TaskC
 *@Description
 * @author sukbear
 * @create 2019-06-02 16:27
 */
public class TaskC implements Callable {
    static Boolean stat = false;
    @Override
    public Object call() {
        try {
            Thread.sleep(2000);
            System.out.println("do C");
            stat = true;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return stat;
    }
}
