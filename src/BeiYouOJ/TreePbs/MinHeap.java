package TreePbs;

import java.io.BufferedInputStream;
import java.util.Scanner;


//输出Yes不是yes啊！！！
public class MinHeap {
	public static void main(String[] args) {
     Scanner sc=new Scanner(new BufferedInputStream(System.in));		
     int tms=sc.nextInt();
     String[] ends=new String[tms];
     int flag=0;
     for(int i=0;i<tms;i++) {
    	 int nsize=sc.nextInt();
    	 Node[] ns=new Node[nsize+1];
    	 ns[0]=new Node(-1);
    	 for(int j=1;j<nsize+1;j++)
    	 ns[j]=new Node(sc.nextInt());
    	 while(nsize>1) {
    		ns[sc.nextInt()].addCv(ns[sc.nextInt()]);
    		 nsize--;
    	 }
    	 for(int j=1;j<ns.length;j++) {
    		 if(ns[j].check()) {
                 continue;
    		 }else {
    			 flag=1;
    			 break;
    		 } 
    	 }
    	 if(flag==0) {
    		 ends[i]="Yes";
    	 }else {
    		ends[i]="No";
    	 }
    	 flag=0;
     }
     for(int i=0;i<ends.length;i++)
    	 System.out.println(ends[i]);
     sc.close();
	}
}

//判断最小堆，最大堆，每个结点只存最大或者最小的子结点
class Node{
	public int value;
	public int childV;
	public Node(int value) {
		this.value = value;
		this.childV = 0;
	}
	public void addCv(Node n) {
		if(this.childV==0) {
			this.childV=n.value;
		}else {
			if(this.childV>n.value)
				this.childV=n.value;
		}
	}
	public boolean check(){
		if(this.childV>=this.value||this.childV==0) {
			return true;
		}
		return false;
	}
}