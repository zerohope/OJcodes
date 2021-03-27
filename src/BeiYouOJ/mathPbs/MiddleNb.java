package mathPbs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;

public class MiddleNb {

public static void main(String[] args) throws IOException {
	int[] nbs;
	BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
	int tm=Integer.parseInt(sc.readLine());
	String[] ends=new String[tm];
	for(int i=0;i<tm;i++) {
	nbs=new int[Integer.parseInt(sc.readLine())];
	String[] temp=sc.readLine().split(" ");
	for(int j=0;j<nbs.length;j++) {
		nbs[j]=Integer.parseInt(temp[j]);
	};
	ends[i]=findnb(nbs);	
	}

	for(int i=0;i<ends.length;i++)
	  System.out.println(ends[i]);
	
}	

    //格式化输出小数点
	public static String findnb(int[] a) {
		if(a.length%2!=0) {
			return new DecimalFormat("0").format(a[a.length/2]);
		}else {
		     double flag=((double)a[a.length/2-1]+(double)a[a.length/2])/2;
		 
		     if(flag-(int)flag!=0) {
		    	 return new DecimalFormat("0.0").format(flag);
		     }
			return new DecimalFormat("0").format(flag);
		}
	}
	
}
