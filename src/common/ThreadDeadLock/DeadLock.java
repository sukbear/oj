package common.ThreadDeadLock;

/***
 *@ClassName DeadLock
 *@Description
 * @author sukbear
 * @create 2019-06-14 18:34
 */
public class DeadLock {
    /***
     * 占有不同的资源，再请求另一个时对方不释放
     */

    static Object o1 = new Object();
    static Object o2 = new Object();

    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (o1){
                    System.out.println("Thread1锁住o1");
                    try {
                        Thread.sleep(1000);
                        synchronized (o2){
                            System.out.println("Thread1锁住o2");
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (o2){
                    System.out.println("Thread2锁住o2");
                        synchronized (o1){
                            System.out.println("Thread2锁住o1");
                        }
                    }
                }
        }).start();

    }
}
