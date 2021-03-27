package mathPbs;

import java.io.BufferedInputStream;
import java.util.Scanner;

public class FractionAddition {

	public static void main(String[] args) {
		Scanner sc=new Scanner(new BufferedInputStream(System.in));
        String[] ends=new String[sc.nextInt()];
        for(int i=0;i<ends.length;i++) {
        	ends[i]=frcAdd(sc.nextInt(),sc.nextInt());
        }
       for(int i=0;i<ends.length;i++) {
    	   System.out.println(ends[i]);
       }
       sc.close();
	}
	
	//2^-a+2^-b
	public static String frcAdd(int a, int b) {
	    double y=Math.pow(2, a+b);
		double x=Math.pow(2, a)+Math.pow(2, b);
		double i=1;
		double tx=x;
		double ty=y;
	   while(i!=0) {
         i=ty%tx; 		  
		 ty=tx;
         tx=i;		
	   }

		return (int)(x/ty)+"/"+(int)(y/ty);
	}
	

}
