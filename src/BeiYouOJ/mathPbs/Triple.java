package mathPbs;

import java.io.BufferedInputStream;
import java.util.Scanner;

public class Triple {

	public static void main(String[] args) {
		Scanner sc =new Scanner(new BufferedInputStream(System.in));
		int tms=sc.nextInt();
		while(tms>0) {
			int size=sc.nextInt();
			int[] nbs=new int[size];
			for(int i=0;i<size;i++)
			nbs[i]=sc.nextInt();
			calculate(nbs);
			tms--;
		}


	}

	
	public static void calculate(int[] nb) {
		int sum=0;
		for(int i=0;i<nb.length;i++)
		  for(int j=0;j<nb.length;j++)
		    for(int k=0;k<nb.length;k++) {
		    	if(nb[i]==nb[j]+nb[k])
		    		sum+=1;
		    }
		System.out.println(sum);
		
	}
}
