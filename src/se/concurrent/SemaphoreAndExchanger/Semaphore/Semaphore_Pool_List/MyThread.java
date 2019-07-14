package se.concurrent.SemaphoreAndExchanger.Semaphore.Semaphore_Pool_List;

/**
 * ..
 *
 * @author sukbear
 * @create 2018-12-12 11:12
 */
public class MyThread extends Thread{
    private ListPool listPool;

    public MyThread(ListPool listPool) {
        this.listPool = listPool;
    }

    @Override
    public void run() {
        for(int i = 0; i < Integer.MAX_VALUE;i++){
            String getString = listPool.get();
            System.out.println(Thread.currentThread().getName()+" 取得值 "+getString);
            listPool.put(getString);
        }
    }
}
