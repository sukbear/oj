package algorithm.slidingwindow;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;

/***
 *@ClassName MaxSlidingWindow
 *@Description
 * @author sukbear
 * @create 2019-04-26 15:16
 */
public class MaxSlidingWindow {
    /**
     * 给定一个数组 num，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。
     * 你只可以看到在滑动窗口 k 内的数字。滑动窗口每次只向右移动一位。
     * 返回滑动窗口最大值。
     * <p>
     * 输入: num = [1,3,-1,-3,5,3,6,7], 和 k = 3
     * 输出: [3,3,5,5,6,7]
     * 解释:
     * <p>
     * 滑动窗口的位置                最大值
     * ---------------               -----
     * [1  3  -1] -3  5  3  6  7       3
     * 1 [3  -1  -3] 5  3  6  7       3
     * 1  3 [-1  -3  5] 3  6  7       5
     * 1  3  -1 [-3  5  3] 6  7       5
     * 1  3  -1  -3 [5  3  6] 7       6
     * 1  3  -1  -3  5 [3  6  7]      7
     * 你可以假设 k 总是有效的，1 ≤ k ≤ 输入数组的大小，且输入数组不为空。
     */

    public int[] maxSlidingWindow(int[] num, int k) {
        //非法值
        if (num == null || num.length < k || k == 0) {return new int[0];}
        int[] res = new int[num.length-k+1];
        //双端队列
        Deque<Integer> deque = new LinkedList<>();
        //遍历元素
        for(int i =0;i<num.length;i++){
            //尾部添加元素，保证左边元素都大于右边
            while(!deque.isEmpty()&& num[deque.getLast()]<num[i]){
                deque.removeLast();
            }
            deque.addLast(i);
            //在头部移除元素
            if(deque.getFirst()==i-k){
                deque.removeFirst();
            }  //输出结果
            if (i >= k - 1) {

            }
        }
        return res;
    }
    /**
     * 利用大根堆实现窗口
     * */
    public ArrayList<Integer> maxInWindows(int[] num, int size){
        ArrayList<Integer> ret = new ArrayList<>();
        if(size>num.length||size<1){
            return ret;
        }
        /**
         * 大顶堆
         * */
        PriorityQueue<Integer> heap = new PriorityQueue<>((o1,o2)->o2-o1);
        for(int i = 0;i<size;i++){
            heap.add(num[i]);
        }
        ret.add(heap.peek());
        /** 维护一个大小为 size 的大顶堆
         * i指向要删除得元素，j指向要添加得元素
         * */
        for(int i = 0,j=i+size;j<num.length;i++,j++){
            heap.remove(num[i]);
            heap.add(num[j]);
            ret.add(heap.peek());
        }
        return ret;
    }
}
