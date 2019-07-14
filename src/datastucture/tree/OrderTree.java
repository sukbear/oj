package datastucture.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/***
 *@ClassName OrderTree
 *@Description
 * @author sukbear
 * @create 2019-03-02 23:03
 */
public class OrderTree {
    public static void main(String[] args) {
       /* Queue<TreeNode> q = new LinkedList();
        TreeNode a = new TreeNode("A");
        TreeNode b = new TreeNode("B");
        TreeNode c = new TreeNode("C");
        TreeNode d = new TreeNode("D");
        TreeNode e = new TreeNode("E");
        a.lChild = b;
        a.rChild = c;
        b.lChild = d;
        d.rChild = e;
        preOrder(a);*/
        /*TreeMirror mirror = new TreeMirror();
        mirror.mirror(a);
        preOder(a);*/
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(1);
        list.clear();
        System.out.println(list.size());
    }

    /**
     * 对于任一结点P：
     * 1)访问结点P，并将结点P入栈;
     * 2)判断结点P的左孩子是否为空，若为空，则取栈顶结点并进行出栈操作，
     * 并将栈顶结点的右孩子置为当前的结点P，循环至1);
     * 若不为空，则将P的左孩子置为当前的结点P;
     * 3)直到P为NULL并且栈为空，则遍历结束。
     */
    static void preOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        Stack<TreeNode> s = new Stack<>();
        TreeNode p = root;
        while (p != null || !s.isEmpty()) {
            if (p != null) {
                System.out.println(p.getData());
                s.push(p);
                p = p.lChild;
            }
           else {
                p = s.peek();
                s.pop();
                p = p.rChild;
            }
        }
    }

    /**
     * 中序非递归遍历，栈不空，左孩子不空，压栈，并找到最左的那个孩子
     * 弹出栈顶元素，就是最左的那个孩子，先得到元素（peek）输出节点信息，再pop
     * 再看其右孩子
     */
    static void inOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        Stack<TreeNode> s = new Stack<>();
        TreeNode p = root;
        while (!s.isEmpty() || p != null) {
            if(p != null) {
                s.push(p);
                p = p.lChild;
            }
            else  {
                p = s.peek();
                System.out.println(p.getData());
                s.pop();
                p = p.rChild;
            }
        }
    }

    static void postOrder(TreeNode root){
        if(root==null){return;}
        Stack<TreeNode> s = new Stack<>();
        // 当前节点和前一次节点
        TreeNode cur = null, pre = null;
        s.push(root);
        while(!s.isEmpty()){
            //栈顶开始
            cur = s.peek();
            /**
             * 没有孩子或孩子都已被访问过，开始遍历。
             * */
            if((cur.lChild==null&&cur.rChild==null)||(pre!=null&&(pre==cur.lChild||pre==cur.rChild))){
                System.out.println(cur.getData());
                s.pop();
                pre = cur;
            }else {
                if (cur.rChild != null){
                    s.push(cur.rChild);}
                if (cur.lChild != null){
                    s.push(cur.lChild);}
            }
        }
    }

}
