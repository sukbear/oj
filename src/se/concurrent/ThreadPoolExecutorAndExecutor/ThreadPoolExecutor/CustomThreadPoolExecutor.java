package se.concurrent.ThreadPoolExecutorAndExecutor.ThreadPoolExecutor;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author sukbear
 * @create 2018-12-12 21:31
 */


/**
 * 注意：41以后提交的任务就不能正常处理了，因为，execute中提交到任务队列是用的offer方法，如上面代码，
 这个方法是非阻塞的，所以就会交给CustomRejectedExecutionHandler 来处理，
 所以对于大数据量的任务来说，这种线程池，如果不设置队列长度会OOM，设置队列长度，会有任务得不到处理，接下来我们构建一个阻塞的自定义线程池
 *
 * */
public class CustomThreadPoolExecutor {
    private ThreadPoolExecutor pool = null;
  /*  方法中建立一个核心线程数为30个，缓冲队列有10个的线程池。
    每个线程任务，执行时会先睡眠3秒，保证提交10任务时，线程数目被占用完，
    再提交30任务时，阻塞队列被占用完，，这样提交第41个任务是，
    会交给CustomRejectedExecutionHandler 异常处理类来处理。*/

    public void init() {
        pool = new ThreadPoolExecutor(10, 30,
                30, TimeUnit.MINUTES,
                new ArrayBlockingQueue<>(10), new CustomThreadFactory(),
                new CustomRejectedExecutionHandler());
    }

    public void destory(){
        if(pool !=null){
            pool.shutdown();
        }
    }

    public ExecutorService getCustomThreadPoolExcutor(){
        return this.pool;
    }

    private class CustomThreadFactory implements ThreadFactory{
        private AtomicInteger count  = new AtomicInteger(0);

        @Override
        public Thread newThread(Runnable r) {
            Thread thread = new Thread(r);
            String threadName = CustomThreadPoolExecutor.class.getSimpleName()+count.addAndGet(1);
            System.out.println(threadName);
            thread.setName(threadName);
            return thread;
        }
    }

    private class CustomRejectedExecutionHandler implements RejectedExecutionHandler{
        @Override
        public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
            System.out.println("err................");
        }
    }


    public static void main(String[] args) {
        CustomThreadPoolExecutor exec = new CustomThreadPoolExecutor();
        exec.init();
        ExecutorService pool = exec.getCustomThreadPoolExcutor();
        for(int i = 0;i < 100;i++){
            System.out.println(" 提交第 "+i+"个任务");
            pool.execute(() -> {
                System.out.println(">>>task is running ===========");
                try {
                    TimeUnit.SECONDS.sleep(3);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }

        try {
            TimeUnit.SECONDS.sleep(10);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        exec.destory();
    }
}
