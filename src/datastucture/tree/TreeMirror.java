package datastucture.tree;

/***
 *@ClassName TreeMirror
 *@Description
 * @author sukbear
 * @create 2019-03-03 16:43
 */
public class TreeMirror {
    /**
     * 求一棵树的镜像
     * */
    public void mirror(TreeNode root) {
        if (root == null) {
            return;
        }
        TreeNode temp = root.lChild;
        root.lChild = root.rChild;
        root.rChild = temp;
        mirror(root.lChild);
        mirror(root.rChild);
    }

    /**判断两棵树是否时镜像*/
    boolean isMirror(TreeNode root1,TreeNode root2){
        if(root1==null&&root2==null){
            return true;
        }
        if(root1==null||root2==null){
            return false;
        }
        if(root1.getData()!=root2.getData()){
            return false;
        }
        return isMirror(root1.lChild,root2.rChild)&&isMirror(root1.rChild,root2.lChild);
    }
}
