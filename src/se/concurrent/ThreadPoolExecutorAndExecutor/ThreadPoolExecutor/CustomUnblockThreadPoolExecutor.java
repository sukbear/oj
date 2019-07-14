package se.concurrent.ThreadPoolExecutorAndExecutor.ThreadPoolExecutor;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author sukbear
 * @create 2018-12-12 22:06
 */



public class CustomUnblockThreadPoolExecutor {
    ThreadPoolExecutor pool = null;

    public void init(){
        pool = new ThreadPoolExecutor(1,3,30,
                TimeUnit.MINUTES,new ArrayBlockingQueue<Runnable>(5),
                new CustomThreadFactory(),new CustomRejectedExecutionHandler());
    }

    public void destory(){
        if(pool != null){
            pool.shutdown();
        }
    }

    public ExecutorService getCustomUnblockThreadPoolExecutor(){
        return this.pool;
    }

    private class CustomThreadFactory implements ThreadFactory {
        private AtomicInteger count  = new AtomicInteger(0);

        @Override
        public Thread newThread(Runnable r) {
            Thread t = new Thread(r);
            String threadName = CustomUnblockThreadPoolExecutor.class.getSimpleName()+count.addAndGet(1);
            System.out.println(threadName);
            t.setName(threadName);
            return t;
        }
    }
    private class CustomRejectedExecutionHandler implements RejectedExecutionHandler {
        @Override
        public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
            //核心改造点,由blockingqueue的offer改成put阻塞方法
            try {
                executor.getQueue().put(r);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        CustomUnblockThreadPoolExecutor exec = new CustomUnblockThreadPoolExecutor();
        exec.init();

        ExecutorService pool = exec.getCustomUnblockThreadPoolExecutor();

        for(int i = 0;i < 100;i++){
            System.out.println("提交第 "+i+"个任务");
            pool.execute(()->{
                System.out.println(">>>task is running");
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }

        System.out.println("ok");
        exec.destory();
    }
}
