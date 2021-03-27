package stringPbs;

import java.io.BufferedInputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ZeroEqulasOne {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Scanner sc=new Scanner(new BufferedInputStream(System.in));
        String st=sc.next();
        judge(st);
        sc.close();
	}
   public static void judge(String st) {
	   char[] sts=st.toCharArray();
	   Map<Integer, Integer> mp=new HashMap<Integer, Integer>();
	   int sum=0;
	   int ans=0;
	   for(int i=0;i<sts.length;i++) {
		   if(sts[i]=='1') {
			   sum+=-1;
		   }else {
			   sum+=1;
		   }
		   if(mp.containsKey(sum)) {
			   ans=Math.max(ans, i-(Integer)mp.get(sum));
		   }else {
			   mp.put(sum, i);
		   }
		   
	   }
	   System.out.println(ans);
	   
	   
   }
}
