package mathPbs;

import java.io.BufferedInputStream;
import java.util.Arrays;
import java.util.Scanner;

public class flyChange {

	public static void main(String[] args) {
		Scanner sc=new Scanner(new BufferedInputStream(System.in));
		int loop=sc.nextInt();
		while(loop>0) {
			int length=(int)Math.pow(2, sc.nextInt());
			int[] arr=new int[length];
			for(int i=0;i<arr.length;i++)
				arr[i]=sc.nextInt();
		    	arr=changeArray(arr);
		    	
		    for(int i=0;i<arr.length;i++)
				System.out.print(arr[i]+" ");	
		    	
			loop--;
		}

	}
	
    public static int[] changeArray(int[] a) {
    	if(a.length<=2) {
    	  return a;
    	}else {
    		int[] b=new int[a.length/2];
    		int[] c=new int[a.length/2];
    		for(int i=0;i<a.length;i++) {
    			if(i%2==0) {
    			 b[i/2]=a[i];
    			}else {
    			 c[i/2]=a[i];
    			}
    		}
    		int[] end=Arrays.copyOf(changeArray(b), b.length+c.length);
    		System.arraycopy(changeArray(c), 0, end, b.length, c.length);
    		return end;
    		}
    		
    	}
    	
    	
    
}
