package interviewQuestion;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class UpToDownPrintTree {

      static public class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
         TreeNode(int x) { val = x; }
      }


    public List<Integer> printFromTopToBottom(TreeNode root) {
        List<Integer> res=new ArrayList<>();
        Queue<TreeNode> q=new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            TreeNode node=q.poll();
            res.add(node.val);
            if(node.left!=null)
              q.offer(node.left);
            if(node.right!=null)
                q.offer(node.right);
        }
        return res;
      }



}
