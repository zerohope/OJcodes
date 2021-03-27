import java.util.Stack;

public class flatten114 {

    public static  void main(String[] args){
     TreeNode root=new TreeNode(1);
     root.left=new TreeNode(2);
     root.right=new TreeNode(3);
     TreeNode node=new TreeNode();
        TreeNode temp=node;
        inorder(root,node);
        root=temp.right;
    }
    public static void inorder(TreeNode root,TreeNode node){
        Stack<TreeNode> st=new Stack();
        st.push(root);
        while(!st.isEmpty()|| root!=null){
            while(root!=null){
                node.right=new TreeNode(root.val);
                node.left=null;
                node=node.right;
                if(root.left!=null){
                    st.push(root.left);
                }
                root=root.left;
            }
            if(!st.isEmpty()) {
                root = st.pop();
                root = root.right;
            }
        }
    }


}
