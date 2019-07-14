package datastucture.graph;

import java.util.Arrays;
import java.util.PriorityQueue;

/***
 *@ClassName CourseIII
 *@Description
 * @author sukbear
 * @create 2019-05-11 15:41
 */
public class CourseIII {
    /**
     * 这里有 n 门不同的在线课程，他们按从 1 到 n 编号。
     * 每一门课程有一定的持续上课时间（课程时间）t 以及关闭时间第 d 天。
     * 一门课要持续学习 t 天直到第 d 天时要完成，你将会从第 1 天开始。
     * 给出 n 个在线课程用 (t, d) 对表示。你的任务是找出最多可以修几门课。
     *
     * 输入: [[100, 200], [200, 1300], [1000, 1250], [2000, 3200]]
     输出: 3
     解释:
     这里一共有 4 门课程, 但是你最多可以修 3 门:
     首先, 修第一门课时, 它要耗费 100 天，你会在第 100 天完成, 在第 101 天准备下门课。
     第二, 修第三门课时, 它会耗费 1000 天，所以你将在第 1100 天的时候完成它, 以及在第 1101 天开始准备下门课程。
     第三, 修第二门课时, 它会耗时 200 天，所以你将会在第 1300 天时完成它。
     第四门课现在不能修，因为你将会在第 3300 天完成它，这已经超出了关闭日期。

     整数 1 <= d, t, n <= 10,000 。
     你不能同时修两门课程。
     * */

    public int scheduleCourse(int[][] courses) {
        Arrays.sort(courses,(a,b)->a[1]-b[1]);
        //大根堆
        PriorityQueue<Integer> heap = new PriorityQueue<>((a,b)->b-a);
        int time = 0;
        for(int[] c: courses){
            if(c[0]>c[1]){continue;}
            //这门课可以直接学习（贪心策略）
            if(c[0]+time<=c[1]){
                heap.offer(c[0]);
                time+=c[0];
            }else{
                //如果这门课的学习时间小于之前学过的最长时间的课，则进行替换，
                // 因为这样可以空出更多的时间用来学习后面的课程
                if(!heap.isEmpty()&&heap.peek()>c[0]){
                    //回退这门最长的时间的课程，学习当前课程
                    time+=c[0]-heap.poll();
                    heap.offer(c[0]);
                }
            }
        }
        return heap.size();
    }
}
