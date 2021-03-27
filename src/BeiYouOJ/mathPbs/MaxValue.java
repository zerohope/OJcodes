package mathPbs;

import java.io.BufferedInputStream;
import java.util.Scanner;

public class MaxValue {
	static int[] vl=new int[3];
	public static void main(String[] args) {
		Scanner sc=new Scanner(new BufferedInputStream(System.in));
		int amount=sc.nextInt();
		int a=0,b=0;
		int min=0,max=0;
		part[] ps=new part[sc.nextInt()];
		for(int i=0;i<vl.length;i++) {
		   vl[i]=sc.nextInt();
		}
		for(int i=0;i<ps.length;i++) {
			a=sc.nextInt();
			b=sc.nextInt();
			if(a<min) {
				min=a;
			}
			if(b>max) {
				max=b;
			}
			ps[i]=new part(a,b);
		}
       
	}

}
class part{
	int min;
	int max;
	public part(int min, int max) {
		this.min=min;
		this.max=max;
	}
	
}