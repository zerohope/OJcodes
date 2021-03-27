package TreePbs;

import java.io.BufferedInputStream;
import java.util.PriorityQueue;
import java.util.Scanner;

//优先队列
public class Huffmantree {

	public static void main(String[] args) {
		Scanner sc=new Scanner(new BufferedInputStream(System.in));
        PriorityQueue<Integer> pq=new PriorityQueue<Integer>();
        int nb=sc.nextInt();
        while(nb>0) {
        	pq.add(sc.nextInt());
        	nb--;
        }
        int end=0;
        while(!pq.isEmpty()) {
        	int a,b=0;
        	a=pq.poll();
        	if(!pq.isEmpty())
        	 b=pq.poll();
        	else
        		break;
        	end+=a+b;
        	pq.add(a+b);
        }
        System.out.println(end);
        
	}

}
