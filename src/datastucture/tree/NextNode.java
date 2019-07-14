package datastucture.tree;

/**
 * @author sukbear
 * @create 2019-02-28 17:37
 */
public class NextNode {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode parent;
    }
    /** 这里需要注意的是pNode.parent是pNode结点的父结点
        1、如果有右子树，那么下一个结点就是右子树最左边的节点。
        2、如果没有右子树，分两种情况，如果该结点的为父结点的左孩子，则该结点的父节点pNode.parent则为
        该结点的下一个结点。
        第二种情况则是如果该结点的为父节点的右孩子，则向上找父节点，直到某一节点为该父节点的左孩子，则该节点的父节点
        为下一个结点。
        */
    public TreeNode getNextNode(TreeNode pNode) {
        if (pNode == null) {
            return null;
        }
        if (pNode.right != null) {
            pNode = pNode.right;
            while (pNode.left != null) {
                pNode = pNode.left;
            }
            return pNode;
        }
        while (pNode.parent != null) {
            if (pNode.parent.left == pNode) {
                return pNode.parent;
            }
            pNode = pNode.parent;
        }
        return pNode;
    }
}
