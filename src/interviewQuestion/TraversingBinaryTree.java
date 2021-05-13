package interviewQuestion;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class TraversingBinaryTree {
    static class TreeNode{
     char val;
     TreeNode left;
     TreeNode right;
     public TreeNode(char v) {
         this.val = v;
     }
    }
    static StringBuilder st;
    static  HashMap<Character,Integer> map;
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        char[] inorder=sc.next().toCharArray();
        char[] leorder=sc.next().toCharArray();
        map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        boolean[] visit=new boolean[inorder.length+2];
        st=new StringBuilder(inorder.length);
        visit[0]=true;
        visit[visit.length-1]=true;
        visit[map.get(leorder[0])+1]=true;
        int idx=1;
        Queue<TreeNode> q=new LinkedList();
        TreeNode root=new TreeNode(leorder[0]);
        q.offer(root);
        while (!q.isEmpty()){
            TreeNode node =q.poll();
            if(!visit[map.get(node.val)-1+1]){
            node.left=new TreeNode(leorder[idx++]);
            visit[map.get(node.left.val)+1]=true;
            q.offer(node.left);
            }
            if(!visit[map.get(node.val)+1+1]){
                node.right=new TreeNode(leorder[idx++]);
                visit[map.get(node.right.val)+1]=true;
                q.offer(node.right);
            }
        }

        preOrder(root);
        System.out.println(st.toString());
    }
    public static void preOrder(TreeNode root){
        if(root==null)
            return ;
        st.append(root.val);
        preOrder(root.left);
        preOrder(root.right);
    }



    //尝试根据常规做法改，失败
    public static TreeNode buildTree(char[] inorder,int i_st, int i_ed,char[] leorder, int l_idx,int level){
        if(i_st>i_ed)
            return null;
        char root_val=leorder[l_idx];
        TreeNode root=new TreeNode(root_val);
        int i_root_idx=map.get(root_val);
        if(i_root_idx-i_st>0)
         root.left=buildTree(inorder,i_st,i_root_idx-1,leorder,l_idx+1+level,level+1);
        if(i_ed-i_root_idx>0)
        root.right=buildTree(inorder,i_root_idx+1,i_ed,leorder,l_idx+2+level,level+1);

        return root;
    }







}
