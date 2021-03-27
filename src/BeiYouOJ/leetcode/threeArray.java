package leetcode;

public class threeArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	  System.out.println(canThreePartsEqualSum(new int[] {3,3,6,5,-2,2,5,1,-9,4}));
	}
	
    public static boolean canThreePartsEqualSum(int[] A) {
         int sum=0;
    	for(int i:A) {
    	 sum+=i;
       }
    	if(sum%3==0) {
    		int flag=sum/3;
    		sum=0;
    		int time=0;
    		for(int i:A) {
    	    	 sum+=i;
    	 		if(sum==flag) {	
    				sum=0;
    				time++;
    			}
    	       }	
    		if(time==3) {
    			return true;
    		}
    		
     
    	
    	}
		return false;	
    }
    }
