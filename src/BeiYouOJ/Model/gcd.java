package Model;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;



public class gcd {

	public static void main(String[] args) {
	  DecimalFormat df=new DecimalFormat("0.0");
	  df.setRoundingMode(RoundingMode.FLOOR);
	System.out.println( df.format(1.25));
      
	}
	
   public static void gcd(int a, int b) {

	 int t=0;
	 if(b>a) {
		 t=b;
		 b=a;
		 a=t;
	 }
	 while(b!=0) {
		t=a%b;
		a=b;
		b=t; 
	 }  
	   System.out.println(a);
	   
   }
   
   public static void fastPower(int a, int b) {
	   int base=a;
	   int ans=1;
	   while(b!=0) {
		   if((b&1)!=0) {
			   ans*=base;
		   }
		   base*=base;
		   b>>=1;
	   }
	   System.out.println(ans);
   }
   
   public static void multyM(int[][] a,int [][] b) {
	   int[][] c=new int[a.length][b[0].length];
	   for(int i=0;i<c.length;i++)
	     for(int j=0;j<c[0].length;j++)
	       for(int k=0;k<a[0].length;k++) {
	    	   c[i][j]+=a[i][k]*b[k][j];
	       }                    
   }
   public static void coverBinary(int a) {
	   String value=Integer.toBinaryString(a);
   }
   public static void Qn() {
	   Queue<Integer> q=new LinkedList<Integer>();
	   q.offer(1);
	   q.poll();
	   Stack<Integer>s =new Stack<Integer>();
	   s.push(1);
	   s.peek();
	   
   }
   public static void insertNode(Node root, int value) {
	     Node nd=new Node(value);
	     while(root!=null) {
	    	 if(root.value>value) {
	    		 if(root.lchild!=null)
	    			 root=root.lchild;
	    		 else
	    			 root.lchild=nd;	    		 
	    	 }else {
	    	 }
	     }
   }
   

   
}
class Node{
	int value;
	Node lchild;
	Node rchild;
	public Node(int value) {
		this.value=value;
	}
	
}