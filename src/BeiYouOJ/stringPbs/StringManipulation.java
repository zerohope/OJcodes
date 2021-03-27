package stringPbs;

import java.io.BufferedInputStream;
import java.util.Scanner;

public class StringManipulation {

	public static void main(String[] args) {
		Scanner sc=new Scanner(new BufferedInputStream(System.in));
         String st=sc.next();
         String cp="";
         int tms=sc.nextInt();
         while(tms>0) {
        String od=sc.next();
        if(od.contains("CO")) {
        	cp=Manipulation(st,1,sc.nextInt(),sc.nextInt());
        }
        if(od.contains("CU")) {
        	int a=sc.nextInt();
        	int b=sc.nextInt();
        	cp=Manipulation(st,1,a,b);
        	st=Manipulation(st,2,a,b);
        	
        }
        if(od.contains("PA")) {
        	st=Manipulation(st,cp,sc.nextInt());
        	
        }	 
        System.out.println(st);
        System.out.println(cp);
        	 tms--;
         }
         
	}
   public static String Manipulation(String st, int flag, int s, int e) {
	   String tp="";
	   switch (flag) {
	   case 1:
		tp=st.substring(s, e+1);
		  break;
	   case 2:
		tp=st.substring(0, s)+st.substring(e+1);
	     break;	  
	  default:
		break;
	}
	   return tp;
	   
   } 
   
   public static String Manipulation(String st, String cp,int s) {
	   String tp="";
	   tp=st.substring(0,s+1)+cp+st.substring(s+1);

	   return tp;
   } 
}
