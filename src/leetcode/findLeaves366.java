import java.util.ArrayList;
import java.util.List;

public class findLeaves366 {
    List<Integer> saveLeave=new ArrayList<Integer>();
    public  static void main(String[] args){
    }
    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> allLeaves=new ArrayList<List<Integer>>();
        while(!(root.left==null&&root.right==null)){
            inorder(root);
            List<Integer> temp=new ArrayList<Integer>();
            temp.addAll(saveLeave);
            saveLeave.clear();
            allLeaves.add(temp);
        }
        allLeaves.add(new ArrayList(root.val));
        return allLeaves;
    }
    public void inorder(TreeNode root){
        if(root==null||(root.left==null&&root.right==null))
            return ;
        if(root.left!=null)
            if(root.left.left==null&&root.left.right==null){
                saveLeave.add(root.left.val);
                root.left=null;
            }
        if(root.right!=null)
            if(root.right.left==null&&root.right.right==null){
                saveLeave.add(root.right.val);
                root.right=null;
            }

        inorder(root.left);
        inorder(root.right);
    }


}
/*
class Solution {
    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> resList = new ArrayList<>();
        while(root != null){
            List list = new ArrayList<>();
            root = recur(root, list);
            resList.add(list);
        }
        return resList;
    }
    private TreeNode recur(TreeNode root, List<Integer> list){
        if(root == null){
            return null;
        }
        if(root.left == null && root.right == null){
            list.add(root.val);
            return null;
        }
        root.left = recur(root.left, list);
        root.right = recur(root.right, list);
        return root;
    }
}
*/

