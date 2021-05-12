package leetcode;

public class ConvertSortedListtoBinarySearchTree109 {

    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }


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


    public TreeNode sortedListToBST(ListNode head) {
        if(head==null)
            return null;
        if(head.next==null)
            return new TreeNode(head.val);
        ListNode pre=null;
        ListNode fast=head;
        ListNode slow=head;
        while(fast!=null&&fast.next!=null){
            fast=fast.next.next;
            pre=slow;
            slow=slow.next;
        }
        if(slow==null)
            return null;
        if(pre!=null)
            pre.next=null;
        TreeNode root=new TreeNode(slow.val);
        root.left=sortedListToBST(head);
        root.right=sortedListToBST(slow.next);
        return root;

    }





}
