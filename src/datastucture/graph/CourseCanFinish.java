package datastucture.graph;

import java.util.*;

/***
 *@ClassName CourseCanFinish
 *@Description
 * @author sukbear
 * @create 2019-05-11 14:20
 */
public class CourseCanFinish {
  /**
   * 统计每个课被指向次数，初始被指向次数为0的肯定是安全的（不在环上）。

    每被安全课程指向一次，被指次数减一，

    如果被指次数减到0，说明该课程全部指向都来自安全课程，则它也是安全的。

    依此进行队列循环。
   */
  /**
   *
   * 现在你总共有 n 门课需要选，记为 0 到 n-1。
   * 在选修某些课程之前需要一些先修课程。 例如，想要学习课程 0 ，
   * 你需要先完成课程 1 ，我们用一个匹配来表示他们: [0,1]
   * 给定课程总量以及它们的先决条件，判断是否可能完成所有课程的学习？
   *
   * 输入: 2, [[1,0]]
   * 输出: true
   * 解释: 总共有 2 门课程。学习课程 1 之前，你需要完成课程 0。
   * 所以这是可能的。
   *
   *
   * 输入: 2, [[1,0],[0,1]]
   * 输出: false
   * 解释: 总共有 2 门课程。学习课程 1 之前，
   * 你需要先完成​课程 0；并且学习课程 0 之前，
   * 你还应先完成课程 1。这是不可能的。
   * */
    public int[] canFinish(int numCourses, int[][] prerequisites) {
        //用来记录正确结果
        int[] res = new int[numCourses];

        int[] arr = new int[numCourses];
        //将需要先决条件的课程统计
        for(int i =0;i<prerequisites.length;i++){
            arr[prerequisites[i][0]]++;
        }
        //不需要的入队作为安全课程
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0;i<numCourses;i++){
            if(arr[i]==0){
                queue.add(i);
            }
        }
        int cnt = 0;
        int index = 0;
        while(!queue.isEmpty()){
            //取出元素
            int e = queue.peek();
            res[index++]=e;
            queue.poll();
            cnt++;
            //将安全课程所指的课程的先觉条件减一
            for(int i = 0;i<prerequisites.length;i++){
                if(prerequisites[i][1]==e){
                    arr[prerequisites[i][0]]--;
                    if(arr[prerequisites[i][0]]==0){
                        queue.add(prerequisites[i][0]);
                    }
                }
            }
        }
        return cnt==numCourses? res:new int[]{};
    }
}
