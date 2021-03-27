package stringPbs;

import java.io.BufferedInputStream;
import java.util.Scanner;

public class TimeLimits {

	public static void main(String[] args) {
		Scanner sc=new Scanner(new BufferedInputStream(System.in));
		int tms=sc.nextInt();
		int ends[]=new int[tms];
		for(int i=0;i<tms;i++) {
			ends[i]=calculateTime(sc.next(), sc.next());		   
		}
		for(int i=0;i<tms;i++)
		  System.out.println(ends[i]);
	}

	public static int calculateTime(String start, String end) {
		int[] st=new int[] {Integer.parseInt(start.split(":")[0]),Integer.parseInt(start.split(":")[1])};
		int[] ed=new int[] {Integer.parseInt(end.split(":")[0]),Integer.parseInt(end.split(":")[1])};
		if(st[0]>ed[0]||st[0]==ed[0]&&ed[1]-st[1]<0) {
	      	return 1440-calut(ed,st);	
			
		}else {
			return calut(st,ed);
					
		}
		
	}
	public static int calut(int[] st, int[]ed) {
		
		if(ed[1]-st[1]<0) {
			return (ed[0]-st[0]-1)*60+60+(ed[1]-st[1]);
		}else {
			return (ed[0]-st[0])*60+(ed[1]-st[1]);
		}
		
		
	}
	
}
