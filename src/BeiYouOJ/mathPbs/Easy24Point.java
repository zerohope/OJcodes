package mathPbs;

import java.io.BufferedInputStream;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Easy24Point {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(new BufferedInputStream(System.in));
		int tms=sc.nextInt();
		while(tms>0) {
			Operation(new int[] {sc.nextInt(),sc.nextInt(),sc.nextInt(),sc.nextInt()});
			tms--;
		}

	}
	
	public static void Operation(int[]nb) {
		Queue<Integer> q=new LinkedList<Integer>() ;
		calculate(24,nb[0],q);
		for(int i=1;i<3;i++) {
		int a=q.size();
		while(a>0) {
		calculate(q.poll(),nb[i],q);
		a--;
		}
		}
		if(q.contains(nb[3])) {
			System.out.println("Yes");
		}else {
			
			System.out.println("No");
		}
	}
	public static void calculate(int a, int b,Queue<Integer> q) {
		 q.offer(a+b);
		 q.offer(a-b);
		 q.offer(a*b);
	     if(b!=0&&a%b==0) {
			q.offer(a/b);
		 }
	}

}
