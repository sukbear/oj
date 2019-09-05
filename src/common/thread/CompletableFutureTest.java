package common.thread;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.FutureTask;

/***
 *@ClassName CompletableFutureTest
 *@Description
 * @author sukbear
 * @create 2019-07-29 11:24
 */
public class CompletableFutureTest {
    /**
     * 1缺陷
     * 我们的Future使用很简单，这也导致了如果我们想完成一些复杂的任务可能就比较难。
     * 比如下面一些例子:
     * <p>
     * 将两个异步计算合成一个异步计算，这两个异步计算互相独立，同时第二个又依赖第一个的结果。
     * 当Future集合中某个任务最快结束时，返回结果。
     * 等待Future结合中的所有任务都完成。
     * 通过编程方式完成一个Future任务的执行。
     * 应对Future的完成时间。也就是我们的回调通知。
     *
     * @return
     * @throws
     * @params
     */
    public static void main(String[] args) {
        CompletableFuture.supplyAsync(() -> "cf")
                .thenApply(s -> s + ".thenApply")
                .thenCompose(s -> CompletableFuture.supplyAsync(() -> s + ".thenCompose"))
                .thenAccept(System.out::println);

        FutureTask<Integer> task = new FutureTask<>(() -> {
            System.out.println(Thread.currentThread().getName() + "执行任务 ");
            return 0;
        }
        );
        new Thread(task).start();
    }


}
