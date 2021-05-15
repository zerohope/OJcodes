package leetcode;

public class inorderSuccessor285 {
    static public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }


    private TreeNode ans;

    // 二叉搜索树的顺序后继
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        inOrder(root, p);
        return ans;
    }

    private void inOrder(TreeNode root, TreeNode p) {
        if (root == null || ans != null) return;
        inOrder(root.left, p);
        if (ans == null && root.val > p.val) ans = root;
        inOrder(root.right, p);
    }




}
