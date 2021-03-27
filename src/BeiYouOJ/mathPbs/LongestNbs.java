package mathPbs;

import java.io.BufferedInputStream;
import java.util.Arrays;
import java.util.Scanner;

public class LongestNbs {
	
public static void main(String[] args) {
	Scanner sc=new Scanner(new BufferedInputStream(System.in));
	int tms=sc.nextInt();
	int[] ends=new int[tms];
	for(int i=0;i<tms;i++) {
		int[] nbs=new int[sc.nextInt()];
		for(int j=0;j<nbs.length;j++) {
		   nbs[j]=sc.nextInt();  
		}
	    ends[i]=calcuNb(nbs);		
	}
	for(int i=0;i<tms;i++) {
		System.out.println(ends[i]);
	}
	
}

public static int calcuNb(int[] nbs) {
	if(nbs.length<3) {
		return nbs.length;
	}

	int count=2;
	int t_count=2;
	for(int i=2;i<nbs.length;i++) {
		
			/*
			 * for(int j=i+1;j<nbs.length;j++) { int rs=nbs[j]-nbs[i]; int temp=j; int tc=2;
			 * while(temp<nbs.length-1) { int sum=nbs[temp]+rs; int k=temp+1;
			 * for(;k<nbs.length;k++) { if(sum==nbs[k]) { tc++; break; } } temp=k; }
			 * if(tc>count) { count=tc; } }
			 */
		if(nbs[i]-nbs[i-1]==nbs[i-1]-nbs[i-2]) {
			t_count++;
			if(t_count>count) {
				count=t_count;
			}
		}else {
			t_count=2;
		}
		
		
		
		
	}
	return count;
}

}


//第一遍纠错 端点值(数组长度为1)
//第二遍纠错 逻辑错误（只考虑了后一个数 2 3 4 4 5  6 7）