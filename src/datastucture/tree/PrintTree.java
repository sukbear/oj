package datastucture.tree;

import java.util.*;

/**
 * @author sukbear
 * @create 2019-03-01 10:25
 */
public class PrintTree {
    public static void main(String[] args) {
        TreeNode a = new TreeNode(10);
        TreeNode b = new TreeNode(6);
        TreeNode c = new TreeNode(14);
        TreeNode d = new TreeNode(4);
        TreeNode e = new TreeNode(8);
        TreeNode f = new TreeNode(12);
        TreeNode g = new TreeNode(16);
        a.lChild = b;
        a.rChild = c;
        b.lChild = d;
        b.rChild = e;
        c.lChild = f;
        c.rChild = g;
       for(List<TreeNode> p : zhiPrintList(a)){
           for(TreeNode node :p){
               System.out.print(node.getData());
               System.out.print(" ");
           }
           System.out.println();
       }
    }

    /**
     * 之字型打印二叉树,从左往右，从右往左带逗号
     */
    public static void zhiPrint(TreeNode root) {
        if (root == null) {
            return;
        }
        Stack<TreeNode> s1 = new Stack<>();
        s1.add(root);
        Stack<TreeNode> s2 = new Stack<>();
        while (!s1.isEmpty() || !s2.isEmpty()) {
            while (!s1.isEmpty()) {
                TreeNode p = s1.pop();
                if (p == root) {
                    System.out.print(p.getData());
                } else {
                    System.out.print(",");
                    System.out.print(p.getData());
                }
                if (p.lChild != null) {
                    s2.push(p.lChild);
                }
                if (p.rChild != null) {
                    s2.push(p.rChild);
                }
            }
            while (!s2.isEmpty()) {
                TreeNode q = s2.pop();
                System.out.print(",");
                System.out.print(q.getData());
                if (q.rChild != null) {
                    s1.push(q.rChild);
                }
                if (q.lChild != null) {
                    s1.push(q.lChild);
                }
            }
        }
    }

    public static List<List<TreeNode>> zhiPrintList(TreeNode root) {
        if (root == null) {
            return null;
        }
        List<List<TreeNode>> res = new ArrayList<>();
        Stack<TreeNode> s1 = new Stack<>();
        s1.add(root);
        Stack<TreeNode> s2 = new Stack<>();
        while (!s1.isEmpty() || !s2.isEmpty()) {
            if (!s1.isEmpty()) {
                ArrayList<TreeNode> temp = new ArrayList<>();
                while (!s1.isEmpty()) {
                    TreeNode p = s1.pop();
                    temp.add(p);
                    if (p.lChild != null) {
                        s2.push(p.lChild);
                    }
                    if (p.rChild != null) {
                        s2.push(p.rChild);
                    }
                }
                res.add(temp);
            } else {
                if(!s2.isEmpty()){
                    ArrayList<TreeNode> temp = new ArrayList<>();
                    while (!s2.isEmpty()) {
                        TreeNode q = s2.pop();
                        temp.add(q);
                        if (q.rChild != null) {
                            s1.push(q.rChild);
                        }
                        if (q.lChild != null) {
                            s1.push(q.lChild);
                        }
                    }
                    res.add(temp);
                }
            }
        }
        return res;
    }

    /**
     * 从上往下打印出二叉树的每个结点，同一层的结点按照从左到右的顺序打印
     */
    public static void hierarchyPrint(TreeNode root) {
        if (root == null) {
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode p = queue.poll();
            System.out.println(p.data);
            if (p.lChild != null) {
                queue.add(p.lChild);
            }
            if (p.rChild != null) {
                queue.add(p.rChild);
            }
        }
    }

    /**
     * 从上往下打印出二叉树的每个结点，同一层的结点按照从右到左的顺序打印
     */
    public static void rightToLeft(TreeNode root) {
        if (root == null) {
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode p = queue.poll();
            System.out.println(p.data);
            if (p.rChild != null) {
                queue.add(p.rChild);
            }
            if (p.lChild != null) {
                queue.add(p.lChild);
            }
        }
    }

    /**
     * 从下往上打印出二叉树的每个结点，同一层的结点按照从左到右的顺序打印
     * 先入对，出队的入栈，（从左到右）打印则，入队的时候 右孩子先入队。
     */
    public static void downToUp(TreeNode root) {
        if (root == null) {
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode p = queue.poll();
            stack.push(p);
            if (p.rChild != null) {
                queue.add(p.rChild);
            }
            if (p.lChild != null) {
                queue.add(p.lChild);
            }
        }
        while (!stack.isEmpty()) {
            System.out.println(stack.pop().getData());
        }
    }
}
