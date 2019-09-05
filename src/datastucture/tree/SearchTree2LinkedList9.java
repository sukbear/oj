package datastucture.tree;

/***
 *@ClassName SearchTree2LinkedList9
 *@Description
 * @author sukbear
 * @create 2019-05-22 16:22
 */
public class SearchTree2LinkedList9 {
    private TreeNode head = null;
    private TreeNode end = null;
    public  TreeNode Convert(TreeNode root){
        inorder(root);
        return head;
    }
    private   void inorder(TreeNode root){
        if(root==null){
            return;
        }
        Convert(root.lChild);
        if(end==null){
            end = root;
            head = root;
        }else{
            end.rChild= root;
            root.lChild = end;
            end = root;
        }
        Convert(root.rChild);
    }
    public static void main(String[] args) {
        SearchTree2LinkedList9 obj = new SearchTree2LinkedList9();
        TreeNode a = new TreeNode(10);
        TreeNode b = new TreeNode(6);
        TreeNode c = new TreeNode(14);
        TreeNode d = new TreeNode(4);
        TreeNode e = new TreeNode(8);
        TreeNode f = new TreeNode(12);
        TreeNode g = new TreeNode(16);
        a.lChild= b;
        a.rChild=c;
        b.lChild=d;
        b.rChild=e;
        c.lChild=f;
        c.rChild=g;
        TreeNode res = obj.Convert(a);
        while(true){
            if(res!=null){
                System.out.println(res.getData());
                res = res.rChild;
            }else {
                break;
            }

        }
    }
}
