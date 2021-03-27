package mathPbs;

import java.io.BufferedInputStream;
import java.util.Scanner;

public class NonsquareEquation {

	public static void main(String[] args) {
		int flag=0;
		Scanner sc=new Scanner(new BufferedInputStream(System.in));
		long n=sc.nextLong();
		long sqn=(long) Math.sqrt(n);
	    for(long i=sqn-82;i<=sqn+2;i++) {
	    	if(i<0)
	    	 i=0;
	    	if(i*i+getSx(i)*i==n) {
	    		flag=1;
	    		System.out.println(i);
	    		break;
	    	}     
	     }	
        if(flag==0)
        	System.out.println(-1);
        sc.close();
	    }
	
    public static long getSx(long i) {
	   long sx=0;
	   while(i>0) {
		  sx+=i%10;
		  i=i/10;
	  }
	  return sx;
  }  
  
  
  }
 
	


