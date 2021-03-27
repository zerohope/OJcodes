package TreePbs;

import java.io.BufferedInputStream;
import java.util.Scanner;

public class BinarySortTree {
    public static int flag=0;
	public static void main(String[] args) {
		Scanner sc=new Scanner(new BufferedInputStream(System.in));
        int length=sc.nextInt();    
        TreeNode root=new TreeNode(sc.nextInt());
            
        for(int i=1;i<length;i++)
        	InsertNode(root,sc.nextInt());
        if(length==1) {
        	System.out.println(-1);
        }
        
	}
	
	
	public static void InsertNode(TreeNode root,int value) {
		if(flag==0) {
			System.out.println(-1);
			flag=-1;
		}
		TreeNode nd=new TreeNode(value);
		 while(root!=null) {
			 if(root.value>value) {
				 if(root.lchild!=null)
				     root=root.lchild;
				 else {
					 root.lchild=nd;
					 System.out.println(root.value);
                       break;
				 } 
			 }else {
				 if(root.rchild!=null)
				    root=root.rchild;
				 else {
					 root.rchild=nd;
					 System.out.println(root.value);
					 break;
				 }
			 }	 
		 }
	}
}



class TreeNode{
   public int value;
   public TreeNode lchild;
   public TreeNode rchild;
   
	public TreeNode(int v) {
		this.value=v;
		this.lchild=null;
		this.rchild=null;
	}
}
