package datastucture.tree;

/**
 * @author sukbear
 * @create 2019-03-02 11:55
 */
public class TreeNode {
    String  data;
    TreeNode lChild;
    TreeNode rChild;

    public TreeNode(String data) {
        this.data = data;
    }

    public TreeNode(String data, TreeNode lChild, TreeNode rChild) {
        this.data = data;
        this.lChild = lChild;
        this.rChild = rChild;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public TreeNode getlChild() {
        return lChild;
    }

    public void setlChild(TreeNode lChild) {
        this.lChild = lChild;
    }

    public TreeNode getrChild() {
        return rChild;
    }

    public void setrChild(TreeNode rChild) {
        this.rChild = rChild;
    }
}
