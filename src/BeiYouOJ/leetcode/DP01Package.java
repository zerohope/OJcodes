package leetcode;

import java.io.BufferedInputStream;
import java.util.Scanner;

public class DP01Package {

	public static void main(String[] args) {
	 Scanner sc=new Scanner(new BufferedInputStream(System.in));
	   int time=sc.nextInt();
	   int amount=sc.nextInt();
	   int f[]=new int[1002];
	   for(int i=1;i<=amount;i++) {
		   int ct=sc.nextInt();
		   int cv=sc.nextInt();
		   for(int j=time;j>=ct;j--) {
			   f[j]=Math.max(f[j], f[j-ct]+cv);
		   }
		   
	   }
		 System.out.println(f[time]);
	}

}
