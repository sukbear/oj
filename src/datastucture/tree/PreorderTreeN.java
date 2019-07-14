package datastucture.tree;

import java.util.*;

/**
 * @author sukbear
 * @create 2019-03-02 13:26
 * <p>
 * 给定一个 N 叉树，返回其节点值的前序遍历。
 * <p>
 * 例如，给定一个 3叉树 :
 * 1 324 56(层序)
 * 返回其前序遍历: [1,3,5,6,2,4]。
 */
public class PreorderTreeN {
    public static void main(String[] args) {
        Node a = new Node(1);
        Node b = new Node(2);
        Node c = new Node(3);
        Node d = new Node(4);
        Node e = new Node(5);
        Node[] node = {b, c, d, e,};
        a.children = Arrays.asList(node);
        cengorder(a);
    }

    /**
     * 递归先序遍历n叉树
     */
    public List<Integer> preorder(Node root) {
        ArrayList<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        res.add(root.val);
        for (Node node : root.children) {
            preorder(node);
        }
        return res;
    }



    /**
     * 递归求n叉树的深度
     */
    public int maxDepth(Node root) {
        if (root == null) {
            return 0;
        }
        int depth = 0;
        for (int i = 0; i < root.children.size(); i++) {
            depth = Math.max(depth, maxDepth(root.children.get(i)));
        }
        return depth + 1;
    }

    /**
     * 层次遍历求n叉树的深度，容器引用是否有元素用null去比较
     */
    public int Depth(Node root) {
        int depth = 0;
        if (root == null) {
            return 0;
        }
        if (root.children == null) {
            return 1;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int count = queue.size();
            depth++;
            while (count-- > 0) {
                Node node = queue.poll();
                if (node.children != null) {
                    queue.addAll(node.children);
                }
            }

        }
        return depth;
    }

    /**
     * 层次遍历求n叉树 ，容器引用是否有元素用null去比较
     */
    public static void cengorder(Node root) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            System.out.println(node.val);
            if (node.children != null) {
                queue.addAll(node.children);
            }
        }
    }

    /**
     * n叉树的层序遍历
     */
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> lists = new ArrayList<>();
        if (root == null) {
            return lists;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            //利用count来统计每一层有几个元素。然后操作这几个元素后，添加到list
            int count = queue.size();
            List<Integer> list = new ArrayList<>();
            while (count-- > 0) {
                Node node = queue.poll();
                list.add(node.val);
                if (node.children != null) {
                    queue.addAll(node.children);
                }
            }
            lists.add(list);
        }
        return lists;
    }

    public List<Integer> preorderD(Node root) {
        //非递归版
        ArrayList<Integer> res = new ArrayList<>();
        Stack<Node> stack = new Stack<>();
        if (root == null) {
            return res;
        }
        stack.add(root);
        while (!stack.isEmpty()) {
            Node node = stack.pop();
            res.add(node.val);
            for (int i = node.children.size() - 1; i >= 0; i--) {
                stack.add(node.children.get(i));
            }
        }
        return res;
    }


    /**
     * 节点定义
     */
    static class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;

        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }
}
