package leetcode;

public class MusicTime {

	public static void main(String[] args) {
		
		numPairsDivisibleBy60(new int[] {60,60,60});

	}
	
	 public static int numPairsDivisibleBy60(int[] time) {
	        int end=0;
		 for(int i=0;i<time.length-1;i++)
		    for(int j=i+1;j<time.length;j++)
		        if((time[i]+time[j])%60==0) {
		        	end++;
		        }
		 System.out.println(end);
		 return end;
	    }

}
