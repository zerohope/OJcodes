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
	
	//����ת������
	public static void coverBinary(long number) {
		//ֱ�ӵ����Դ�����
	//	String nb=Long.toBinaryString(number);
		//������
		String nb="";
		while(number>0) {
			nb=number%2+nb;
			number=number/2;
		}
		System.out.println(nb);
	}
	
	

}
