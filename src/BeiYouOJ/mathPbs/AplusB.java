package mathPbs;

import java.io.BufferedInputStream;
import java.math.BigInteger;
import java.util.Scanner;

public class AplusB {
	
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int t = scanner.nextInt();
		while(t>0){
			BigInteger a = scanner.nextBigInteger();
			BigInteger b = scanner.nextBigInteger();
			System.out.println(a.add(b));
			t--;
		}
	}
	

}
