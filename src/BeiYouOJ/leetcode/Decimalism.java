package leetcode;

public class Decimalism {

	public static void main(String[] args) {
		
		test(10);
	}

	
	public static void test(int n) {
		int rs=0;
		String nb=Integer.toBinaryString(n);
	    int[] nbs=new int[nb.length()];
	    for(int i=0;i<nbs.length;i++) {
	    	nbs[i]=Integer.parseInt(String.valueOf(nb.charAt(i)));
	        if(nbs[i]==0) {
	        	nbs[i]=1;
	        }else {
	        	nbs[i]=0;
	        }
	      
	        rs+=nbs[i]*Math.pow(2, nbs.length-i-1);
	    }
	  System.out.println(rs);
	}
}
