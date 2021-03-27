package mathPbs;

import java.io.BufferedInputStream;
import java.util.Scanner;

public class ImultiJ {

	public static void main(String[] args) {
		Scanner sc=new Scanner(new BufferedInputStream(System.in));
        int tms=sc.nextInt();
        while(tms>0) {
        	Judge(sc.nextInt(),sc.nextInt());
        	
        	tms--;
        }
	}
      public static void Judge(int size, int number) {
    	  int flag=0;
    	  for(int i=1;i<size+1;i++) {
    		  if(number%i==0&&number/i<=size) {
    			  flag+=1;
    		  }
    	  }
        System.out.println(flag);
    	  
      }
}
