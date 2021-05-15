package interviewQuestion;

import java.util.HashMap;
import java.util.Map;

public class RebuildTree {

     static class TreeNode {
          int val;
         TreeNode left;
          TreeNode right;
          TreeNode(int x) { val = x; }
      }
   static Map<Integer,Integer> map;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
    map=new HashMap<>();
        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }
        TreeNode root=buildNode(preorder,0,preorder.length-1,inorder,0,preorder.length-1);
        return root;
    }
    public TreeNode buildNode(int[] preorder, int ps_idx,int pe_idx,int[] inorder,int is_idx,int ie_idx){
         if(ps_idx>pe_idx)
             return null;
         int val=preorder[ps_idx];
         int idx=map.get(val);
         int length=idx-is_idx;
         TreeNode root=new TreeNode(val);
         root.left=buildNode(preorder,ps_idx+1,ps_idx+length,inorder,is_idx,idx-1);
         root.right=buildNode(preorder,ps_idx+length+1,pe_idx,inorder,idx+1,ie_idx);
         return root;
    }

}
