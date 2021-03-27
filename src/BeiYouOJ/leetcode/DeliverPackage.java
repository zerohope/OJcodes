package leetcode;

public class DeliverPackage {

	public static void main(String[] args) {
		
		shipWithinDays(new int[] {1,2,3,1,1},3);
	}
	
	 public static int shipWithinDays(int[] weights, int D) {
	       int ans=Integer.MAX_VALUE;
	       int sum=0;
	       for(int num:weights)
	          sum+=num;	       
	       int low=0;
	       for(int num:weights) {
	    	   if(num>low)
	    		   low=num;   
	       }
	       int high=sum;
	       
	       while(low<=high) {
	    	
	    	int mid=low+(high-low)/2;   
	    	int day=getDay(weights,mid);   
	    	if(day>D) {
	    		low=mid+1;
	    	}else if(day<=D) {
	    		ans=Math.min(ans, mid);
	    		high=mid-1;
	    	}	
	       }
	       System.out.println(ans);
		return ans;
	   }
	 
	 public static int getDay(int[] weights, int w) {
		 int day=1;
		 int count=0;
		  for(int i=0;i<weights.length;i++) {
			  if(count+weights[i]<=w){
	              count+=weights[i];
	           }
			  else {
				  day++;
				  count=weights[i];
			  }
		  }
		 return day;
	 }
	 
	 
}
