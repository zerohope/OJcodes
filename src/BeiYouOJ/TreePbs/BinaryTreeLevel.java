package TreePbs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class BinaryTreeLevel {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int tms=sc.nextInt();
		String[] ends=new String[tms];
		for(int i=0;i<tms;i++) {
			ends[i]="";
			sc.nextInt();
			int tnb=sc.nextInt();
			Btree[] trs=new Btree[tnb+1];
			for(int j=0;j<tnb+1;j++)
				trs[j]=new Btree(0,j);
			for(int j=1;j<tnb;j++) {
				int c=sc.nextInt();
				int p=sc.nextInt();
				if(trs[p].lchild!=null)
					trs[p].rchild=trs[c];
				else {
					trs[p].lchild=trs[c];
				}
			}
           showDeep(trs[1]);
           ends[i]=showEnd(trs[1]);
		}
		for(int i=0;i<tms;i++) {
	    System.out.println("Q"+(i+1)+":");
	    System.out.println(ends[i]);
	    
			
		}
	}
	
	public static void showDeep(Btree b) {
	    Stack<Btree> stack=new Stack<Btree>();
		stack.push(b);
		while(!stack.isEmpty()) {
			Btree n=stack.pop();
			if(n.lchild!=null) {
				n.lchild.deepth=n.deepth+1;
			stack.push(n.lchild);	
			}
			if(n.rchild!=null) {
				n.rchild.deepth=n.deepth+1;
				stack.push(n.rchild);
			}	
		}
	}
	
	public static String showEnd(Btree b) {
		String ed="";
		Queue<Btree> qe=new LinkedList<Btree>();
		qe.offer(b);
		while(!qe.isEmpty()) {
		Btree bt=qe.poll();
			if(bt.lchild!=null) 
				qe.offer(bt.lchild);
			if(bt.rchild!=null)
			  qe.offer(bt.rchild);
			if(!qe.isEmpty()) {
			if(bt.deepth==qe.element().deepth) {
				ed+=bt.value+" ";
			}else {
				ed+=bt.value+"\n";
			}
			}else {
				ed+=bt.value;
			}		
		}
		
		return ed;
	}
	
		}
class Btree{
 public	int deepth;
 public int value;
 public	Btree lchild;
 public	Btree rchild;
 
public Btree(int deepth, int value) {
	super();
	this.deepth = deepth;
	this.value=value;
	this.lchild =null;
	this.rchild =null ;
}
}
