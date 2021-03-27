package mathPbs;
import java.util.Scanner;
public class ModeNumbers {

	public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);  
         int[] ends=new int[sc.nextInt()];
      for(int i=0;i<ends.length;i++) {
        int[] nbs = new int[sc.nextInt()];
         for (int j = 0; j < nbs.length; j++) {
              nbs[j]=sc.nextInt();
          }
        ends[i]=Judge(nbs);
      }

    for (int i=0;i<ends.length;i++)
    System.out.println(ends[i]);
	}
	
public static int Judge(int[] numbs){
		if(numbs.length==1) {
			  return numbs[0];
		  }
	   int count=1,mode=0,sum=0;
	   for(int i=0;i<numbs.length-1;i++){		
	    if(numbs[i]==numbs[i+1]){
	       count++;
	    }else {
	    	count=1;
	    	}
	    if(count>sum) {
	        mode=numbs[i];
	        sum=count;
	    }	

	   }
	   return mode;
	  }
	  
}
