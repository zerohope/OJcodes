package TreePbs;

import java.io.BufferedInputStream;
import java.util.Scanner;

public class InorderTraversal {

	public static void main(String[] args) {
		Scanner sc=new Scanner(new BufferedInputStream(System.in));
        int tm=sc.nextInt();
        String[] ends=new String[tm];
        for(int i=0;i<tm;i++) {
        	int flag=0;
        	int length=sc.nextInt();
        	int[] tree=new int[length];
        	for(int j=0;j<length;j++)
        	tree[j]=sc.nextInt();
        	for(int j=1;j<length;j++) {
        	   if(tree[j]>tree[j-1]) 
        	        continue;
        	   else {
        		   flag=1;
        		   break;
        	   }
        	}
        	if(flag==0)
        		ends[i]="Yes";
        	else {
        		ends[i]="No";
        	}
        }
        for(int i=0;i<tm;i++)
        	System.out.println(ends[i]);
	}

}
