package leetcode;

public class DPMoney {

	public static void main(String[] args) {
	
		cMy(15);

	}
	//我从哪里来
	public static int calculateMy(int m) {
          if(m==1||m==0) {
        	  return m;
          }else {
        if(m>=11) {
        return 	Math.min(Math.min(calculateMy(m-11),calculateMy(m-5)),calculateMy(m-1))+1;
        }	  
        if(m>=5) {
            return 	Math.min(calculateMy(m-5),calculateMy(m-1))+1;
        }		  
        	  return calculateMy(m-1)+1;
      }
	}
	
	//我到哪里去
	public static void cMy(int m) {
	    int[] f=new int[16];
	    f[0]=0;
	    for(int i=1;i<16;i++) {
	    	f[i]=Integer.MAX_VALUE;
	    }
	    for(int i=0;i<15;i++) {
	    	if(f[i]+1<f[i+1]) 
	    	f[i+1]=f[i]+1;

	    	if(i+5<=15&&f[i]+1<=f[i+5]) {
	    	f[i+5]=f[i]+1;
	    	}
	    	if(i+11<=15&&f[i]+1<=f[i+11])
	    	f[i+11]=f[i]+1;
	    	
	    }
		
	    for(int i=1;i<16;i++) {
	    	System.out.print(f[i]+"---");
	    }
		
		
		
		
		
	}
	
	
	

}
