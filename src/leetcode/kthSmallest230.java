public class kthSmallest230 {

    public static void main(String[] args){
        TreeNode root=new TreeNode(3);
        root.left=new TreeNode(1);

        root.left.right=new TreeNode(2);

        System.out.println(kthSmallest(root,1));

    }

    public static int kthSmallest(TreeNode root, int k) {
        if(root==null)
            return 0;
        kthSmallest(root.left,k--);
        if(k==0)
            return root.val;
        kthSmallest(root.right,k--);
         return 0;
    }



}
