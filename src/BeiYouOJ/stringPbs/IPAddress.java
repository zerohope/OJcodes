package stringPbs;

import java.io.BufferedInputStream;
import java.util.Scanner;

public class IPAddress {

	public static void main(String[] args) {
		Scanner sc=new Scanner(new BufferedInputStream(System.in));
		int tms=sc.nextInt();
		sc.nextLine();
		for(int i=0;i<tms;i++) {
			checkIp(sc.nextLine());
		}
       sc.close();
	}
	
	//Ê¹ÓÃtry-catchÀ´ÅÅ³ý´íÎó
   public static int checkIp(String st) {
	   String[] ips=st.split("\\.");
       int ip=-1;
	   if(ips.length!=4) {
		   System.out.println("No");
		   return 0;
	   }
	   int[] check=new int[4];
	   for(int i=0;i<4;i++) {
		   try {
		 ip=Integer.valueOf(ips[i]);	
		} catch (Exception e) {
			 System.out.println("No");
			return 0;
		}
		   if(ip<=255&&ip>=0) {
			  check[i]=1;
		   }
	   }	   
	   for(int i=0;i<4;i++) {
		   if(check[i]==0) {
			   System.out.println("No");
			   return 0;
		   } 
	   }
	   System.out.println("Yes");
	   return 0;  
   }	
	
	

}
