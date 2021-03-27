package mathPbs;

import java.io.BufferedInputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class PluralCollection  {

	public static void main(String[] args) {
		Scanner sc=new Scanner(new BufferedInputStream(System.in));
		int tms=sc.nextInt();
		sc.nextLine();
		List<Plural> pas=new ArrayList<Plural>();
		for(int i=0;i<tms;i++) {
			option(sc.nextLine(), pas);
		}
		sc.close();
		
	}
   public static void option(String od, List<Plural> p) {
	    String[] ods=od.split(" ");
	   if(ods[0].contains("P")) {
		   Collections.sort(p);
		   if(p.size()>0) {
		   Plural pl=p.get(p.size()-1);
		   System.out.println(pl.partA+"+i"+pl.partB);
		   p.remove(p.size()-1);
		   System.out.println("SIZE = "+p.size());
		   }else {
			   System.out.println("empty");
		   }
	   }else {
		   	String[] plu=ods[1].split("\\+i");
		   	int pa=Integer.parseInt(plu[0]);
		   	int pb=Integer.parseInt(plu[1]);
		   	Plural newp=new Plural(pa,pb);
		     p.add(newp);
		   System.out.println("SIZE = "+p.size());
	   }
	   
	   
	   
   }


}

//CompareTo方法实现自定义类型比较
// Collections.sort();
class Plural implements Comparable<Plural> {
	public int partA;
	public int partB;
	public Plural(int partA, int partB) {
		super();
		this.partA = partA;
		this.partB = partB;
	}
	
@Override
public int compareTo(Plural o) {
		int i=partA*partA+partB*partB-o.partA*o.partA-o.partB*o.partB;
		if(i==0)
		 return this.partB-o.partB;	
			
		return i;
	}
}