package leetcode;

import java.io.BufferedInputStream;

import java.util.Scanner;

public class DPCutBZ {
	public static void main(String[] args) {
          Scanner sc=new Scanner(new BufferedInputStream(System.in));
          int time=sc.nextInt();
          int amount=sc.nextInt();
          herb[] hbs=new herb[amount];
          for(int i=0;i<amount;i++) {
        	  hbs[i]=new herb(sc.nextInt(),sc.nextInt());
          }
          System.out.println(dfs(time,hbs));
	}
	public static int dfs(int time,herb[] hbs) {
		if(time<=0) {
			return 0;
		}
		int rs=0;
		for(int i=0;i<hbs.length;i++) {
		   if(time-hbs[i].time>=0&&hbs[i].flag==0) {
	         hbs[i].flag=1;
              rs=Math.max(rs, dfs(time-hbs[i].time, hbs)+hbs[i].value);
              hbs[i].flag=0;
			}
		}
		return rs;
}
		
}
class herb{
	int time;
	int value;
	int flag;
	public herb(int t, int v) {
		this.time=t;
		this.value=v;
	}
	
	
	
}
