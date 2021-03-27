import java.util.ArrayList;
import java.util.List;

public class BinaryTreeLongestConsecutiveSequence549 {
    List<TreeNode> Inc=new ArrayList<TreeNode>();
    List<TreeNode> Dec=new ArrayList<TreeNode>();
    public int longestConsecutive(TreeNode root) {
        return 0;
    }


    public void inorder(TreeNode root){
        if(root==null)
            return;
        if(Inc.isEmpty())
            Inc.add(root);
        if(Inc.get(Inc.size()-1).val+1==root.val)
            Inc.add(root);

    }

}
class solution549 {
    int res = 0;

    public int longestConsecutive(TreeNode root) {
        helper(root);
        return res;
    }

    private int[] helper(TreeNode root) {
        //arr[0]为递增序列路径数，arr[1]为递减序列路径数
        int[] arr = new int[2];
        arr[0] = 1;
        arr[1] = 1;
        if (root == null) return arr;
        int[] left = helper(root.left);
        int[] right = helper(root.right);
        //判断root在左子树中处于递增还是递减
        if (root.left != null) {
            if (root.left.val - 1 == root.val) arr[1] = left[1] + 1;
            if (root.left.val + 1 == root.val) arr[0] = left[0] + 1;
        }

        //判断root在右子树中处于递增还是递减，最后arr结果中保留最大值
        if (root.right != null) {
            if (root.right.val - 1 == root.val) arr[1] = Math.max(arr[1], right[1] + 1);
            if (root.right.val + 1 == root.val) arr[0] = Math.max(arr[0], right[0] + 1);
        }

        //统计结果
        res = Math.max(res, arr[0] + arr[1] - 1);
        return arr;
    }
}

