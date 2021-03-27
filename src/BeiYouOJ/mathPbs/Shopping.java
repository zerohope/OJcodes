package mathPbs;

import java.io.BufferedInputStream;
import java.text.DecimalFormat;
import java.util.Scanner;

public class Shopping {

	public static void main(String[] args) {
		Scanner sc=new Scanner(new BufferedInputStream(System.in));
		int tms=sc.nextInt();
		while(tms>0) {
			int count=sc.nextInt();
			DecimalFormat df=new DecimalFormat("#0.00");
			double price=0;
			while(count>0) {
				price+=getCount(sc.nextDouble(),sc.nextInt());
			 count--;	
			}
			System.out.println(df.format(price));
			tms--;
		}
	}
   public static double getCount(double price, int amount) {
	    double total=0;
	   total=price*amount;
	   return total;
   }
}
