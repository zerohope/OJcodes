package TreePbs;

import java.io.BufferedInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BuildBinarySortTree {

	public static void main(String[] args) {
		Scanner sc =new Scanner(new BufferedInputStream(System.in));
		while(sc.hasNext()) {
		int amount=sc.nextInt();
		List<Integer> v=new ArrayList<Integer>();
		for(int i=0;i<amount;i++) {
			int vl=sc.nextInt();
			if(!v.contains(vl))
				v.add(vl);
		}
		SNode root=new SNode(v.get(0));
		for(int i=1;i<v.size();i++)
			InsertNode(root,v.get(i));
		
		preOrder(root);
		System.out.println("");
		inOrder(root);
		System.out.println("");
		postOrder(root);
		System.out.println("");
		}
	}
	
	public static void InsertNode(SNode root,int value) {
		SNode nd=new SNode(value);
		 while(root!=null) {
			 if(root.value>value) {
				 if(root.lchild!=null)
				     root=root.lchild;
				 else {
					 root.lchild=nd;
                       break;
				 } 
			 }else {
				 if(root.rchild!=null)
				    root=root.rchild;
				 else {
					 root.rchild=nd;
					 break;
				 }
			 }	 
		 }
	}
 
	public static void preOrder(SNode root) {
		if(root!=null) {
		System.out.print(root.value+" ");
		preOrder(root.lchild);
		preOrder(root.rchild);
		}
	}
	public static void inOrder(SNode root) {
		if(root!=null) {
			inOrder(root.lchild);
		System.out.print(root.value+" ");
		inOrder(root.rchild);
		}
	}
	public static void postOrder(SNode root) {
		if(root!=null) {
	   postOrder(root.lchild);
	   postOrder(root.rchild);
		System.out.print(root.value+" ");
		}
	}
}

class SNode{
	  public int value;
	   public SNode lchild;
	   public SNode rchild;
	   
		public SNode(int v) {
			this.value=v;
			this.lchild=null;
			this.rchild=null;
		}
	
}