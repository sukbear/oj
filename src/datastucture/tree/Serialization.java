package datastucture.tree;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/***
 *@ClassName Serialization
 *@Description
 * @author sukbear
 * @create 2019-05-08 15:59
 */
public class Serialization {
    static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }
    /**
     * 序列化
     * */
    public static String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        encode(root, sb);
        return sb.substring(1);
    }

    public static void encode(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append(",#");
        } else {
            sb.append(",");
            sb.append(root.val);
            encode(root.left, sb);
            encode(root.right,sb);
        }
    }
    /**
     * 反序列化
     * */
    public static TreeNode deserialize(String s){
        if(s==null){return null;}
        Queue<String> queue = new LinkedList<>(Arrays.asList(s.split(",")));
        return decode(queue);
    }
    public static TreeNode decode(Queue<String> queue) {
        if (queue.isEmpty()) {
            return null;
        }
        String cur = queue.poll();
        if (cur.equals("#")) {
            return null;
        }
        TreeNode root = new TreeNode(Integer.valueOf(cur));
        root.left = decode(queue);
        root.right = decode(queue);
        return root;
    }
    public static void pre(TreeNode root){
        if(root==null){
            return ;
        }
        System.out.println(root.val);
        pre(root.left);
        pre(root.right);
    }

    public static void main(String[] args) {
        TreeNode a = new TreeNode(12);
        TreeNode b = new TreeNode(2);
        a.left = b;
        String s = serialize(a);
        System.out.println(s);
        TreeNode t = deserialize(s);
        pre(t);
    }
}
