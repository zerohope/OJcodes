package mathPbs;

import java.io.BufferedInputStream;
import java.util.Scanner;

public class BinaryNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
         Scanner sc=new Scanner(new BufferedInputStream(System.in));
         int tms=sc.nextInt();
         for(int i=0;i<tms;i++) {
        	 coverBinary(sc.nextLong());
         }
         sc.close();
         
	}
	
	//大数转二进制
	public static void coverBinary(long number) {
		//直接调用自带方法
	//	String nb=Long.toBinaryString(number);
		//简单运算
		String nb="";
		while(number>0) {
			nb=number%2+nb;
			number=number/2;
		}
		System.out.println(nb);
	}
	
	

}
