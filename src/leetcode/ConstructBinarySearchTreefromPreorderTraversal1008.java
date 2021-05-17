package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ConstructBinarySearchTreefromPreorderTraversal1008 {
  static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
         this.val = val;
          this.left = left;
          this.right = right;
      }
  }
  Map<Integer,Integer> map;
    public TreeNode bstFromPreorder(int[] preorder) {
        map=new HashMap<>();
        int[] sortNums=new int[preorder.length];
        for(int i=0;i<preorder.length;i++) {
            map.put(preorder[i], i);
            sortNums[i]=preorder[i];
        }
        Arrays.sort(sortNums);
        return buildNode(preorder,sortNums,0,preorder.length-1);
    }
    public TreeNode buildNode(int[] preorder, int[] sortNum,int a, int b){
        if(a>b)
            return null;
        int val=preorder[a];
        if(a==b)
            return new TreeNode(val);
         TreeNode root=new TreeNode(val);
         int st=a,ed=b,mid=0;
         while(st<=ed){
             mid=(st+ed)/2;
             if(sortNum[mid]>val){
                 ed=mid-1;
             }else if(sortNum[mid]<val){
                 st=mid+1;
             }else{
                 break;
             }
         }
        //unfinished
        int temp=sortNum[mid+1];
        int idx=map.get(temp);
        root.left=buildNode(preorder,sortNum,a+1,idx-1);
        root.right=buildNode(preorder,sortNum,idx,b);
        return root;
    }



}
