package datastucture.tree;

/***
 *@ClassName SubTree
 *@Description
 * @author sukbear
 * @create 2019-03-06 16:54
 */
public class SubTree {
    static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

        public boolean isSubtree(TreeNode s, TreeNode t) {
            if (s == null) {
                return false;
            }
            return subFrom(s, t) || isSubtree(s.left, t) || isSubtree(s.right, t);
        }

        public boolean subFrom(TreeNode s, TreeNode t) {
            if (s == null && t == null) {
                return true;
            }
            if (s == null || t == null) {
                return false;
            }
            if (s.val != t.val) {
                return false;
            }
            return subFrom(s.left, t.left) && subFrom(s.right, t.right);
        }
    }


    public String tree2String(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        pre(root, sb);
        return sb.toString();
    }

    public void pre(TreeNode root, StringBuilder sb) {
        //遇数作左；遇#变向
        //每一个节点以*开头以#结尾
        if (root == null) {
            sb.append("*#!");
        } else {
            sb.append("*" + root.val + "!");
            pre(root.left, sb);
            pre(root.right, sb);
        }
    }

    public boolean isSubtree(TreeNode s, TreeNode t) {
        return tree2String(s).indexOf(tree2String(t)) > -1;
    }


    public static void main(String[] args) {
        SubTree ob = new SubTree();
        TreeNode a = new TreeNode(12);
        TreeNode c = new TreeNode(2);
        System.out.println(ob.tree2String(a));
        System.out.println(ob.tree2String(c));
        System.out.println(ob.tree2String(a).indexOf(ob.tree2String(c)));
    }
}