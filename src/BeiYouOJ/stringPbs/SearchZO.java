package stringPbs;

import java.io.BufferedInputStream;
import java.util.Scanner;

public class SearchZO {

	public static void main(String[] args) {
		Scanner sc=new Scanner(new BufferedInputStream(System.in));
		int tms=sc.nextInt();
		while(tms>0) {
			String st=sc.next();
			searchZero(st);
			
		
			tms--;
		}
     sc.close();
	}
	
	
	public static void searchZero(String st) {
		int flag=0;
		for(int i=0;i<st.length();i++) {
			char sv=st.charAt(i);
			if(flag==5) {
			 String temp=st.substring(i+1);
			 st=st.substring(0, i)+temp;
			 flag=0;
			}
			if(sv=='1') {
				flag+=1;
			}
			
		}
		System.out.println(st);
		
		
		
	}

}
