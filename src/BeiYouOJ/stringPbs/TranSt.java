package stringPbs;

import java.io.BufferedInputStream;
import java.util.Arrays;
import java.util.Scanner;

public class TranSt {
	public static void main(String[] args) {
		Scanner sc=new Scanner(new BufferedInputStream(System.in));
		int tms=sc.nextInt();
		int[] ends=new int[tms];
		for(int i=0;i<tms;i++) {
			String st=sc.next();
			ends[i]=handleSt(st);
		}
         for(int i=0;i<tms;i++)
		System.out.println(ends[i]);
	}
	public static int handleSt(String st) {
		int flag=0;
		int end=0;
		int[] a=new int[st.length()];
		for(int i=0;i<a.length;i++) {
			a[i]=(int)st.charAt(i)-(int)'a'+1;
			end+=a[i];
		}
		Arrays.sort(a);
		for(int i=0;i<a.length;i++) {
			for(int j=0;j<a.length;j++) {
				if(i>0&&a[i]==a[i-1]) {
					flag=end;
					continue;
				}
				if(Math.abs(a[j]-a[i])>26-Math.abs(a[j]-a[i])) {
					flag+=26-Math.abs(a[j]-a[i]);
				}else {
				flag+=Math.abs(a[j]-a[i]);
				}
			}
				if(end>flag) {
					end=flag;
				}
				flag=0;	
							}
	return end;		
		}
	
	}
	
	
	
	

