package leetcode;

public class Offer36TreeToDoubly {
    static  class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val,Node _left,Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    };
    Node pre,head;
    public Node treeToDoublyList(Node root){

         inOrder(root);
         head.left=pre;
         pre.right=head;
         return head;
    }
    public void inOrder(Node cur){
        if(cur==null)
            return ;
        inOrder(cur.left);
        if(pre!=null)
            pre.right=cur;
        else
            head=cur;
        cur.left=pre;
        pre=cur;
        inOrder(cur.right);
    }



}
