
public class PopulatingNextRight117 {
    public static void main(String[] args){
        Node root=new Node(1);
        root.left=new Node(2);
        root.right=new Node(3);
        connect(root);


    }




    public static Node connect(Node root) {
        if(root==null)
            return root;
        Node cur=root;
        Node dummy=new Node(0);
        while(cur!=null){
            Node pre=dummy;
            while(cur!=null){
                if(cur.left!=null){
                    pre.next=cur.left;
                    pre=pre.next;
                }
                if(cur.right!=null){
                    pre.next=cur.right;
                    pre=pre.next;
                }
                cur=cur.next;
            }
            cur=dummy.next;
            dummy.next=null;
        }
        return root;
    }
}

class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};