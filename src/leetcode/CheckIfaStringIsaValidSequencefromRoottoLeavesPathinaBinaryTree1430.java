public class CheckIfaStringIsaValidSequencefromRoottoLeavesPathinaBinaryTree1430 {
    public boolean isValidSequence(TreeNode root, int[] arr) {

        return vaildCheck(root, arr, 0);


    }
    public boolean vaildCheck(TreeNode root, int[] arr, int idx){
        if(root==null)
            return false;
        if(idx>arr.length-1||root.val!=arr[idx])
            return false;
        if(root.left==null&&root.right==null&&root.val==arr[arr.length-1])
            return true;
        return vaildCheck(root.left, arr, idx+1)|| vaildCheck(root.right, arr, idx+1);
    }
}
