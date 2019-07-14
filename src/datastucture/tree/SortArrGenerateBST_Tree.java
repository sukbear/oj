package datastucture.tree;

/***
 *@ClassName SortArrGenerateBST_Tree
 *@Description
 * @author sukbear
 * @create 2019-05-10 19:19
 */
public class SortArrGenerateBST_Tree {
   /** 给定一个有序数组sortArr，已知其中没有重复值，用这个有序
    数组生成一棵平衡搜索二叉树，并且该搜索二叉树中序遍历的
    结果与sortArr一致。*/
    public static Node generateTree(int[] arr) {
        if (arr == null) {
            return null;
        }
        return generate(arr, 0, arr.length - 1);
    }

    public static Node generate(int[] arr, int start, int end) {
        if (start < end) {
            return null;
        }
        int mid = (start + end) / 2;
        Node head = new Node(arr[mid]);
        head.left = generate(arr, start, mid - 1);
        head.right = generate(arr, mid + 1, end);
        return head;
    }

    static class Node {
        public int value;
        public Node left;
        public Node right;
        public Node(int data) {
            this.value = data;
        }
    }
}
