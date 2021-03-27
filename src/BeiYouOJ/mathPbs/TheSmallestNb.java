package mathPbs;

import java.io.BufferedInputStream;
import java.util.Arrays;
import java.util.Scanner;

public class TheSmallestNb {

	public static void main(String[] args) {
		Scanner sc=new Scanner(new BufferedInputStream(System.in));
        Nb[] nbs=new Nb[sc.nextInt()];
        for(int i=0;i<nbs.length;i++) {
        	nbs[i]=new Nb(sc.nextInt(),sc.nextInt());
        }
        Arrays.sort(nbs);
        System.out.println(nbs[0].a+" "+nbs[0].b);
        sc.close();
	}

}
class Nb implements Comparable<Nb>{
   int a;
   int b;
   public Nb(int a, int b) {
	   this.a=a;
	   this.b=b;
   }
	
	
	@Override
	public int compareTo(Nb o) {
		  int i=this.a-o.a;
		if(i==0) {
			return this.b-o.b;
		}
		  
		return i;
	}
	
	
	
}