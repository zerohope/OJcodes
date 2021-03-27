package mathPbs;

import java.io.BufferedInputStream;
import java.util.Scanner;

public class Varray {

	public static void main(String[] args) {
		Scanner sc=new Scanner(new BufferedInputStream(System.in));
        int tms=sc.nextInt();
        while(tms>0) {
        	int[] nbs=new int[sc.nextInt()];
        	for(int i=0;i<nbs.length;i++)
        	nbs[i]=sc.nextInt();
        	calculate(nbs);
        	tms--;
        }
	}
    public static void calculate(int[] nbs) {
    	int amount=0;
    	for(int i=0;i<nbs.length;i++)
    	  for(int j=i+1;j<nbs.length;j++) {
    		 if(nbs[j]>nbs[i]||nbs[j]==nbs[i]) {
    			 continue;
    		 }else {
    	    for(int k=j+1;k<nbs.length;k++) {
    	    	 if(nbs[j]>nbs[k]||nbs[j]==nbs[k]) {
        			 continue;
        		 }else {
        			 amount++;
        		 }
    	        }
    		 }
    	  }
    	
    	System.out.println(amount);
    }
	
}
