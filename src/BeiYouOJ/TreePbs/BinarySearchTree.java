package TreePbs;

import java.io.BufferedInputStream;
import java.util.Scanner;

public class BinarySearchTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(new BufferedInputStream(System.in));
        int tms=sc.nextInt();
        while(tms>0) {
       int[] tree=new int[sc.nextInt()];
        for(int i=0;i<tree.length;i++)
        tree[i]=sc.nextInt();
        Judge(tree);	
        	tms--;
        }
        sc.close();
	}
     public static void Judge(int[] tr) {
    	 int flag=0;

    	 for(int i=1;i<tr.length;i++) {
    		 if(tr[i-1]>tr[i]) {
    			 flag=1;
    			 break;		 
    		 }
    			 
    	 } 
    	 if(flag==1) {
    		 System.out.println("No");
    	 }else {
    		 System.out.println("Yes");
    	 }
     }
}
