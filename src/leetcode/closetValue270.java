public class closetValue270 {
    public int closetValue(TreeNode node, double target){
        boolean flag=true;
        while(flag){
        if(target>node.val){
            if(target>node.right.val) {
                node = node.right;
                continue;
            }else{
              return (node.right.val-target)>(target-node.val)?node.val:node.right.val ;
            }
        }else{
            if(target<node.left.val) {
                node = node.left;
                continue;
            }else{
                return (node.val-target)>(target-node.left.val)?node.left.val:node.val ;
            }

        }

        }
      return 0;
    }
    class Solution {
        public int closestValue(TreeNode root, double target) {
            int closest = root.val;
            int curVal;
            while (root != null) {
                curVal = root.val;
                closest = Math.abs(curVal - target) < Math.abs(closest - target) ? curVal : closest;
                root = target < root.val ? root.left : root.right;
            }
            return closest;
        }
    }



}
