package mathPbs;

import java.io.BufferedInputStream;
import java.util.Scanner;

public class printNb {
    public static String[]  pt=new String[] {"111","101","001","100"};
	public static void main(String[] args) {
		Scanner sc=new Scanner(new BufferedInputStream(System.in));
		String nb=sc.next();
			printNumber(nb);
		sc.close();
		

	}
	public static void printNumber(String nb) {
		String end="";
		int[] nbs=new int[nb.length()];
		for(int i=0;i<nb.length();i++) {
			nbs[i]=Integer.parseInt(String.valueOf(nb.charAt(i)));
		}
		for(int i=0;i<5;i++) {
			for(int j=0;j<nbs.length;j++) {
				end=detailNb(i,nbs[j],end);
			}
		  end+="\n";	
		}
		System.out.println(end);
			
			
			
		}
		
   public static String detailNb(int i,int nb, String end) {
		  switch (i) {
		  case 0:
			if(nb==1) {
				end+=pt[2];
			}else if(nb==4)
			    end+=pt[1];
			else
			    end+=pt[0];
			
			break;
		  case 1:
			if(nb==5||nb==6)  
			  end+=pt[3];
			else if(nb==1||nb==2||nb==3||nb==7) 
		   	  end+=pt[2];
			else end+=pt[1];
				break;
		  case 2:
			if(nb==0)
			 end+=pt[1];
		   else if(nb==1||nb==7)
		 	  end+=pt[2];
		   else 
			  end+=pt[0];
				break;
		  case 3:
			if(nb==0||nb==6||nb==8)
				end+=pt[1];
			else if(nb==2)
				end+=pt[3];
			else 
				end+=pt[2];
				break;
		  case 4:
			 if(nb==1||nb==4||nb==7)
				 end+=pt[2];
			 else
				 end+=pt[0];
				break;
		default:
			break;
		}	
			return end;
		}
		
		
		
		
	}
	
	


