import java.util.LinkedList;
import java.util.Queue;

public class isSubStructureOffer26 {

    public static void main(String[] args){
        TreeNode root=new TreeNode(1);
        root.left=new TreeNode(0);
        root.right=new TreeNode(1);
        root.left.left=new TreeNode(-4);
        root.left.right=new TreeNode(-3);
        TreeNode B=new TreeNode(1);
        B.left=new TreeNode(-4);
        System.out.println(isSubStructure(root,B));
    }

    public static boolean isSubStructure(TreeNode A, TreeNode B) {
        String root="";
        String child="";
        root=preorderTr(A);
        child=preorderTr(B);
        if(root.equals("")&&child.equals(""))
            return true;
        if(root.equals("") || child.equals(""))
            return false;
        System.out.println(levelOrder(A));
        System.out.println(levelOrder(B));
        if(levelOrder(A).contains(levelOrder(B)))
            return true;
        if(root.contains(child))
            return true;
        return false;
    }
    public static String preorderTr(TreeNode root){
        if(root==null)
            return "";
        String temp=String.valueOf(root.val);
        temp+=preorderTr(root.left);
        temp+=preorderTr(root.right);
        return temp;
    }
    public static  String levelOrder(TreeNode root){
        String value="";
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        while(!queue.isEmpty()){
            TreeNode node=queue.poll();
            if(node!=null){
                value+=node.val;
                queue.offer(node.left);
                queue.offer(node.right);
            }
        }
        return value;
    }

}
