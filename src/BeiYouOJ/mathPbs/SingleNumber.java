package mathPbs;

import java.io.BufferedInputStream;
import java.util.Arrays;
import java.util.Scanner;

public class SingleNumber {

	public static void main(String[] args) {
		Scanner sc=new Scanner(new BufferedInputStream(System.in));
		while(sc.hasNext()) {
			int length=sc.nextInt();
			long[] arr =new long[length];
			for(int i=0;i<arr.length;i++)
				arr[i]=sc.nextLong();
			findNb(arr);
		}
        sc.close();
	}
    public static void findNb(long[] arr) {
    	Arrays.sort(arr);
    	if(arr[arr.length-1]!=arr[arr.length-2]) {
    		System.out.println(arr[arr.length-1]);
    		return;
    	}
    	int flag=0;
    	for(int i=0;i<arr.length-1;i++) {
    		if(arr[i]==arr[i+1]) {
    			flag+=1;
    		}else {
    			if(flag>0) {
    				flag=0;
    			}else {
    				System.out.println(arr[i]);
    				break;
    			}
    		}
    	}
    	
    	
    }
}
