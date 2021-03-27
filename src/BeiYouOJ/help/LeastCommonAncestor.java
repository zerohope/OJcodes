package help;

import java.io.BufferedInputStream;
import java.util.Scanner;
import java.util.Stack;

public class LeastCommonAncestor {

	public static void main(String[] args) {
		Scanner sc=new Scanner(new BufferedInputStream(System.in));
		int tms=sc.nextInt();
		while(tms>0) {
			int[] tree=new int[sc.nextInt()+1];
			tree[1]=1;
			for(int i=2;i<tree.length;i++) {
				int f=sc.nextInt();
				int s=sc.nextInt();
				tree[s]=f;
			}
			int s=sc.nextInt();
			while(s>0) {
			int a=sc.nextInt();
			int b=sc.nextInt();
			search(tree,a,b);
			s--;
			}tms--;
		}
         sc.close();
	}
    public static void search(int[] tr, int a, int b) {
    	Stack<Integer> s1=new Stack<Integer>();
    	Stack<Integer> s2=new Stack<Integer>();
    	s1.push(a);
    	s2.push(b);
    	while(tr[a]!=a) {
    		s1.push(tr[a]);
    		a=tr[a];
    	}
    	while(tr[b]!=b) {
    		s2.push(tr[b]);
    		b=tr[b];
    	}
    	int flag=0;
        while(!s1.isEmpty()&&!s2.isEmpty()&&s1.peek()==s2.peek()) {
        	flag=s1.peek();
        	s1.pop();
        	s2.pop();
        }
    	
    	System.out.println(flag);
    	
    }
}
