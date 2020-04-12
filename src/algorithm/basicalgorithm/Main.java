package algorithm.basicalgorithm;

/***
 *@ClassName Main
 *@Description
 * @author sukbear
 * @create 2019-09-07 14:46
 */
public class Main {
    /**
     * 二分搜索 Binary Search
     * 分治 Divide Conquer
     * 宽度优先搜索 Breadth First Search
     * 深度优先搜索 Depth First Search
     * 回溯法 Backtracking
     * 双指针 Two Pointers
     * 动态规划 Dynamic Programming
     * 扫描线 Scan-line algorithm
     * 快排 Quick Sort
     */
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public boolean isSymmetric(TreeNode root) {
       return f(root,root);
    }

    private boolean f(TreeNode p, TreeNode q) {
        if(p==null&&q==null){
            return true;
        }
        if(p==null||q==null){
            return false;
        }
      return p.val==q.val&&f(p.left,q.right)&&f(p.right,q.left);
    }
}