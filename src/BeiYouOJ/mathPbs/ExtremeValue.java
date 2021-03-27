package mathPbs;

import java.io.BufferedInputStream;
import java.util.Arrays;
import java.util.Scanner;

public class ExtremeValue {

	public static void main(String[] args) {
		Scanner sc=new Scanner(new BufferedInputStream(System.in));
        int loop=sc.nextInt(); 
       while(loop>0) {
    	   int[] arr=new int[sc.nextInt()];
    	   for(int i=0;i<arr.length;i++)
        	  arr[i]=sc.nextInt();
    	   
    	   getNumber(arr);
        	loop--;
        }
       sc.close();
	}
    public static void getNumber(int[] arr) {
    	Arrays.sort(arr);
    	int a=arr[arr.length-1];
    	int flag=0;
    	for(int i=arr.length-2;i>0;i--) {
    		if(arr[i]!=a) {
    			flag=i;
    			break;
    		}
    	}
    	System.out.println(a+" "+arr[flag]);
    }
}
