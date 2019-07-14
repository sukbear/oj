package se.concurrent.ThreadPoolExecutorAndExecutor.ThreadPoolExecutor;

/***
 *@ClassName ThreadPoolExe
 *@Description
 * @author sukbear
 * @create 2019-03-05 9:50
 */

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
        threadFactory：线程工厂，主要用来创建线程
        handler：拒绝处理任务的策略
        workQueue:工作队列（储存任务）
        AbortPolicy：丢弃任务并抛出 RejectedExecutionException 异常。（默认这种）
        DiscardPolicy：也是丢弃任务，但是不抛出异常
        DiscardOldestPolicy：丢弃队列最前面的任务，然后重新尝试执行任务（重复此过程）
        CallerRunsPolicy：由调用线程处理该任务*/



/*ArrayBlockingQueue （有界队列）：是一个基于数组结构的有界阻塞队列，此队列按 FIFO（先进先出）原则对元素进行排序。
  LinkedBlockingQueue （无界队列）：一个基于链表结构的阻塞队列，此队列按FIFO （先进先出） 排序元素，吞吐量通常要高于ArrayBlockingQueue。静态工厂方法Executors.newFixedThreadPool()使用了这个队列。
  SynchronousQueue（同步队列）: 一个不存储元素的阻塞队列。每个插入操作必须等到另一个线程调用移除操作，否则插入操作一直处于阻塞状态，吞吐量通常要高于LinkedBlockingQueue，静态工厂方法Executors.newCachedThreadPool使用了这个队列。
  DelayQueue（延迟队列）：一个任务定时周期的延迟执行的队列。根据指定的执行时间从小到大排序，否则根据插入到队列的先后排序。
  PriorityBlockingQueue（优先级队列）: 一个具有优先级得无限阻塞队列。*/

public class ThreadPoolExe {
    ExecutorService threadPool = new ThreadPoolExecutor(1,3,2, TimeUnit.SECONDS,new ArrayBlockingQueue<>(10),new ThreadPoolExecutor.AbortPolicy());
}
