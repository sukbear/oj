package datastucture.tree;

/**
 * @author sukbear
 * @create 2019-03-01 11:56
 */
public class SequenceOfBST {
    /**
     * 输入一个整数数组，
     * 判断该数组是不是某二叉搜索树的后序遍历的结果。
     * 如果是则返回 true，否则返回 false。
     * 假设输入的数组的任意两个数字都互不相同
     */
    public static boolean verfiySequenceOfBST(int[] array, int start, int end) {
        if (array == null || start > end || start < 0 || end < 0) {
            return false;
        }
        if (start == end) {
            return true;
        }
        int root = array[end];
        //找到第一个大于根节点的位置
        int i = start;
        for (; i <= end; i++) {
            if (array[i] > root) {
                break;
            }
        }
        //判断右子树是否右小于根节点
        int j = i;
        for (; j <= end; j++) {
            if (array[j] < root) {
                return false;
            }
        }
        //递归判断左子树
        boolean left = true;
        if (i > start) {
            left = verfiySequenceOfBST(array, start, i - 1);
        }
        //递归判断右子树
        boolean right = true;
        if (i < end) {
            right = verfiySequenceOfBST(array, i, end - 1);
        }
        return left && right;
    }
}
