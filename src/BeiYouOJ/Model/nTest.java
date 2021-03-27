package Model;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.TreeMap;
import java.util.Map.Entry;

public class nTest {
	public static void main(String[] args) {
		
     Map<Integer,Integer> mp=new TreeMap<Integer, Integer>(
    		 new Comparator<Integer>() {
    			 public int compare(Integer o1, Integer o2) {
    				 return o1-o2;
    				 
    				 
    			 };
			}); 
		List<Map.Entry<Integer, Integer>> list=new ArrayList(mp.entrySet());
	    Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>(
	    	) {	@Override
					public int compare(Entry<Integer, Integer> o1, Entry<Integer, Integer> o2) {
						// TODO Auto-generated method stub
						return 0;
					}
				}) ;
		System.out.println(fastPower(2,5));
	}
           public static int fastPower(int a, int b) {
        	   int ans=1;
        	   int base=a;
        	   while(b!=0) {
        		   if((b&1)!=0) {
        			   ans*=base;
        		   }
        		   base*=base;
        		  b>>=1; 
        	   }
        	   return ans;
           }
           
           public static void arcsin() {
        	  System.out.println( Math.sin(Math.PI/2));
           }
}
