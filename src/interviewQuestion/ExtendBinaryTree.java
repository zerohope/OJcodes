package interviewQuestion;

import java.util.Scanner;
class BinaryTree{
    char val;
    BinaryTree left;
    BinaryTree right;
    public BinaryTree(char v){
        this.val=v;
    }
}
public class ExtendBinaryTree {
    static char[] preOrder;
    static int idx=0;
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        preOrder=sc.next().toCharArray();
        BinaryTree root=buildTree();
        inOrder(root);
        System.out.println("");
        afOrder(root);
    }
public static BinaryTree buildTree(){
        if(preOrder[idx]=='.'){
            idx++;
            return null;
        }
        BinaryTree node=new BinaryTree(preOrder[idx++]);
        node.left=buildTree();
        node.right=buildTree();
        return node;
}
public static void inOrder(BinaryTree root){
 if(root==null){
     return;
 }
    inOrder(root.left);
    System.out.print(root.val);
    inOrder(root.right);
}
public static void afOrder(BinaryTree root){
        if(root==null){
            return;
        }
        afOrder(root.left);
        afOrder(root.right);
        System.out.print(root.val);
    }

}
