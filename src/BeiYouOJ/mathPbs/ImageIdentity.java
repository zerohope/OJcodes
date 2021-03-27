package mathPbs;

import java.io.BufferedInputStream;
import java.util.Scanner;
import java.util.Stack;

public class ImageIdentity {
    static	int[][] dir=new int[][] {{-1,-1},{-1,0},{-1,1},{0,-1},{0,1},{1,-1},{1,0},{1,1}};
	public static void main(String[] args) {
	Scanner sc=new Scanner(new BufferedInputStream(System.in));	
		int tms=sc.nextInt();
		int[] ends=new int[tms];
        for(int i=0;i<tms;i++) {
    	  int x=sc.nextInt();
    	  int y=sc.nextInt();
    	  int sz=sc.nextInt();
          points[][] img=new points[x][y];
          for(int j=0;j<x;j++)
        	  for(int k=0;k<y;k++)
    	          img[j][k]=new points(j,k,sc.nextInt(),0);
          
          
         ends[i]=DFS(img,sz);
          
     }
        
        
        for(int i=0;i<tms;i++)
        	System.out.println(ends[i]);
        
        sc.close();
	}

	public static int DFS(points[][] img,int size) {
		Stack<points> s=new Stack<points>();
		int end=0;
		int x=img.length;
		int y=img[0].length;
        int a=0,b=0;
		for(int i=0;i<x;i++)
		   for(int j=0;j<y;j++)
			  if(s.isEmpty()&&img[i][j].area==0) {
				 s.push(img[i][j]);
				 img[i][j].area=1;
				 while(!s.isEmpty()) {
					 points p=s.pop();
					  int vl=p.v; 
					   for(int k=0;k<8;k++) {
						   a=p.x+dir[k][0];
						   b=p.y+dir[k][1];
						   if(a>=0&&a<x&&b>=0&&b<y) {
							 if(Math.abs(img[a][b].v-vl)<=size&&img[a][b].area==0) {
						             s.push(img[a][b]);
						             img[a][b].area=1; 
							   }
						   }
					   }
				   }
				   end+=1;
			   }
		return end;
	}

}

class points{
	public int x;
	public int y;
	public int v;
	public int area;
	public points(int x, int y, int v, int a) {
		this.x = x;
		this.y = y;
		this.v=v;
		this.area=a;
	}
	
	
	
	
}

