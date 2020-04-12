package datastucture.tree;

import java.util.LinkedList;
import java.util.Queue;

/***
 *@ClassName TreeMirror
 *@Description
 * @author sukbear
 * @create 2019-03-03 16:43
 */
public class TreeMirror {
    /**
     * 求一棵树的镜像
     * */
    public void mirror(TreeNode root) {
        if (root == null) {
            return;
        }
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        mirror(root.left);
        mirror(root.right);
    }

    /**判断两棵树是否时镜像*/
    boolean isMirror(TreeNode root1,TreeNode root2){
        if(root1==null&&root2==null){
            return true;
        }
        if(root1==null||root2==null){
            return false;
        }

        return root1.val==root2.val&&isMirror(root1.left,root2.right)&&isMirror(root1.right,root2.left);
    }

    public boolean isSymmetric(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        q.add(root);
        while (!q.isEmpty()) {
            TreeNode t1 = q.poll();
            TreeNode t2 = q.poll();
            if (t1 == null && t2 == null) continue;
            if (t1 == null || t2 == null) return false;
            if (t1.val != t2.val) return false;
            q.add(t1.left);
            q.add(t2.right);
            q.add(t1.right);
            q.add(t2.left);
        }
        return true;
    }
    public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
 }
}
