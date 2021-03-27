package map;

import java.io.BufferedInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StatisticsNodes {

	public static void main(String[] args) {
		Scanner sc=new Scanner(new BufferedInputStream(System.in));
	    int tms=sc.nextInt();
	    int[] ends=new int[tms];
	    for(int i=0;i<tms;i++) {
	    	int nb=0;
	    	int size=sc.nextInt();
	     	Node[] nds=new Node[size];
	    for(int j=0;j<size;j++) {
	    	nds[j]=new Node();  
	    }
         for(int l=1;l<size;l++) {
	     	int fa=sc.nextInt();
	     	int cd=sc.nextInt();
	     	nds[fa].setChild(nds[cd]);
	     	nds[cd].setFather(nds[fa]);
	    }
        for(int k=0;k<size;k++) {
        	if(nds[k].check())
        		nb++;
        }
          ends[i]=nb;
	    }
	   for(int i=0;i<tms;i++)
		   System.out.println(ends[i]);
    sc.close();
	}

}
class Node{
	public Node father;
	public List<Node> children;
	
	public int getValue() {
		if(this.father!=null)
		return this.children.size()+1;
		return this.children.size();
	} 
	public Node() {
		father=null;
		children=new ArrayList<Node>();
	}
	public void setFather(Node n) {
		this.father=n;
	}
	public void setChild(Node n) {
		this.children.add(n);
	}
	public boolean check() {
		int childV=0;
		int Pvalue=0;
		int value=this.getValue();
		if(this.father!=null) {
			Pvalue=this.father.getValue();
		}
		for(int i=0;i<children.size();i++) {
			int temp=children.get(i).getValue();
			if(temp>childV) {
			childV=temp;
			}
		}
		if(value>=childV&&value>=Pvalue)
			return true;
		return false;
	}
	
}