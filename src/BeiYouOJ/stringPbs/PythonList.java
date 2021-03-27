package stringPbs;

import java.io.BufferedInputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class PythonList {

	public static void main(String[] args) {
		Scanner sc=new Scanner(new BufferedInputStream(System.in));
		Map<String, List<Integer>> mp=new HashMap<String, List<Integer>>();
		int tms=sc.nextInt();
		while(tms>0) {
		 int time=sc.nextInt();
		 while(time>0) {
			 opList(mp,sc.next()); 
			 time--;
		 }
			tms--;
		}
          sc.close();
	}
	
     public static void opList(Map<String, List<Integer>> mp, String st) {
    	 if(st.contains("=[]")) {
    		 String[] nm=st.split("\\=");
    		 mp.put(nm[0], new ArrayList<Integer>());
    	 }
    	 else if(st.contains("append")) {
    		 st=st.replace(".append(","=");
    		 String[] vl=st.split("\\=");
    		 String value=vl[1].substring(0,vl[1].length()-1);
    		 int val=Integer.parseInt(value);
    		 mp.get(vl[0]).add(val);
    		 
    	 }
    	 else if(st.contains(".sort")) {
    		 st=st.replace(".sort()","");
    		 Collections.sort(mp.get(st));
    	 }
    	 else {
    		 String[] vl=st.split("\\[");
    		 String value=vl[1].substring(0,vl[1].length()-1);
    		 int val=Integer.parseInt(value);
    		 if(val<=mp.get(vl[0]).size()-1) {
    			 System.out.println(mp.get(vl[0]).get(val));
    		 }else {
    			 System.out.println("ERROR");
    		 }
    	 } 
     }
}
