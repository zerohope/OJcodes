 package stringPbs;

import java.io.BufferedInputStream;
import java.util.Scanner;

public class PrintSt {

	public static void main(String[] args) {
    Scanner sc=new Scanner(new BufferedInputStream(System.in));
	int tms=sc.nextInt();
	int[] ends=new int[tms];
	for(int i=0;i<tms;i++) {
		String flag=sc.next();
		String cs=sc.next();
		ends[i]=calSt(cs,flag);
	}
		for(int i=0;i<tms;i++) {
			System.out.println(ends[i]);
		}
		
	}
	
	
	public static int calSt(String cs, String flag) {
		int count=0;
		for(int i=0;i<cs.length();i++) {
			Character c=cs.charAt(i);
			if(c.toString().equals(flag)) {
				count++;
			}
			
		}
		return count;
		
		
	}

}
