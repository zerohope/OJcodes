package leetcode;

public class smallestRepunitDivByK {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(test(23));
	}
        public static int test(int K) {
        	if(K%2==0||K%5==0) {
        		return -1;
        	}
        	int end=0;
        	for(long i=1;i<Long.MAX_VALUE;i=i*10+1) {
        		if(i%K==0) {
        		   while(i%10!=0) {
        			  end++; 
        			  i=i/10;
        		   }
        		   return end;
        		}
        	
        	}
        	
        	return -1;
        }
}
