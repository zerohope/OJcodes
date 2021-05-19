package leetcode;

import java.util.HashMap;
import java.util.Map;

public class ConstructBinaryTreefromPreorderandPostorder889 {


    static class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
         TreeNode(int x) { val = x; }
      }
    static Map <Integer,Integer> map=new HashMap<>();
    public TreeNode constructFromPrePost(int[] pre, int[] post) {
     for(int i=0;i<post.length;i++){
         map.put(post[i],i);
     }
    return buildNode(pre,0,post.length-1,post,0,post.length-1);

    }
    public TreeNode buildNode(int[] pre, int pre_s, int pre_e, int[] post,int post_s,int post_e){
      if(pre_s>pre_e)
        return null;
      if(pre_s==pre_e)
          return new TreeNode(pre[pre_s]);
      TreeNode root=new TreeNode(pre[pre_s]);
      int idx=map.get(pre[pre_s+1]);
      root.left=buildNode(pre,pre_s+1,pre_s+1+idx-post_s,post,post_s,idx);
      root.right=buildNode(pre,pre_s+1+idx-post_s+1,pre_e,post,idx+1,post_e-1);
      return root;
    }



}
