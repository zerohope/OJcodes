package mathPbs;

import java.io.BufferedInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SpecialNumber {
 
	public static void main(String[] args) {
	Scanner sc=new Scanner(new BufferedInputStream(System.in));
	int tms=sc.nextInt();
	while(tms>0) {
	
    testNb(sc.nextInt());
    tms--;
	}
	sc.close();
	}
	public static void testNb(int g) {
		int rs=0;

	  for(long i=1;i*i*i<g+1;i++) {
		  long temp=i*i*i;
		  for(int j=1;j*j<temp+1;j++) {
			  if(j*j==temp) {
				  rs++;
			  }
			  
		  }
	  }
		System.out.println(rs);
		
		
	}

}
