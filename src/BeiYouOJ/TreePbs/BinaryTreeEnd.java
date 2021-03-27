package TreePbs;

import java.io.BufferedInputStream;
import java.util.Scanner;

public class BinaryTreeEnd {

	public static void main(String[] args) {
		 Scanner sc=new Scanner(new BufferedInputStream(System.in));
		 String p=sc.nextLine();
		 System.out.println(p);
		 int[] pre=new int[p.length()];
		 for(int i=0;i<pre.length;i++)
		 pre[i]=Integer.parseInt(String.valueOf(p.charAt(i)));
		 int[] in=new int[p.length()];

		 for(int i=0;i<in.length;i++)
		 in[i]=sc.nextInt();
          
		 sc.close();
		tNode head= createTree(pre,0,in,0,p.length());
		showTree(head);
	}
	
	
   public static tNode createTree(int[] pre, int pst, int[] in, int ist, int n) {
	  if(n<=0)
	   return null;
	  tNode node = new tNode();
      node.value = pre[pst];
      int i;
      for (i = 0; i < n; ++i) {
          if (pre[pst] == in[ist + i]) 
              break;
      }
      node.lchild = createTree(pre, pst + 1, in, ist, i); 
      node.rchild = createTree(pre, pst + i + 1, in, ist + i + 1, n - i - 1); 
      return node;
    }
   
public static void showTree(tNode nd) {
	if(nd==null) {
	  return;
	}
	showTree(nd.lchild);
	showTree(nd.rchild);
	System.out.print(nd.value);
}	
	
	
	
	
}


class tNode{
	int value;
	tNode lchild, rchild;
}