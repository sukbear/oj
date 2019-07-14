package datastucture.tree;


/***
 *@ClassName BalancedTree
 *@Description
 * @author sukbear
 * @create 2019-03-03 21:35
 */
public class BalancedTree {
    /**
     * 是否是平衡二叉树？
     * 递归
     * */
    boolean isBalancedTree(TreeNode root){
        if(root ==null){return true;}
        int left = depth(root.lChild);
        int right = depth(root.rChild);
        int diff = left - right;
        if(diff>1||diff<-1){
            return false;
        }
        return isBalancedTree(root.lChild)&&isBalancedTree(root.rChild);
    }
    int depth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = depth(root.lChild);
        int right = depth(root.rChild);
        return (left > right) ? left + 1 : right + 1;
    }
}
