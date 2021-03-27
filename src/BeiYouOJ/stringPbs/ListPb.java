package stringPbs;

import java.io.BufferedInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ListPb {

	public static void main(String[] args) {
	Scanner sc=new Scanner(new BufferedInputStream(System.in));
     int tms=sc.nextInt();
     List<Integer> ends=new ArrayList<Integer>();
     for(int i=0;i<tms;i++) {
    	 int size=sc.nextInt();
       List<Integer> list=new ArrayList<Integer>();
    	 while(size>0) {
    		 options(sc.nextLine(),list,ends);
    		 size--;
    	 }
     }
     System.out.println("");
     for(int i=0;i<ends.size();i++) 
    	 System.out.println(ends.get(i));
     
	}
	public static void options(String op,List<Integer> list, List<Integer> end) {
		if(op.contains("append")) {
			list.add(Integer.parseInt(op.split(" ")[1]));
		}
		if(op.contains("pop")) {
			list.remove(list.size()-1);
		}
		if(op.contains("find")) {
			int a=Integer.parseInt(op.split(" ")[1]);
			if(a>0) 
			end.add(list.get(a-1));
			else {
				end.add(list.get(list.size()-1));
			}
				
		}
		
	}

}
