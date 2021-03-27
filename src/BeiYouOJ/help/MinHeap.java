package help;

import java.io.BufferedInputStream;
import java.util.Scanner;

public class MinHeap {

	public static void main(String[] args) {
		Scanner sc=new Scanner(new BufferedInputStream(System.in));
		int tms=sc.nextInt();
		while(tms>0) {
			int flag=0;
		int[] value=new int[sc.nextInt()+1];
		int[] prs=new int[value.length];
		for(int i=1;i<value.length;i++)
			value[i]=sc.nextInt();
		for(int i=1;i<value.length-1;i++) {
			int father=sc.nextInt();
			int son=sc.nextInt();
			prs[son]=father;
		}
		for(int i=2;i<prs.length;i++) {
			if(value[i]<value[prs[i]]) {
				flag=1;
				break;
			}
		}
		if(flag==0){
			System.out.println("Yes");
		}else {
			System.out.println("No");
		}
			
			tms--;
		}

	}

}
