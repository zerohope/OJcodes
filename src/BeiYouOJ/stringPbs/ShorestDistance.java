package stringPbs;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class ShorestDistance {
    private static Map<Character,List<Integer>> mp;
	public static void main(String[] args) throws IOException {
		Scanner sc=new Scanner(new BufferedInputStream(System.in));
		mp=new HashMap<Character, List<Integer>>();
		int tms=sc.nextInt();
		List<Integer> end=new ArrayList<Integer>();
		String st="";
		for(int i=0;i<tms;i++){
		st=sc.next();
		for(int j=0;j<st.length();j++) {
		if(mp.containsKey(st.charAt(j))) {
			mp.get(st.charAt(j)).add(j);
		}
		else {
			List<Integer> a=new ArrayList<Integer>();
			a.add(j);
			mp.put(st.charAt(j),a);
		}	
		}
			int tm=sc.nextInt();
			while(tm>0) {
				if(sc.next().contains("I")) {
					st+=sc.next();
					int len=st.length()-1;
					if(mp.containsKey(st.charAt(len))) 
						mp.get(st.charAt(len)).add(len);					           	
					
					else {
						List<Integer> a=new ArrayList<Integer>();
						a.add(len);
						mp.put(st.charAt(len),a);
					}	
					}		
				else {
					end.add(searchShorest(st,sc.nextInt()));
				}	
				tm--;
			}
			mp.clear();
		}
		sc.close();
		for(int i=0;i<end.size();i++)
	          System.out.println(end.get(i));
	}
	
	public static int searchShorest(String st,int num) {
		int temp=100001;
		char tq=st.charAt(num);
	   List<Integer> list=mp.get(tq);
		for(int i=0;i<list.size();i++) {
			if(list.get(i)!=num&&temp>Math.abs(num-list.get(i))) {
					temp=Math.abs(num-list.get(i));
			}
		}
		if(temp!=100001)
			return temp;
		
		return -1;
	}
}


 