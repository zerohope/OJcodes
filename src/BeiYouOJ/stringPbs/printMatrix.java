package stringPbs;

import java.io.BufferedInputStream;
import java.util.Scanner;

public class printMatrix {

	public static void main(String[] args) {
		Scanner sc=new Scanner(new BufferedInputStream(System.in));
		int loop=sc.nextInt();
		while(loop>0) {
			printM(sc.nextInt(),sc.nextInt());
			loop--;
		}

	}
    public static void printM(int x, int y) {
    	for(int i=0;i<x;i++) {
    	  for(int j=0;j<y;j++) {
    		  if(i==0||i==x-1||j==0||j==y-1)
    			  System.out.print("#");
    		  else {
    			  System.out.print("*");
    		  }
    	  }
    	System.out.println();
    	}
    	
    }
}
