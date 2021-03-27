package stringPbs;

import java.io.BufferedInputStream;
import java.util.Scanner;
//卡住的原因，没有想到会出现重复的需要替换的地方
public class OperateStrings {
 
	public static void main(String[] args) {
		int a=0;
		Scanner sc=new Scanner(new BufferedInputStream(System.in));
		while(sc.hasNextLine()) {
			String st=sc.nextLine();
			int opt=sc.nextInt();
			String[] ends=new String[opt];
			for(int i=0;i<opt;i++) {
				a=sc.nextInt();
				if(a==0) {
					st=reverseSt(sc.nextInt(),sc.nextInt(),st);
					ends[i]=st;
					
				}else {
					st=changeSt(sc.nextInt(),sc.nextInt(),st,sc.nextLine());
					ends[i]=st;
				}
			}
			for(int i=0;i<opt;i++) {
				System.out.println(ends[i]);
			}
			if(a==0)
				sc.nextLine();
		}	
	}
	
	public static String reverseSt(int start, int end, String st) {
		String temp=st.substring(start, start+end);
		String flag=" ";
		for(int i=0;i<temp.length();i++)
		flag+=temp.charAt(temp.length()-i-1);
         
		return changeSt(start, end, st, flag);
	}
    public static String changeSt(int start, int end, String st, String cst) {
    	StringBuilder sb=new StringBuilder(st);
    	cst=cst.substring(1);
		sb.replace(start, start+end, cst);
		return sb.toString();
	}
	
	
}
