package help;

import java.io.BufferedInputStream;
import java.util.Scanner;
import java.util.Stack;

public class ProcessManagement {
	public static void main(String[] args) {
	Scanner sc=new Scanner(new BufferedInputStream(System.in));
    int[] pro=new int[101];
    for(int i=0;i<pro.length;i++)
    	pro[i]=-1;
	 int tms=sc.nextInt();
	 for(int i=0;i<tms;i++) {
		int ops=sc.nextInt(); 
		sc.nextLine();
		while(ops>0) {
		 processOpt(pro,sc.nextLine());	
		ops--;
		 }
	    for(int j=0;j<pro.length;j++)
	    	pro[j]=-1;
	 }
	sc.close();
	}
	
public static void processOpt(int[] pro, String od) {
		String[] ops=od.split(" ");
		if(ops[0].equals("FORK")) {
			int father=Integer.parseInt(ops[1]);
			int son=Integer.parseInt(ops[2]);
			pro[son]=father;
		} else if(ops[0].equals("KILL")) {
			int key=Integer.valueOf(ops[1]);
				KillPro(pro,key);
		}else if(ops[0].equals("QUERY")) {
		int key=Integer.valueOf(ops[1]); 
		   if(pro[key]!=-1||key==0) {
			System.out.println("Yes");
			}else {
			System.out.println("No");
			}
		}
		}

public static void KillPro(int[] pro, int key) {
	  pro[key]=-1;
	  Stack<Integer> s=new Stack<Integer>();
	  s.push(key);
	  while(!s.isEmpty()) {
		  int kvalue=s.pop();
       for(int i=1;i<pro.length;i++) {
	   if(pro[i]==kvalue) {
		   pro[i]=-1;
            s.push(i);
	   }
 }
	  }
}
}


