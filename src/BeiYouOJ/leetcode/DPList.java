package leetcode;



public class DPList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DPList(new int[] {1,5,3,4,6,9,7,8});
	}
	
	
	
    public static void DPList(int[] ls) {
    	int[] f=new int[ls.length];
    	  f[0]=1;
      for(int i=1;i<ls.length;i++) {
    	  int temp=0; 
    	  for(int j=0;j<i;j++) {
    		if(ls[j]<ls[i]&&temp<f[j]+1) 
    			temp=f[j]+1;
    	  }
    	  f[i]=temp;
    	  System.out.print(f[i]+" ");
      }
    }
    
	public static void Update(int[] ls) {
		int[] f=new int[ls.length];
		for(int i=0;i<f.length;i++) {
			f[i]=Integer.MAX_VALUE;
		}
		
		f[0]=ls[0];
		int flag=1;
		for(int i=1;i<ls.length;i++) {
			if(ls[i]>f[flag]) {
			  f[++flag]=ls[i]; 
			}
			if(ls[i]<f[flag]) {
				f[flag]=ls[i];
			}
		}

	}
	
	
	
}
