package datastucture.stack;

import java.util.Stack;

/***
 *@ClassName Stack2Queue
 *@Description
 * @author sukbear
 * @create 2019-05-25 16:18
 */
public class Stack2Queue {

    /**
     * s1用来入队，出对的时候从s2出
     * s1 和 s2均为空，抛异常
     * s2 无元素，看s1是否有元素，有则全部出栈到s2,弹出的时候，先取元素
     */

    private Stack<Integer> in = new Stack<>();
    private Stack<Integer> out = new Stack<>();

    /**
     * 直接入栈到 in
     */
    void push(int x) {
        in.push(x);
    }

    int pop() {
        /**
         * out有元素直接弹出
         * */
        if (!out.isEmpty()) {
            return out.pop();
        } else {
            /**
             * 没有元素报异常
             * **/
            if (in.isEmpty()) {
                throw new NullPointerException();
            } else {
                /**
                 * 将in 全部入栈到out
                 * */
                while (!in.isEmpty()) {
                    out.push(in.pop());
                }
                return out.pop();
            }
        }
    }

    public static void main(String[] args) {
        Stack2Queue s = new Stack2Queue();
        System.out.println(s.pop());
    }
}
