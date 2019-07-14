package datastucture.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author sukbear
 * @create 2019-03-01 13:59
 */
public class PrintNodePath {
    private static List<List<Integer>> lists = new ArrayList<>();
    private static List<Integer> list = new ArrayList<>();

    /**
     * 输入一颗二叉树,打印出二叉树的所有路径。
     * 从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
     */
    static void printPathHelper(TreeNode root) {
        list.add(root.data);
        if (root.lChild == null && root.rChild == null) {
            //最终添加入结果集中，必须添加的是list的副本
            lists.add(new ArrayList<>(list));
        }
        if (root.lChild != null) {
            printPathHelper(root.lChild);
        }
        if (root.rChild != null) {
            printPathHelper(root.rChild);
        }
        // 返回父节点，去查找另一条路径
        list.remove(list.size() - 1);
    }

    /**
     * 输入一颗二叉树和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
     * 从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
     * <p>
     * 减法思想
     */
    static void findPathWithSum(TreeNode root, int target) {
        list.add(root.data);
        if (root.lChild == null && root.rChild == null && target == root.data) {
            //最终添加入结果集中，必须添加的是list的副本
            lists.add(new ArrayList<>(list));
        }
        //如果左子树非空，递归左子树
        if (root.lChild != null) {
            findPathWithSum(root.lChild, target - root.data);
        }
        //如果右子树非空，递归右子树
        if (root.rChild != null) {
            findPathWithSum(root.rChild, target - root.data);
        }
        // 返回父节点，去查找另一条路径
        list.remove(list.size() - 1);
    }

    public static void main(String[] args) {
        TreeNode a = new TreeNode(10);
        TreeNode b = new TreeNode(5);
        TreeNode c = new TreeNode(4);
        TreeNode d = new TreeNode(7);
        TreeNode e = new TreeNode(12);
        a.lChild = b;
        a.rChild = e;
        b.lChild = c;
        b.rChild = d;
        findPathWithSum(a, 22);
        System.out.println(lists);
    }

    static class TreeNode {
        Integer data;
        TreeNode lChild;
        TreeNode rChild;

        private TreeNode(Integer data) {
            this.data = data;
        }
    }

    class Solution {
        class TreeNode {
            int val;
            TreeNode left;
            TreeNode right;
            TreeNode(int x) {
                val = x;
            }
            List<List<Integer>> lists = new ArrayList<>();
            List<Integer> list = new ArrayList<>();

            public List<List<Integer>> pathSum(TreeNode root, int sum) {
                if (root == null) {
                    return lists;
                }
                help(root, sum);
                return lists;
            }

            private void help(TreeNode root, int sum) {
                list.add(root.val);
                if (root.val == sum && root.left == null && root.right == null) {
                    //复制列表并添加
                    lists.add(new ArrayList<>(list));
                }
                if (root.left != null) {
                    //做减法
                    help(root.left, sum - root.val);
                }
                if (root.right != null) {
                    help(root.right, sum - root.val);
                }
                //返回父亲节点
                list.remove(list.size() - 1);
            }
        }
    }
}
