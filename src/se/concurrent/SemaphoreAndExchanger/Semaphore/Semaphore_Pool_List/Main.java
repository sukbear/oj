package se.concurrent.SemaphoreAndExchanger.Semaphore.Semaphore_Pool_List;

/**
 * @author sukbear
 * @create 2018-12-12 11:15
 */
public class Main {
    public static void main(String[] args) {
        ListPool listPool = new ListPool();
        MyThread[] threadArray = new MyThread[12];
        for (int i = 0; i < threadArray.length; i++) {
            threadArray[i] = new MyThread(listPool);
        }
        for (int i = 0; i < threadArray.length; i++) {
            threadArray[i].start();
        }
    }
}
