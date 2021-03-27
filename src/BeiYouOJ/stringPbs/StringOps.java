package stringPbs;

import java.io.BufferedInputStream;
import java.util.Arrays;
import java.util.Scanner;

public class StringOps {

	public static void main(String[] args) {
		Scanner sc=new Scanner(new BufferedInputStream(System.in));
		int[] nbs=new int[sc.nextInt()+1];
		nbs[0]=-1;
		int tms=sc.nextInt();
		for(int i=1;i<nbs.length;i++)
			nbs[i]=sc.nextInt();
		sc.nextLine();
		while(tms>0) {
			Options(nbs,sc.nextLine());
			tms--;
		}
	}
	
	public static void Options(int[] nbs, String ops) {
		 String[] dt=ops.split(" ");
		  String order=dt[0];
		 int st=Integer.parseInt(dt[1]);
		 int end=Integer.parseInt(dt[2]);  
		switch (order) {
	   	case "1":
	   	while(end-st>=1) {
	   	   int temp=nbs[st];
	   	   nbs[st]=nbs[end];
	   	   nbs[end]=temp;
	   	   st+=1;
	   	   end-=1;
	   	}
			
			break;
			
         case "2":
			int len=Integer.parseInt(dt[3]);  
        	 while(len>0) {
        	   int temp=nbs[st];
      	   	   nbs[st]=nbs[end];
      	   	   nbs[end]=temp;
        		 st+=1;
        		 end+=1;
        		 len--;
        	 }
        	 
			break;
			
         case "3":
        	 int x=Integer.parseInt(dt[3]);  
        	 for(int i=st;i<end+1;i++)
        		 nbs[i]=x;
 			break;
 			
         case "4":
        	int[] temps=new int[end-st+1];
        	 for(int i=0;i<temps.length;i++) {
        		 temps[i]=nbs[st];
        		 st+=1;
        	 }
 			Arrays.sort(temps);
        	 for(int i=0;i<temps.length;i++) {
        		 nbs[st]=temps[i];
        		 st+=1;
        	 }
 			break;		
         case "5":
        	 int temp=0;
 		 for(int i=st;i<end+1;i++)
        	 temp+=nbs[i];
        	 System.out.println(temp);
 			break;
		default:
			break;
		}
		
		
	}
	
	
	

}
