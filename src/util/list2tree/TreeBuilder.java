package util.list2tree;

import java.util.ArrayList;
import java.util.List;

/***
 *@ClassName TreeBuilder
 *@Description
 * @author sukbear
 * @create 2019-10-09 17:31
 */
public class TreeBuilder {
    public static List<TreeNode> build(List<TreeNode> treeNodes){
        List<TreeNode> trees = new ArrayList<>();
        /**两层for循环找到根节点的孩纸过着其他的树形*/
        for(TreeNode treeNode: treeNodes){
            if("0".equals(treeNode.getPid())){
                trees.add(treeNode);
            }
            for(TreeNode it: treeNodes){
                if(it.getPid()==treeNode.getId()){
                    if(treeNode.getChildren()==null){
                        treeNode.setChildren(new ArrayList<TreeNode>());
                    }
                    treeNode.getChildren().add(it);
                }
            }
        }
        return trees;
    }
    /**递归版本（根节点id）*/
static List<TreeNode> build(List<TreeNode> lists,String pid){
        List<TreeNode> trees = new ArrayList<>();
        for(TreeNode node :lists){
            String id = node.getId();
            String parentId = node.getPid();
            if(parentId.equals(pid)){
                List<TreeNode> chi = build(lists,id);
                node.setChildren(chi);
                trees.add(node);
            }
        }
        return trees;
}
    public static void main(String[] args) {

        TreeNode treeNode1 = new TreeNode("1","广州","0");
        TreeNode treeNode2 = new TreeNode("2","深圳","0");

        TreeNode treeNode3 = new TreeNode("3","天河区","1");
        TreeNode treeNode4 = new TreeNode("4","越秀区","1");
        TreeNode treeNode5 = new TreeNode("5","黄埔区","1");
        TreeNode treeNode6 = new TreeNode("6","石牌",treeNode3);
        TreeNode treeNode7 = new TreeNode("7","百脑汇",treeNode6);


        TreeNode treeNode8 = new TreeNode("8","南山区",treeNode2);
        TreeNode treeNode9 = new TreeNode("9","宝安区",treeNode2);
        TreeNode treeNode10 = new TreeNode("10","科技园",treeNode8);


        List<TreeNode> list = new ArrayList<TreeNode>();

        list.add(treeNode1);
        list.add(treeNode2);
        list.add(treeNode3);
        list.add(treeNode4);
        list.add(treeNode5);
        list.add(treeNode6);
        list.add(treeNode7);
        list.add(treeNode8);
        list.add(treeNode9);
        list.add(treeNode10);
       List<TreeNode> res =  TreeBuilder.build(list,"0");
        System.out.print( res.toString() );
    }
}
