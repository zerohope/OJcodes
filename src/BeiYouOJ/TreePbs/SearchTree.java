package TreePbs;

import java.io.BufferedInputStream;
import java.util.Scanner;
//建立完全二叉树
public class SearchTree {

	public static void main(String[] args) {
		Scanner sc=new Scanner(new BufferedInputStream(System.in));
          int length=sc.nextInt();
          int[] tree=new int[length];
          for(int i=0;i<length;i++) {
        	  tree[i]=sc.nextInt();
          }
          searchNode(sc.nextInt(),tree);
          
          sc.close();
	}
	
	public static void searchNode(int level, int[] tree) {
		int bl=(int) Math.pow(2, level-1)-1;
		int nl=(int) Math.pow(2, level)-1;
		if(bl>tree.length) {
			System.out.println("EMPTY");
			return ;
		}
		if(nl>tree.length) {
			nl=tree.length;
		}
		for(;bl<nl;bl++) {
			if(bl==nl-1) {
				System.out.print(tree[bl]);
			}
			else {
			System.out.print(tree[bl]+" ");
			}
		}
		
	}
 
}
