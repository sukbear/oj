package datastucture.queue;

import java.util.LinkedList;
import java.util.Queue;

/***
 *@ClassName Queue2Stack
 *@Description
 * @author sukbear
 * @create 2019-05-25 16:26
 */
public class Queue2Stack {
    /**
     * 辅助类一定要实例化
     * */
    private Queue<Integer> a = new LinkedList<>();
    private Queue<Integer> b = new LinkedList<>();


    /**
     * 插入完成后只有一个队列有元素。
     */
    void add(int x) {
        /**
         * 都为空时优先插入第一个队列并返回
         * */
        if (a.isEmpty() && b.isEmpty()) {
            a.add(x);
            return;
        }
        /***
         * 谁空插入谁，并降另一个的所有元素入队到另一个队列
         */
        if (a.isEmpty()) {
            a.add(x);
            while (!b.isEmpty()) {
                a.add(b.poll());
            }
        } else {
            b.add(x);
            while (!a.isEmpty()) {
                b.add(a.poll());
            }
        }
    }

    /**
     * 谁不为空弹出谁
     */

    int poll() {
        if (!a.isEmpty()) {
            return a.poll();
        } else {
            return b.poll();
        }
    }

    public static void main(String[] args) {
        Queue2Stack s = new Queue2Stack();
        s.add(1);
        s.add(2);
        s.add(3);
        s.poll();
        System.out.println(s.poll());
    }
}
