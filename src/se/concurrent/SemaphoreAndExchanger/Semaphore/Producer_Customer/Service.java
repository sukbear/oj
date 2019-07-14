package se.concurrent.SemaphoreAndExchanger.Semaphore.Producer_Customer;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * ..
 *
 * @author sukbear
 * @create 2018-12-12 15:01
 */
public class Service {
    /**
     * 厨师
     */
    volatile private Semaphore setSemaphore = new Semaphore(10);
    /**
     * 就餐者
     */
    volatile private Semaphore getSemaphore = new Semaphore(20);
    volatile private ReentrantLock lock = new ReentrantLock();
    volatile private Condition setCondition = lock.newCondition();
    volatile private Condition getCondition = lock.newCondition();
    /**
     * 最多4个盒子存放菜品
     */
    volatile private Object[] producePosition = new Object[4];
    volatile private List<Object> list = new ArrayList<>();

    private boolean isEmpty() {
        boolean isEmpty = true;
        for (int i = 0; i < producePosition.length; i++) {
            if (producePosition[i] != null) {
                isEmpty = false;
                break;
            }
        }
        if (isEmpty == true) {
            return true;
        } else {
            return false;
        }
    }

    private boolean isFull() {
        boolean isFull = true;
        for (int i = 0; i < producePosition.length; i++) {
            if (producePosition[i] == null) {
                isFull = false;
                break;
            }
        }
        return false;
    }

    public void set(){
        try {
            setSemaphore.acquire();
            lock.lock();
            while(isFull()){
                //生产者等待（消费者消费后）生产
                setCondition.await();
            }
            for(int i=0; i < producePosition.length;i++){
                if(producePosition[i]==null){
                    producePosition[i] ="数据";
                    System.out.println(Thread.currentThread().getName()+" 生产了 "+producePosition[i]);
                    break;
                }
            }
            getCondition.signalAll();
            lock.unlock();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            setSemaphore.release();
        }
    }

    public void get(){
        try {
            getSemaphore.acquire();
            lock.lock();
            while(isEmpty()){
                //消费者等待（生产者生产后）消费
                getCondition.await();
            }
            for(int i = 0; i < producePosition.length;i++){
                if(producePosition[i]!=null){
                    System.out.println(Thread.currentThread().getName()+" 消费了 "+producePosition[i]);
                    producePosition[i]=null;
                    break;
                }
            }
            setCondition.signalAll();
            lock.unlock();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            getSemaphore.release();
        }
    }

}
