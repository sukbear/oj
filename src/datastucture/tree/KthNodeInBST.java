package datastucture.tree;

import java.util.Stack;

/***
 *@ClassName KthNodeInBST
 *@Description
 * @author sukbear
 * @create 2019-03-03 22:04
 */
public class KthNodeInBST {
    public static TreeNode kthNode(TreeNode root, int k) {
        if (root == null || k < 1) {
            return null;
        }
        Stack<TreeNode> s = new Stack<>();
        TreeNode cur = root;
        int count = 0;
        while (!s.isEmpty() || cur != null) {
            if (cur != null) {
                s.push(cur);
                cur = cur.lChild;
            } else {
                cur = s.pop();
                count++;
                if (count == k) {
                    return cur;
                }
                cur = cur.rChild;
            }
        }
        return null;
    }
}
