package datastucture.tree;

/***
 *@ClassName SearchTree2LinkedList9
 *@Description
 * @author sukbear
 * @create 2019-05-22 16:22
 */
public class SearchTree2LinkedList9 {
    private TreeNode pre = null;
    /**记录左子树最小的一个*/
    private TreeNode lastLeaf = null;
    public TreeNode convert(TreeNode pRootOfTree){
        if(pRootOfTree==null){
            return null;
        }
        convert(pRootOfTree.lChild);
        pRootOfTree.lChild=pre;
        if(pre!=null){
            pre.rChild=pRootOfTree;
        }
        pre = pRootOfTree;
        lastLeaf=lastLeaf==null?pRootOfTree:lastLeaf;
        convert(pRootOfTree.rChild);
        return lastLeaf;
    }

}
