public class MaximumProductofSplittedBinaryTree1339 {
   static int total=0;
    static int temp=0;

    public static void main(String[] args){
        TreeNode node=new TreeNode(1);
        node.left=new TreeNode(2);
        node.right=new TreeNode(3);
        node.left.left=new TreeNode(4);
        node.left.right=new TreeNode(5);
        node.right.left=new TreeNode(6);
        maxProduct(node);
        System.out.println(temp);



    }


    public static int maxProduct(TreeNode root) {
        if(root==null)
            return 0;
        total=totalSum(root);
        inorder(root);
        return temp%( 10^9 + 7);
    }
    public static void inorder(TreeNode root){
        if(root==null)
            return;
        int sum=totalSum(root);
        if(temp<sum*(total-sum))
            temp=sum*(total-sum);
        inorder(root.left);
        inorder(root.right);
    }

    public static int totalSum(TreeNode root){
        if(root==null)
            return 0;
        return root.val+totalSum(root.left)+totalSum(root.right);
    }






}
