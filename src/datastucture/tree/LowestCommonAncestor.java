package datastucture.tree;

/***
 *@ClassName LowestCommonAncestor
 *@Description
 * @author sukbear
 * @create 2019-05-23 15:15
 */
public class LowestCommonAncestor {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }

    /**
     * 二叉查找树中，两个节点 p, q 的公共祖先 root
     * 满足 root.val >= p.val && root.val <= q.val。
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return root;
        }
        if (root.val > p.val && root.val > q.val) {
            return lowestCommonAncestor(root.left, p, q);
        }
        if (root.val < p.val && root.val < q.val) {
            return lowestCommonAncestor(root.right, p, q);
        }
        return root;
    }


    /**
     * 给定一个(普通)二叉树, 找到该树中两个指定节点的最近公共祖先。
     * <p>
     * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
     * <p>
     * 例如，给定如下二叉树:  root = [3,5,1,6,2,0,8,null,null,7,4]
     */
    /**
     * 祖先只能出现在根节点，根节点的左子树，根节点的右子树
     * 在左右子树中查找是否存在 p 或者 q，
     * 如果 p 和 q 分别在两个子树中，那么就说明根节点就是最低公共祖先。
     */
    public TreeNode commLowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p == root || q == root) {
            return root;
        }
        //在左子树找p或q
        TreeNode left = commLowestCommonAncestor(p.left, p, q);
        //在右子树找p或q
        TreeNode right = commLowestCommonAncestor(p.right, p, q);
        if (left != null && right != null) {
            return root;
        } else {
            return left == null ? right : left;
        }
    }
}
