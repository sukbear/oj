package datastucture.tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author sukbear
 * @create 2019-03-01 10:25
 */
public class PrintTree {
    public static void main(String[] args) {
        TreeNode a = new TreeNode("A");
        TreeNode b = new TreeNode("B");
        TreeNode c = new TreeNode("C");
        TreeNode d = new TreeNode("D");
        TreeNode e = new TreeNode("E");
        TreeNode f = new TreeNode("F");
        TreeNode g = new TreeNode("G");
        a.lChild = b;a.rChild = c;
        b.lChild = d; b.rChild = e;
        c.lChild = f;c.rChild = g;
        zhiPrint(a);
    }
/**
 * 之字型打印二叉树
 * */
    public static void zhiPrint(TreeNode root){
        if(root==null){
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        boolean flag = true;
        while(!queue.isEmpty()){
            TreeNode p = queue.poll();
            System.out.println(p.data);
            if(flag){
                if(p.rChild!=null){
                    queue.add(p.rChild);
                }
                if(p.lChild!=null){
                    queue.add(p.lChild);
                }
                flag=false;
            }else{
                if(p.lChild!=null){
                    queue.add(p.lChild);
                }
                if(p.rChild!=null){
                    queue.add(p.rChild);
                }
                flag = true;
            }
        }
    }
    /**
     * 从上往下打印出二叉树的每个结点，同一层的结点按照从左到右的顺序打印
     */
    public static void hierarchyPrint(TreeNode root){
        if(root==null){return ;}
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            TreeNode p = queue.poll();
            System.out.println(p.data);
            if(p.lChild!=null){
                queue.add(p.lChild);
            }
            if(p.rChild!=null){
                queue.add(p.rChild);
            }
        }
    }

    /**
     * 从上往下打印出二叉树的每个结点，同一层的结点按照从右到左的顺序打印
     */
    public static void rightToLeft(TreeNode root){
        if(root == null){
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            TreeNode p = queue.poll();
            System.out.println(p.data);
            if(p.rChild!=null){
                queue.add(p.rChild);
            }
            if(p.lChild!=null){
                queue.add(p.lChild);
            }
        }
    }

    /**
     * 从下往上打印出二叉树的每个结点，同一层的结点按照从左到右的顺序打印
     * 先入对，出队的入栈，（从左到右）打印则，入队的时候 右孩子先入队。
     */
    public static void downToUp(TreeNode root){
        if(root==null){return;}
        Queue<TreeNode> queue = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        queue.add(root);
        while(!queue.isEmpty()){
            TreeNode p = queue.poll();
            stack.push(p);
            if(p.rChild!=null){
                queue.add(p.rChild);
            }
            if(p.lChild!=null){
                queue.add(p.lChild);
            }
        }
        while (!stack.isEmpty()){
            System.out.println(stack.pop().getData());
        }
    }
}
