package datastucture.tree;

/***
 *@ClassName BinaryTreeMaximumDistance
 *@Description
 * @author sukbear
 * @create 2019-05-28 11:32
 */
public class BinaryTreeMaximumDistance {
    /**
     * 在求过点x的最大距离时，最大距离的两个点有可能出现在三种情况下
     * <p>
     * 左子树
     * 右子树
     * 过节点x
     * 经分析得出以下特点
     * <p>
     * 以上三种情况最终必定一叶子结束
     * 在第三种情况下必然是左子树高度 与 右子树高度 之和（只有这样，才可能取得最大值）
     * 经过以上分析即可得出递推式
     * <p>
     * Dis(x) = max(Dis(x->left), Dis(x->right), height(x->left)+height(x->right))
     */
    /**
     * 全局变量保存结果
     */
    static int maxDis = 0;

    static int dis(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 0;
        }
        int dis = Math.max(dis(root.right), Math.max(depth(root.left) + depth(root.right), dis(root.left)));
        maxDis = maxDis < dis ? dis : maxDis;
        return maxDis;
    }

    static int depth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = depth(root.left);
        int right = depth(root.right);
        return left > right ? left + 1 : right + 1;
    }

    public static void main(String[] args) {
        TreeNode a = new TreeNode(1);
        TreeNode b = new TreeNode(1);
        TreeNode c = new TreeNode(1);
        TreeNode d = new TreeNode(1);
        TreeNode e = new TreeNode(1);
        TreeNode f = new TreeNode(1);
        TreeNode g = new TreeNode(1);
        a.left = b;
        a.right = c;
        c.left = d;
        d.right = e;
        d.left = f;
        e.right = g;
        TreeNode p = new TreeNode(1);
        System.out.println(dis(a));
    }
    static class TreeNode {
        int val ;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }
}
