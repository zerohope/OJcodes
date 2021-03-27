package mathPbs;

import java.io.BufferedInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class NumberSystemConvert {

	public static void main(String[] args) {
		
		Scanner sc=new Scanner(new BufferedInputStream(System.in));
		int tms=sc.nextInt();
		long[] ends=new long[tms];
		for(int i=0;i<tms;i++) {
			long nb=sc.nextLong();
			
			ends[i]=convert(nb);
		}
		for (int i=0;i<tms;i++)
            System.out.println(ends[i]);
	}
	
   public static long convert(long nb) {
	   long end=0;
	   List<Long> a=new ArrayList<Long>();
	   while(nb>=2) {
		   a.add(nb%2);
		   nb=(nb-nb%2)/2;
	   }
	   a.add(nb);
	   for(int i=0;i<a.size();i++) {
		   end+=a.get(i)*Math.pow(2, a.size()-1-i);
	   }
	   return end;
   }
}
