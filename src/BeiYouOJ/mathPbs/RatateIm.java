package mathPbs;

import java.io.BufferedInputStream;
import java.util.Scanner;

public class RatateIm {

	public static void main(String[] args) {
		Scanner sc=new Scanner(new BufferedInputStream(System.in));
		int[][] image;
		int[][][] ends;
		int tms=sc.nextInt();
		ends=new int[tms][][];
		for(int i=0;i<tms;i++) {
			int width=sc.nextInt();
			int lon=sc.nextInt();
			image=new int[width][lon];
			for(int j=0;j<width;j++) {
				  String a=sc.next();
			  for(int k=0;k<lon;k++) {
				  Character nb=a.charAt(k);
			   image[j][k]=Integer.parseInt(nb.toString());
			  }
			}
		  int time=sc.nextInt();
			while(time-90>=0) {
			 image=Reverse(image);
			 time=time-90;
			}
			ends[i]=image;
	
		}
		for(int i=0;i<tms;i++)
		   for(int j=0;j<ends[i].length;j++) {
		    for(int k=0;k<ends[i][j].length;k++) {
		      System.out.print(ends[i][j][k]);}
		    	System.out.println("");}
		
	}
	public static int[][] Reverse(int[][] image){
		int width=image.length;
		int lon=image[0].length;
		int[][] nig=new int[lon][width];
		for(int i=0;i<lon;i++)
		  for(int j=0;j<width;j++) {
		   nig[i][j]=image[width-j-1][i];
		  }
		
		
		return nig;
		
	}
	
	
}
