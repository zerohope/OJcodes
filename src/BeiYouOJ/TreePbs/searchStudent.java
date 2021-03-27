package TreePbs;

import java.io.BufferedInputStream;
import java.util.Scanner;

public class searchStudent {

	public static void main(String[] args) {
		Scanner sc=new Scanner(new BufferedInputStream(System.in));
		while(sc.hasNext()) {
			int arr[]=new int[sc.nextInt()];
			for(int i=1;i<arr.length;i++)
				 arr[i]=sc.nextInt();
			 search(arr);
		}
         sc.close();
	}
	
	
	
  public static void search(int[] arr) {
	   int sum=arr.length;
      for(int i=1;i<arr.length;++i){
          sum^=arr[i];
          sum^=i;
  }
	System.out.println(sum);  
  }
}
