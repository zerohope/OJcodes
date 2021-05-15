package leetcode;

public class InorderSuccessorinBSTII {
      public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode father;
      TreeNode(int x) { val = x; }
  }
    public TreeNode inorderSuccessor(TreeNode p) {
      if(p.right!=null){
          p=p.right;
          while(p.left!=null)
              p=p.left;
          return p;
      }else{
          while(p.father!=null&&p==p.father.right)
            p=p.father;
          return p.father;
      }

    }

}
