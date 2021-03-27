package help;

import java.io.BufferedInputStream;
import java.util.Scanner;

public class NumberSystemCovert {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
      Scanner sc=new Scanner(new BufferedInputStream(System.in));
      int tms=sc.nextInt();
      while(tms>0) {
    	  Covert(sc.nextLong());
    	  tms--;
      }
	}
	public static void Covert(long n) {
		long end=0;
		String bn=Long.toBinaryString(n);
		for(int i=0;i<bn.length();i++) {
		int nb=Integer.parseInt(String.valueOf(bn.charAt(i)));
		 if(nb==1) {
			 end+=Math.pow(2, i);
		 }		
		}
	System.out.println(end);	
		
	}

}
