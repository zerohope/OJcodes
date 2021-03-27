package map;

import java.io.BufferedInputStream;
import java.util.Scanner;

public class NetCore {

	public static void main(String[] args) {
		Scanner sc=new Scanner(new BufferedInputStream(System.in));
		int loop=sc.nextInt();	
		while(loop>0) {
			int m=sc.nextInt();
			int n=sc.nextInt(); 
			int[][] dist=new int[m+1][m+1];
			int[] totaldist=new int[m+1];
			for(int i=1;i<dist.length;i++)
				for(int j=1;j<dist.length;j++) {
					if(i==j) {
						dist[i][j]=0;
					}else {
						dist[i][j]=Integer.MAX_VALUE;
					}
				}
			for(int i=0;i<n;i++) {
				int thisNode=sc.nextInt();
				int nextNode=sc.nextInt();
				dist[thisNode][nextNode]=dist[nextNode][thisNode]=1;
			}
			int ndist=0;
			for(int k=1;k<dist.length;k++)
				for(int i=0;i<dist.length;i++)
					for(int j=0;j<dist.length;j++) {
						if(i==k||j==k)
						 continue;
						if(dist[i][k]==Integer.MAX_VALUE||dist[k][j]==Integer.MAX_VALUE) 
							ndist=Integer.MAX_VALUE;
						else 
							ndist=dist[i][k]+dist[j][k];
						if(ndist<dist[i][j])
							dist[i][j]=ndist;
					}
			
			  for(int i=1;i<dist.length;i++)
				  for(int j=1;j<dist.length;j++) {
					  if(dist[i][j]==Integer.MAX_VALUE)
						  totaldist[i]+=dist.length-1;
					  else
						  totaldist[i]+=dist[i][j];
				  }
			  int minV=1;
			  for(int i=1;i<dist.length;i++) {
				  if(totaldist[i]<totaldist[minV])
				    minV=i;
			  }
					  System.out.println(minV);
		   loop--;
		}

	}

}
