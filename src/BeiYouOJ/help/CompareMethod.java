package help;

import java.util.Arrays;

public class CompareMethod {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        CTest[] c=new CTest[3];
        for(int i=0;i<3;i++)
		 c[i]=new CTest(i);
		Arrays.sort(c);
        
		 for(int i=0;i<3;i++)
			System.out.println(c[i].a);
		
	}

}



class CTest implements Comparable<CTest>{
	int a;
    public CTest(int a) {
    	this.a=a;
    }
	@Override
	public int compareTo(CTest o) {
		int i=this.a-o.a;
		return i;
	}
	
	
	
}