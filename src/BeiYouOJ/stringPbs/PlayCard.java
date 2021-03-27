package stringPbs;

import java.io.BufferedInputStream;
import java.util.Scanner;

public class PlayCard {

	public static void main(String[] args) {
		Scanner sc=new Scanner(new BufferedInputStream(System.in));
          String mcd=sc.next();
          String cd =sc.next();
          Judge(mcd,cd);
	}
	
	public static void Judge(String mcd, String tcd) {
		if(tcd.length()>mcd.length()) {
			System.out.println("NO");
			return ;
		}
		if(tcd.length()<5) {
			int[] my=new int[mcd.length()];
			int t=Integer.valueOf(String.valueOf(tcd.charAt(0)));
			for(int i=0;i<mcd.length();i++)
			 my[i]=Integer.valueOf(String.valueOf(mcd.charAt(i)));
			if(tcd.length()==1) {
			for(int i=0;i<mcd.length();i++) {
				if(my[i]>t) {
					System.out.println("YES");
					return ;
				}
					
			}
				System.out.println("NO");
				
			}else {
		  	int flag=1;
			for(int i=1;i<mcd.length();i++) {
				if(flag==tcd.length()) {
					System.out.println("YES");
					return ;
				}
				if(my[i]>t&&my[i]==my[i-1]) {
					flag+=1;
				}else {
					flag=1;
				}
				
			}
			if(flag==tcd.length()) {
				System.out.println("YES");
				return ;
			}
			System.out.println("NO");
			return ;
			}
		}
     for(int i=1;i<mcd.length();i++) {
    	 if(mcd.charAt(i)==mcd.charAt(i-1)) {
    		 mcd=mcd.substring(0, i)+mcd.substring(i+1);
              i=i-1;                
    	 }	 
     }

		int flag=0;
		String[] c=new String[] {"12345","23456","34567","45678","56789"};
		for(int i=0;i<c.length;i++) {
			if(c[i].equals(tcd)) {
				flag=i+1;
				break;
			}
		}
		
		for(;flag<c.length;flag++) {
			if(mcd.contains(c[flag])) {
				System.out.println("YES");
				return ;
			}
		}
		System.out.println("NO");
	}
	

}
