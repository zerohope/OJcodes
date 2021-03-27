package Model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public class UseMap {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    public static void showMp(Map<Integer,Integer> mp ) {
    	for(Map.Entry<Integer,Integer> entry:mp.entrySet()) {
    		
    	}
    }
    public static void sortMapByKey() {
    	Map<Integer,Integer> mp=new TreeMap<Integer, Integer>(
    			new Comparator<Integer>() {
    				public int compare(Integer o1, Integer o2) {
    					
    					return o1-o2;
    				};
				});

    }
   public static void sortMapByValue() {
	   Map<Integer,Integer> mp=new TreeMap<Integer, Integer>();
	 List<Map.Entry<Integer, Integer>> list=new ArrayList<Map.Entry<Integer, Integer>>(mp.entrySet());
	   Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {

		@Override
		public int compare(Entry<Integer, Integer> o1, Entry<Integer, Integer> o2) {
			
			return o1.getValue()-o2.getValue();
		};
		
	});
    for(Map.Entry<Integer, Integer> entry: list) {
    	
    }	
	   
	   
   }    
    
}
